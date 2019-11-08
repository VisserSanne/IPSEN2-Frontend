package nello.controller;

import nello.model.LoginModel;
import nello.observer.LoginObserver;
import nello.view.UserRegistrationView;

import javax.ws.rs.core.Response;

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
        HTTPController http = mainController.getHttpController();
        // http request check email exist/user whitelisted.
        Response response = http.post("/login/email", model.getCredential());
        switch (response.getStatus()) {
            case 200: // status OK
                model.clearMessage();
                model.setCurrentPhase(LoginModel.Phase.PASSWORD);
                break;
            case 401: // status UNAUTHORIZED
                model.setMessage("Het ingevoerde e-mailadres bestaat niet.");
                break;
            case 403: // status FORBIDDEN
                model.setMessage("De toegang is geweigerd. Neem gerust contact op met de administrator.");
                break;
        }
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
        HTTPController http = mainController.getHttpController();
        Response response = http.post("/login", model.getCredential());
        switch (response.getStatus()) {
            case 200: // status OK
                model.clearMessage();
                String token = response.readEntity(String.class);
                System.out.println(String.format("acquired login token: %s", token));
//                http.register(HTTPAuthorizationHeader.class);
                break;
            case 401: // status UNAUTHORIZED
                model.setMessage("Het ingevoerde e-mailadres bestaat niet.");
                break;
            case 403: // status FORBIDDEN
                model.setMessage("De toegang is geweigerd. Neem gerust contact op met de administrator.");
                break;
        }

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

    public void onRegisterButtonClick() {
        mainController.getStageController().displayView(new UserRegistrationView());
    }
}
