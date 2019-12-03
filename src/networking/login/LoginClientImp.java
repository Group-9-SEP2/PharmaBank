package networking.login;

import model.LoginModel;
import networking.ClientSocketHandler;
import networking.login.LoginClient;

public class LoginClientImp implements LoginClient {
    private LoginModel model;
    private ClientSocketHandler socketHandler;

    public LoginClientImp(ClientSocketHandler csh, LoginModel model){
        this.model = model;
        model.setClient(this);
        this.socketHandler = csh;
    }


    @Override
    public void Login(String username, String password) {
        String sending = "Login" + "|GAP|" + username + "|GAP|" + password;
        socketHandler.sendToServer(sending);
    }

    public void loginSuccesStatus(String status){
        model.loginStatus(status);
    }


}
