package model;

import networking.admin.AdminClientImp;

public interface AdminModel extends PropertyChangeSubject {
    void setClient(AdminClientImp adminClientImp);

}
