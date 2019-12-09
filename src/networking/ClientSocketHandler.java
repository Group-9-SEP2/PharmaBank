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
                String response = (String) inFromServer.readObject();
                String[] responseDivided = response.split("|GAP|");
                if(responseDivided[0].equals("Login")){
                    loginHandling(responseDivided);
                }

            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void sendToServer(String command){
        try {
            outToServer.writeObject(command);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loginHandling(String[] responseDivided){
        try {
            if(responseDivided[1].equals("bad"))
                client.getLogin().badLogin();
            else{
                Object object = inFromServer.readObject();
                if(object instanceof User){
                    User adminUser = (User) object;
                    client.getAdmin().getAccess();
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
