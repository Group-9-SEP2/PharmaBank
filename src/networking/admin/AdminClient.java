package networking.admin;

import model.admin.AdminModel;
import shared.User;

public interface AdminClient {
    void getAccess(User user);
    void setModel(AdminModel model);
}
