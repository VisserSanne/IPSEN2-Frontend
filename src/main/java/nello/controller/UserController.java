package nello.controller;

public class UserController {

    private MainController mainController;

    public UserController(MainController mainController) {
        this.mainController = mainController;
    }

    public void registerUser(String firstname, String lastname, String email) {
        System.out.println("register user come ON!");
    }
}
