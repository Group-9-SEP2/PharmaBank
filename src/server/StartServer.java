package server;

import server.databasestuff.DatabaseConnection;
import server.databasestuff.AdminDAOImp;

public class StartServer {
    public static void main(String[] args) {
        DatabaseConnection database = new DatabaseConnection();
        //PlaceholderDAO admin = new PlaceholderDAO(database);
        AdminDAOImp login = new AdminDAOImp(database);
        SocketServer server = new SocketServer(login);
    }
}
