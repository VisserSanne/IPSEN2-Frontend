package nello.controller;

import nello.model.TabModel;
import nello.model.User;

import java.util.List;

public class TabController implements IController {
    private final MainController mainController;
    private final TabModel tabModel;

    public TabController(MainController mainController, TabModel tabModel) {
        this.mainController = mainController;
        this.tabModel = tabModel;
    }

    public void onProfileTabClick() {
        User user = mainController.getUserController().listUsers().get(0);
        mainController.getProfileController().setUser(user);
    }

    public void onUserTabClick() {
        List<User> userList = mainController.getUserController().listUsers();


    }

    public void onTagTabClick() {

    }
}
