package viewmodel;

import model.ModelFactory;
import viewmodel.login.LoginVM;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginVM loginVM;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginVM getLoginVM() {
        if(loginVM == null)
            loginVM = new LoginVM(modelFactory.getLoginModel());
        System.out.println(passed);
        return loginVM;
    }
}
