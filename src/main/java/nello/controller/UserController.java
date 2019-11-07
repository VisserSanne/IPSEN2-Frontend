package nello.controller;

import nello.model.NetworkMember;
import nello.model.User;
import nello.model.UserRole;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserController {

    private static final String DATA_FOR_RANDOM_STRING = "abcdefghijklmnopqrstuvwxyz";
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

    public static String getRandomString(int length) {
        Random random = new Random();
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);

        }

        return sb.toString();

    }

    public List<User> listUsers() {
        List<User> usersList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            usersList.add(getRandomUser(i));
        }
        return usersList;

    }

    private User getRandomUser(long id) {
        return new User(new NetworkMember(getRandomString(10), Math.random() > 0.5), "", "", UserRole.GUEST);

    }
}
