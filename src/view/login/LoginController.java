package view.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewmodel.login.LoginVM;

public class LoginController {
    private ViewHandler viewHandler;
    private LoginVM viewModel;

    public void init(LoginVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        userNameText.textProperty().bindBidirectional(vm.usernameProperty());
        passWordText.textProperty().bindBidirectional(vm.passwordProperty());
    }

    @FXML
    private PasswordField passWordText;

    @FXML
    private TextField userNameText;

    @FXML
    void onLoginButton(ActionEvent event) {

    }
}

 
