package networking.admin;

import model.admin.AdminModel;
import networking.ClientSocketHandler;
import shared.User;

public class AdminClientImp implements AdminClient {
    private ClientSocketHandler socketHandler;
    private AdminModel model;

    public AdminClientImp(ClientSocketHandler csh) {
        this.model = model;
        this.socketHandler = csh;
    }

    @Override
    public void getAccess(User user) {
        System.out.println(user.getUsername() + "in admin client");
        System.out.println("got admin user, now i can do shit");
    }

    @Override
    public void setModel(AdminModel model) {

    }
}
