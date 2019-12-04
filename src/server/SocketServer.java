package server;

import server.databasestuff.AdminDAOImp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public SocketServer( AdminDAOImp admin){
        try {
            ServerSocket welcomeSocket = new ServerSocket(3000);
            while(true){
                Socket connectionSocket = welcomeSocket.accept();
                ServerSocketHandler c = new ServerSocketHandler(connectionSocket, admin);
                new Thread(c, "Chat user").start();
                System.out.println("Connected");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
