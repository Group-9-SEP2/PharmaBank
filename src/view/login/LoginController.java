package view.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewmodel.login.LoginVM;

import java.awt.event.ActionEvent;

public class LoginController {

    private ViewHandler viewHandler;
    private LoginVM viewModel;

    public void init(LoginVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        userNameText.textProperty().bindBidirectional(vm.usernameProperty());
        passWordText.textProperty().bindBidirectional(vm.passwordProperty());
        response.textProperty().bindBidirectional(vm.loginReponseProperty());
    }

    @FXML
    private Label response;

    @FXML
    private TextField userNameText;

    @FXML
    private TextField passWordText;

    public void onLogin(javafx.event.ActionEvent event) {
        viewModel.login();
    }
}

 
