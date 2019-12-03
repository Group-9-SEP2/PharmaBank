package server;

import server.databasestuff.AdminDAO;
import server.databasestuff.DatabaseConnection;
import server.databasestuff.LoginDAO;

public class StartServer {
    public static void main(String[] args) {
        DatabaseConnection database = new DatabaseConnection();
        AdminDAO admin = new AdminDAO(database);
        LoginDAO login = new LoginDAO(database);
        SocketServer server = new SocketServer(admin, login);
    }
}
