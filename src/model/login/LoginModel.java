package model.login;
import networking.login.LoginClientImp;

public interface LoginModel {
    void login(String username, String password);
    void loginStatus(String status);
    String getServerResponse();
}
