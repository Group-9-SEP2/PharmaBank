package viewmodel;

import model.ModelFactory;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    //private AllTasksVM allTasksVM;
    //private AddTaskVM addTaskVM;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
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
