package nello.controller;

import nello.model.LoginModel;
import nello.model.LoginResponce;
import nello.model.ViewMessage;
import nello.observer.LoginObserver;

public class LoginController implements IController {

    private MainController mainController;
    private LoginModel model;

    public LoginController(MainController mainController, LoginModel model) {
        this.mainController = mainController;
        this.model = model;
    }

    public void registerObserver(LoginObserver observer) {
        model.registerObserver(observer);
    }

    public void onNextButtonClick() {
        model.setErrorMessage(ViewMessage.EMPTY_STRING);
        System.out.println("user tries to login with email");

        if (!model.getCredential().getEmail().isEmpty()) {
            // validate if user exist
            model.setCurrentPhase(LoginModel.Phase.PASSWORD);
            model.updatePassword("");
            return;
        }

        model.setErrorMessage(ViewMessage.EMPTY_EMAIL);
    }

    public void onResetButtonClick() {
        System.out.println("user requested password reset");
    }

    public void onLoginButtonClick() {
        System.out.println(String.format("user tries to login with email and password %s", model.getCredential()));
        HTTPController httpController = mainController.getHttpController();

        LoginResponce responce = httpController.post(ResourceRoute.LOGIN, model.getCredential(), LoginResponce.class);
        System.out.println(responce);

    }

    public void onBackToEmail() {
        model.setErrorMessage(ViewMessage.EMPTY_STRING);
        System.out.println("user tries to go back");

        // clear password
        model.updatePassword("");
        model.setCurrentPhase(LoginModel.Phase.EMAIL);

    }

    public void onEmailChange(String text) {
        model.updateEmail(text);
    }

    public void onPasswordChange(String text) {
        model.updatePassword(text);
    }
}
