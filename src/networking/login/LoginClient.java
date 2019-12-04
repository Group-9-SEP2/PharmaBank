package networking.login;

public interface LoginClient {
    void Login(String username, String password);
    void loginSuccesStatus(String response);
    void badLogin();
}
