package model;

import model.admin.AdminModel;
import model.admin.AdminModelImp;
import model.login.LoginModel;
import model.login.LoginModelImp;
import networking.ClientFactory;

public class ModelFactory {
    private ClientFactory clientFactory;
    private LoginModel loginModel;
    private AdminModel adminModel;

    public ModelFactory(ClientFactory cf) {
        clientFactory = cf;
    }

    public LoginModel LoginModel() {
        if(loginModel == null)
            loginModel = new LoginModelImp(clientFactory.getLoginClient());
        return loginModel;
    }

    public AdminModel AdminModel() {
        if(adminModel == null)
            adminModel = new AdminModelImp(clientFactory.getAdminClient());
        return adminModel;
    }
}
