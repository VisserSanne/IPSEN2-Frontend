package nello.controller;

import nello.model.LoginModel;
import nello.model.ViewMessage;
import nello.observer.LoginObserver;

public class LoginController implements IController {

    private final HTTPController httpController;
    private final StageController stageController;
    private LoginModel model;


    public LoginController(HTTPController httpController, StageController stageController, LoginModel model) {
        this.httpController = httpController;
        this.stageController = stageController;
        this.model = model;
    }

    public void registerObserver(LoginObserver observer) {
        model.registerObserver(observer);
    }

    public void onNextButtonClick() {
        model.setErrorMessage(ViewMessage.EMPTY_STRING);
        System.out.println("user tries to login with email");

        if (!model.getCredential().getEmailAdders().isEmpty()) {
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
