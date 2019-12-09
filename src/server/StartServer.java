package server;

import server.databasestuff.DatabaseConnection;
import server.databasestuff.UserDAOImp;

public class StartServer {
    public static void main(String[] args) {
        DatabaseConnection database = new DatabaseConnection();
        //PlaceholderDAO admin = new PlaceholderDAO(database);
        UserDAOImp login = new UserDAOImp(database);
        SocketServer server = new SocketServer(login);
    }
}
