package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {

    private ViewModelFactory viewModelFactory;
    private Stage mainStage;

    private Scene exampleScene;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        viewModelFactory = vmf;
        mainStage = stage;
    }

    public void start() {
        //openExampleView();
        mainStage.show();
    }
/*
AGAIN EXAMPLE COPY AND CHANGE
    public void openExampleView() {
        FXMLLoader loader = new FXMLLoader();

        if(allTasksScene == null) {
            Parent root = getRootByPath("alltasks/AllTasksView.fxml", loader);
            ExampleController controller = loader.getController();
            controller.init(viewModelFactory.getExampleVM(), this);
            exampleScene = new Scene(root);
        }

        mainStage.setTitle("Example");
        mainStage.setScene(exampleScene);

    }
*/


    private Parent getRootByPath(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return root;
    }
}
