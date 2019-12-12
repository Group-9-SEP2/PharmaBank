package server.databasestuff;

import shared.User;

public interface UserDAO {
    boolean checkLogin(String username, String pasword);
    User getUser();
}
