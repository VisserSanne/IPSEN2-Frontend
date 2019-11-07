package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import nello.controller.LoginController;
import nello.controller.MainController;
import nello.model.Credential;
import nello.model.LoginModel;
import nello.observable.LoginObservable;
import nello.observer.LoginObserver;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginView implements FXMLView<LoginController>, LoginObserver, Initializable {

    /**
     * path to fxml file
     */
    private final String fxmlPath;
    /**
     * email input field
     */
    @FXML
    private TextField textfieldEmail;
    /**
     * password input field
     */
    @FXML
    private PasswordField passwordField;
    /**
     * info message
     */
    @FXML
    private Label message;
    /**
     * pane for all email related nodes.
     */
    @FXML
    private Pane emailPane;
    /**
     * pane for all password related nodes.
     */
    @FXML
    private Pane passwordPane;
    /**
     * controller for this view.
     */
    private LoginController controller;

    /**
     * construct a new login view.
     */
    public LoginView() {
        this.fxmlPath = "/view/LoginView.fxml";
        this.controller = MainController.getInstance().getLoginController();
    }

    public void onEmailChange(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            onNextButtonClick();
        }

        if (event.getCode() == KeyCode.TAB) {
            getController().onEmailChange(textfieldEmail.getText());
        }
    }

    public void onPasswordChange(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            onLoginButtonClick();
        }

        if (event.getCode() == KeyCode.TAB) {
            getController().onPasswordChange(textfieldEmail.getText());
        }
    }

    public void onRegisterButtonClick(MouseEvent event) {
        getController().onRegisterButtonClick(event);
    }

    public void onNextButtonClick() {
        getController().onEmailChange(textfieldEmail.getText());
        getController().onNextButtonClick();
    }

    public void onBackButtonClick() {
        getController().onBackButtonClick();
    }

    public void onResetButtonClick() {
        getController().onPasswordResetRequest();
    }

    public void onLoginButtonClick() {
        getController().onPasswordChange(passwordField.getText());
        getController().onLoginButtonClick();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // clear main message
        message.setText("");

        // register to observable
        getController().registerObserver(this);
    }

    @Override
    public void update(LoginObservable observable) {
        updateCredential(observable.getCredentials());
        message.setText(observable.getMessage());
        updatePhase(observable.getCurrentPhase());
    }

    /**
     * update the view based on the phase.
     *
     * @param currentPhase {@link nello.model.LoginModel.Phase} login phase
     */
    private void updatePhase(LoginModel.Phase currentPhase) {
        switch (currentPhase) {
            case EMAIL:
                emailPane.setVisible(true);
                passwordPane.setVisible(false);
                break;
            case PASSWORD:
                emailPane.setVisible(false);
                passwordPane.setVisible(true);
                break;
        }
    }

    /**
     * update login credential in view.
     *
     * @param credentials {@link Credential} login credentials
     */
    private void updateCredential(Credential credentials) {
        this.textfieldEmail.setText(credentials.getEmail());
        this.textfieldEmail.positionCaret(textfieldEmail.getLength());
        this.passwordField.setText(credentials.getPassword());
        this.passwordField.positionCaret(passwordField.getLength());
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

}
