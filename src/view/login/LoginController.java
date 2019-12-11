package view.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewmodel.login.LoginVM;

public class LoginController {
    @FXML
    private PasswordField passWordText;
    @FXML
    private TextField userNameText;

    private ViewHandler viewHandler;
    private LoginVM viewModel;

    public void onHelpButton(ActionEvent actionEvent) {
    }

    public void onLoginButton(ActionEvent actionEvent) {
    }

    public void init(LoginVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        userNameText.textProperty().bindBidirectional(vm.usernameStringProperty());
        passWordText.textProperty().bindBidirectional(vm.passwordStringProperty());
    }
}

 
