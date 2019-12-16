package model.login;
import networking.login.LoginClientImp;
import shared.PropertyChangeSubject;

public interface LoginModel extends PropertyChangeSubject {
    void login(String username, String password);
    void loginResponse(String status);
    String getServerResponse();
}
