package server.networking;

import server.model.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public SocketServer(Model serverModel){
        try {
            ServerSocket welcomeSocket = new ServerSocket(3000);
            while(true){
                Socket connectionSocket = welcomeSocket.accept();
                ServerSocketHandler c = new ServerSocketHandler(connectionSocket, serverModel);
                new Thread(c, "Chat user").start();
                System.out.println("Connected");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
