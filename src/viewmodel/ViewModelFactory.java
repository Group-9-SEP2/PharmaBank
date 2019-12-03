package viewmodel;

import model.ModelFactory;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    //private ExampleVM exampleVM;
    //private AddTaskVM addTaskVM;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }
/*
    COPY and change THIS METHOR WHEN MAKING NEW FXML view
    public ExampleVM getExampleVM() {
        if(exampleVM == null)
            exampleVM = new ExampleVM(modelFactory.getExampleModel());
        return exampleVM;
    }

    public AddTaskVM getAddTaskVM() {
        if(addTaskVM == null) addTaskVM = new AddTaskVM(modelFactory.getTaskModel());
        return addTaskVM;
    }

 */
}
