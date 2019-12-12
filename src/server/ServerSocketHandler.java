package server;

import server.persistance.UserDAOImp;
import shared.User;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {
    private UserDAOImp user;
    private Socket socket;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public ServerSocketHandler(Socket socket, UserDAOImp user){
        this.socket = socket;
        this.user = user;
        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
        user.addPropertyChangeListener("Login", evt -> LoginStatus(evt));
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
        try {
            if(user.checkLogin(dividedFromClient[1], dividedFromClient[2])){
                User userInfo = user.getUser();
                outToClient.writeObject("Login");
                outToClient.writeObject(userInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // other user if if(bla)

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

