package nello.controller;

import nello.model.NetworkMember;
import nello.model.User;
import nello.model.UserRole;

public class UserController {

    private MainController mainController;

    public UserController(MainController mainController) {
        this.mainController = mainController;
    }

    public void registerUser(String firstname, String lastname, String email, String password) {
        System.out.println("register user come ON!");
        String name = String.format("%s %s", firstname, lastname);
        NetworkMember networkMember = new NetworkMember(name, false);
        User user = new User(networkMember, email, password, UserRole.GUEST);

        mainController.getHttpController().post("/user/create", user);
    }
}
