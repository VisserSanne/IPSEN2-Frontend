package nello.controller;

import nello.model.TabModel;
import nello.model.User;
import nello.observer.TabObserver;
import nello.view.DashboardView;

import java.util.List;

public class TabController implements IController {
    private final MainController mainController;
    private final TabModel tabModel;

    public TabController(MainController mainController, TabModel tabModel) {
        this.mainController = mainController;
        this.tabModel = tabModel;
    }

    public TabModel getTabModel() {
        return tabModel;
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

    public void onDashboardClick() {
        mainController.getStageController().displayView(new DashboardView());

    }

    public void registerObserver(TabObserver o) {
        tabModel.registerObserver(o);
    }
}
