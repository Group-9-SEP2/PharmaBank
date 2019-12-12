package server;

import server.persistance.DatabaseConnection;
import server.persistance.UserDAOImp;

public class StartServer {
    public static void main(String[] args) {
        DatabaseConnection database = new DatabaseConnection();
        //PlaceholderDAO admin = new PlaceholderDAO(database);
        UserDAOImp login = new UserDAOImp(database);
        SocketServer server = new SocketServer(login);
    }
}
