package networking.admin;

import model.admin.AdminModel;
import networking.ClientSocketHandler;
import shared.User;

public class AdminClientImp implements AdminClient {
    private ClientSocketHandler socketHandler;
    private AdminModel model;

    public AdminClientImp(ClientSocketHandler csh, AdminModel model) {
        this.model = model;
        model.setClient(this);
        this.socketHandler = csh;
    }

    @Override
    public void getAccess(User user) {

    }
}
