package server.databasestuff;

import shared.Admin;

public interface AdminDAO {
    boolean checkLogin(String username, String pasword);
    Admin getUser();
}
