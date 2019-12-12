package model;
import networking.login.LoginClientImp;

public interface LoginModel {
    void login(String username, String password);
    String getServerResponse();
    void setClient(LoginClientImp loginClientImp);
    void loginStatus(String status);
}
