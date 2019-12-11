package viewmodel;

import model.ModelFactory;
import viewmodel.login.LoginVM;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginVM loginVM;
    //private AddTaskVM addTaskVM;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginVM getLoginVM() {
        if(loginVM == null)
            loginVM = new LoginVM(modelFactory.getLoginModel());
        return loginVM;
    }

/*
    public AllTasksVM getAllTasksVM() {
        if(allTasksVM == null) allTasksVM = new AllTasksVM(modelFactory.getTaskModel());
        return allTasksVM;
    }

    public AddTaskVM getAddTaskVM() {
        if(addTaskVM == null) addTaskVM = new AddTaskVM(modelFactory.getTaskModel());
        return addTaskVM;
        fuck ur mom
    }

 */
}
