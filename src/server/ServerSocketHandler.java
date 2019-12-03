package server;

import server.databasestuff.AdminDAO;
import server.databasestuff.LoginDAO;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {
    private AdminDAO admin;
    private LoginDAO login;
    private Socket socket;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public ServerSocketHandler(Socket socket, AdminDAO admin, LoginDAO login){
        this.socket = socket;
        this.admin = admin;
        this.login = login;
        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
        login.addListener("Login", evt -> LoginStatus(evt));
    }

    @Override
    public void run() {
        try{
            while (true){
                String fromClient = (String) inFromClient.readObject();
                String[] dividedFromClient = fromClient.split("|GAP|");
                if(dividedFromClient[0].equals("Login"))
                    Login(dividedFromClient);
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void Login(String[] dividedFromClient) {
        login.checkLogin(dividedFromClient[1], dividedFromClient[2]);
    }

    private void LoginStatus(PropertyChangeEvent evt){
        try {
            String status = (String) evt.getNewValue();
            outToClient .writeObject(status);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

