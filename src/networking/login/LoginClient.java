package networking.login;

import model.login.LoginModel;

public interface LoginClient {
    void Login(String username, String password);
    String loginSuccesStatus();
    void loginResponse(String response);
    void setModel(LoginModel model);
}
