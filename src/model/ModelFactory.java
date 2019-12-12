package model;

public class ModelFactory {
    private ClientFactory clientFactory;
    private LoginModel loginModel;
    private AdminModel adminModel;

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
