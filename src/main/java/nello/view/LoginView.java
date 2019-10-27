package nello.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import nello.controller.LoginController;
import nello.model.LoginModel;
import nello.observable.LoginObservable;
import nello.observer.LoginObserver;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginView extends AbstractFXMLView<LoginController> implements LoginObserver {

    @FXML
    private BorderPane root;

    @FXML
    private Label mainMessage;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField textField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label resetPasswordLabel;

    @FXML
    private Button backToEmailButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button nextButton;
    private boolean command;


    public LoginView() {
        super(FXMLView.LOGIN);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getController().registerObserver(this);

        // clear all textfields
        this.errorMessage.setText("");
        this.textField.setText("");
        this.passwordField.setText("");

        // remove focus from textfield
        this.textField.setFocusTraversable(false);
    }

    public void onTextFieldChange(KeyEvent keyEvent) {
        // if ctrl is down ignore all
        if (keyEvent.isControlDown())
            return;

        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.TAB) {
            this.onNextButtonClick();
            return;
        }
//        System.out.println(textField.getText());
        getController().onEmailChange(textField.getText());
    }

    public void onPasswordFieldChange(KeyEvent keyEvent) {
        // if ctrl is down ignore all
        if (keyEvent.isControlDown())
            return;

        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.TAB) {
            this.onLoginButtonClick();
            return;
        }
        getController().onPasswordChange(passwordField.getText());
    }

    public void onResetButtonClick(MouseEvent mouseEvent) {
        getController().onResetButtonClick();
    }

    public void onRegisterButtonClick(MouseEvent mouseEvent) {
        System.out.println("clicked on register");
    }

    public void onLoginButtonClick() {
        getController().onLoginButtonClick();
    }

    public void onNextButtonClick() {
        getController().onNextButtonClick();
    }

    public void onBackToEmail() {
        getController().onBackToEmail();
    }

    @Override
    public void update(LoginObservable observable) {
        System.out.println("updateding view");

        this.errorMessage.setText(observable.getErrorMessage().toString());
        System.out.println(observable.getCredentials().getEmailAdders());
        System.out.println(observable.getCredentials().getPassword());

        // update email field
        textField.setText(observable.getCredentials().getEmailAdders());
        textField.positionCaret(textField.getText().length());


        // update password field
        passwordField.setText(observable.getCredentials().getPassword());
        passwordField.positionCaret(passwordField.getText().length());

        // update phase
        onPhaseChange(observable.getCurrentPhase());

    }

    private void onPhaseChange(LoginModel.Phase currentPhase) {
        switch (currentPhase) {
            case EMAIL:
                toggleEmailStage(true);
                toggleStagePassword(false);
                textField.setFocusTraversable(true);
                break;
            case PASSWORD:
                toggleEmailStage(false);
                toggleStagePassword(true);
                passwordField.setFocusTraversable(true);
                break;
        }
    }

    private void toggleEmailStage(boolean isVisible) {
        textField.setVisible(isVisible);
        nextButton.setVisible(isVisible);
        registerButton.setVisible(isVisible);
    }

    private void toggleStagePassword(boolean isVisible) {
        passwordField.setVisible(isVisible);
        loginButton.setVisible(isVisible);
        backToEmailButton.setVisible(isVisible);
    }
}
