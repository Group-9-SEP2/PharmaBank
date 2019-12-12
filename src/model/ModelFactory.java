package model;

import Networking.ClientFactory;

public class ModelFactory {
    private LoginModel loginModel;
    private AdminModel adminModel;

    public LoginModel LoginModel() {
        if(loginModel == null)
            loginModel = new LoginModelImp();
        return loginModel;
    }

    public AdminModel AdminModel() {
        if(adminModel == null)
            adminModel = new AdminModelImp();
        return adminModel;
    }
}
