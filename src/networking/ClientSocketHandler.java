package networking;

import shared.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientSocketHandler implements Runnable{

    private ClientFactory client;
    private ObjectInputStream inFromServer;
    private ObjectOutputStream outToServer;

    public ClientSocketHandler(ObjectOutputStream outToClient, ObjectInputStream inFromClient, ClientFactory _client){
        this.client = _client;
        this.outToServer = outToClient;
        this.inFromServer = inFromClient;
    }
    @Override
    public void run() {
        try {
            while (true){
                User fromServer = (User) inFromServer.readObject();
                if(fromServer != null)
                    client.getAdmin();
                else {
                    System.out.println("Wrong username or password");
                    client.getLogin().loginResponse("Wrong username or password");
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void sendToServer(String command){
        try {
            System.out.println(command);
            outToServer.writeObject(command);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
