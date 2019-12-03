package server;

import server.databasestuff.AdminDAO;
import server.databasestuff.LoginDAO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public SocketServer(AdminDAO admin, LoginDAO login){
        try {
            ServerSocket welcomeSocket = new ServerSocket(3000);
            while(true){
                Socket connectionSocket = welcomeSocket.accept();
                ServerSocketHandler c = new ServerSocketHandler(connectionSocket, admin, login);
                new Thread(c, "Chat user").start();
                System.out.println("Connected");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
