package nello.controller;

import nello.model.LoginModel;
import nello.observer.LoginObserver;

public class LoginController implements IController {

    private MainController mainController;
    private LoginModel model;


    public LoginController(MainController mainController, LoginModel model) {
        this.mainController = mainController;
        this.model = model;
    }

    /**
     * Register observers to model.
     *
     * @param observer {@link LoginObserver} login observer.
     */
    public void registerObserver(LoginObserver observer) {
        model.registerObserver(observer);
    }

    /**
     * check if email is allowed to login, and update phase if needed.
     */
    public void onNextButtonClick() {
        // http request check email exist/user whitelisted.
        model.setCurrentPhase(LoginModel.Phase.PASSWORD);
    }

    /**
     * switch view to 'PasswordResetView'
     */
    public void onResetButtonClick() {
        System.out.println("user requested password reset");
    }

    /**
     * send login request to API.
     */
    public void onLoginButtonClick() {
        System.out.println(String.format("user tries to login with email and password %s", model.getCredential()));
        model.setMessage("Inloggen is helaas nog niet mogelijk, probeer het bij trello");
    }

    /**
     * update model phase, reset fields.
     */
    public void onBackButtonClick() {
        model.setPassword("");
        model.setMessage("");
        model.setCurrentPhase(LoginModel.Phase.EMAIL);
    }

    /**
     * update email in model.
     *
     * @param email {@link String} new email
     */
    public void onEmailChange(String email) {
        model.setEmailAddress(email);
    }

    /**
     * update password in model
     *
     * @param password {@link String} new password
     */
    public void onPasswordChange(String password) {
        model.setPassword(password);
    }

    /**
     * send recovery mail to user through API.
     */
    public void onPasswordResetRequest() {
        // http email reset mail.
    }
}
