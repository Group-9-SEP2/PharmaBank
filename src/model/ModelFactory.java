package model;

public class ModelFactory {

    private PharmaModel taskModel;

    public PharmaModel getPharmaModel() {
        if(taskModel == null)
            taskModel = new PharmaModelManager();
        return taskModel;
    }
}
