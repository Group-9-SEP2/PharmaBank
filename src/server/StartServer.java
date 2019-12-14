package server;

import server.model.Model;
import server.model.ModelImp;
import server.networking.SocketServer;
import server.persistance.DatabaseConnection;
import server.persistance.User.UserDAO;
import server.persistance.User.UserDAOImp;

public class StartServer {
    public static void main(String[] args) {
        DatabaseConnection database = new DatabaseConnection();
        UserDAO user = new UserDAOImp(database);
        Model serverModel = new ModelImp(user);
        SocketServer server = new SocketServer(serverModel);
    }
}
