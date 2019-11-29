package nello.controller;

import nello.model.NetworkMember;
import nello.model.User;
import nello.model.UserRole;
import nello.view.AlertBox;

import javax.ws.rs.core.Response;
import java.util.logging.Level;

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

        Response response = mainController.getHttpController().post("/users", user);
        System.out.println(response.readEntity(String.class));
    }

    public User[] listUsers() {
        HTTPController http = new HTTPController();
        Response response = http.get("/users");
        switch (response.getStatus()) {
            case 200:
                return response.readEntity(User[].class);
        }

        return new User[0];
    }

    public void updateUser(User user) {
        HTTPController http = new HTTPController();
        Response response = http.put("/users/" + user.getId(), user);
        switch (response.getStatus()) {
            case 200:
//                mainController.getStageController().displayPopup(new AlertBox("Profiel succesvol geupdated.", Level.FINE, 3));
//                return true;
//                return response.readEntity(User.class);
            default:
//            mainController.getStageController().displayPopup(new AlertBox("Profiel succesvol geupdated.", Level.WARNING, 3));
//                return false;
        }
    }
}
