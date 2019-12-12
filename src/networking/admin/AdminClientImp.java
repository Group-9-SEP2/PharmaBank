package networking.admin;

import model.AdminModel;
import networking.ClientSocketHandler;

public class AdminClientImp implements AdminClient {
    private ClientSocketHandler socketHandler;
    private AdminModel model;

    public AdminClientImp(ClientSocketHandler csh, AdminModel model) {
        this.model = model;
        model.setClient(this);
        this.socketHandler = csh;
    }
}
