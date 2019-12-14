package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.login.LoginController;
import viewmodel.ViewModelFactory;
import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Stage mainStage;
    private Scene loginScene;


    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        viewModelFactory = vmf;
        mainStage = stage;
    }

    public void start() {
        openLoginView();
        mainStage.show();
    }

    public void openLoginView() {
        FXMLLoader loader = new FXMLLoader();
        if(loginScene == null) {
            Parent root = getRootByPath("login/Login.fxml", loader);
            LoginController controller = loader.getController();
            controller.init(viewModelFactory.getLoginVM(), this);
            loginScene = new Scene(root);
        }
        mainStage.setTitle("Login");
        mainStage.setScene(loginScene);
    }

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
