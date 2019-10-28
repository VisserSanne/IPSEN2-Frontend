package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import nello.controller.LoginController;
import nello.controller.MainController;
import nello.model.LoginModel;
import nello.observable.LoginObservable;
import nello.observer.LoginObserver;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginView implements FXMLView<LoginController>, LoginObserver, Initializable, BeforeDisplay {

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

    private final String fxmlPath;
    private LoginController controller;

    public LoginView() {
        this.fxmlPath = "/view/LoginView.fxml";
        this.controller = MainController.getInstance().getLoginController();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller.registerObserver(this);

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
        this.controller.onEmailChange(textField.getText());
    }

    public void onPasswordFieldChange(KeyEvent keyEvent) {
        // if ctrl is down ignore all
        if (keyEvent.isControlDown())
            return;

        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.TAB) {
            this.onLoginButtonClick();
            return;
        }
        this.controller.onPasswordChange(passwordField.getText());
    }

    public void onResetButtonClick(MouseEvent mouseEvent) {
        this.controller.onResetButtonClick();
    }

    public void onRegisterButtonClick(MouseEvent mouseEvent) {
        System.out.println("clicked on register");
    }

    // ik doe dit om de merge zichtbaar te krijgen.
    public void onLoginButtonClick() {
        this.controller.onLoginButtonClick();
    }

    public void onNextButtonClick() {
        this.controller.onNextButtonClick();
    }

    public void onBackToEmail() {
        this.controller.onBackToEmail();
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

    // merge test
    private void toggleStagePassword(boolean isVisible) {
        passwordField.setVisible(isVisible);
        loginButton.setVisible(isVisible);
        backToEmailButton.setVisible(isVisible);
    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public LoginController getController() {
        return controller;
    }

    @Override
    public void setController(LoginController controller) {
        this.controller = controller;
    }

    @Override
    public void beforeShow() {
        System.out.println("called");
    }
}
