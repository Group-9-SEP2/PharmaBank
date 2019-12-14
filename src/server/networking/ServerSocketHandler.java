package server.networking;

import server.model.Model;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {

    private Model serverModel;
    private Socket socket;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public ServerSocketHandler(Socket socket, Model serverModel){
        this.socket = socket;
        this.serverModel = serverModel;
        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
        //user.addPropertyChangeListener("Login", evt -> LoginStatus(evt));
    }

    @Override
    public void run() {
        try{
            while (true){
                String fromClient = (String) inFromClient.readObject();
                String[] dividedFromClient = fromClient.split("/");
                if(dividedFromClient[0].equals("Login"))
                    serverModel.login(dividedFromClient[1], dividedFromClient[2]);
                else if(dividedFromClient[0].equals("Admin")){
                    if(dividedFromClient[1].equals("CreateBuilding"))
                        serverModel.createBuilding();
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
/*
    private void Login(String[] dividedFromClient) {
        System.out.println("inside server");
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
*/
    private void LoginStatus(PropertyChangeEvent evt){
        try {
            String status = (String) evt.getNewValue();
            outToClient .writeObject(status);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

