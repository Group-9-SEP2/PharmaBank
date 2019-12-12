package model;
import networking.login.LoginClientImp;

public interface LoginModel {
    void setClient(LoginClientImp loginClientImp);
    void login(String username, String password);
    void loginStatus(String status);
    String getServerResponse();
}
