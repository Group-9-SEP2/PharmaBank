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
        boolean login = false;
        try {
            while (true){
                Object fromServer = inFromServer.readObject();
                // these 2 check if user is null or acctual user object and assigns it to a client like admin factory...
                if(fromServer instanceof User && fromServer != null){
                    User fromServerUser = (User) fromServer;
                    String[] facility = fromServerUser.getBuildingNo().split("(?!^)");
                    System.out.println();
                    if(fromServerUser.getAccessLevel().equals("admin")){
                        client.getAdmin().getAccess(fromServerUser);
                        System.out.println("got admin");
                        login = true;
                    }else if(facility[0].equals("F")){
                        client.getAdmin().getAccess(fromServerUser);
                        login = true;
                    }
                    else if(facility[0].equals("D")){
                        //client.getFactory().getAccess(fromServerUser);
                        login = true;
                    }
                    else if(facility[0].equals("P")){
                        //client.getParmacy().getAccess(fromServerUser);
                        login = true;
                    }
                }else if(!login && fromServer == null) {
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
