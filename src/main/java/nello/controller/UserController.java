package nello.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nello.model.NetworkMember;
import nello.model.User;
import nello.model.UserRole;

import javax.ws.rs.core.Response;


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

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String userJson = gson.toJson(user);
        System.out.println(userJson);
        Response response = mainController.getHttpController().post("/users", user);
        System.out.println(response.readEntity(String.class));
    }
}
