package nello.controller;

import nello.model.UserRegistrationModel;
import nello.observer.UserRegistrationObserver;

public class UserRegistrationController implements IController {

    private final MainController mainController;
    private UserRegistrationModel model;

    public UserRegistrationController(MainController mainController, UserRegistrationModel model) {
        this.mainController = mainController;
        this.model = model;
    }

    public void onRegisterButtonClick(String firstname, String lastname, String email) {
        model.clearErrors();
        if (!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty()) {
            mainController.getUserController().registerUser(firstname, lastname, email);
            return;
        }
        if (firstname.isEmpty())
            model.setError("Voornaam");

        if (lastname.isEmpty())
            model.setError("Achternaam");

        if (email.isEmpty())
            model.setError("email");


        System.out.println("added errors");
    }


    public void registerObserver(UserRegistrationObserver observer) {
        model.registerObserver(observer);
    }
}
