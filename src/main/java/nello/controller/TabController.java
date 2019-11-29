package nello.controller;

import nello.model.TabModel;
import nello.model.User;
import nello.observer.TabObserver;
import nello.view.DashboardView;

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

    public void onUserTabClick() {
        User[] userList = mainController.getUserController().listUsers();
        mainController.getUsersTabController().getUsersTabModel().setUserList(userList);
    }

    public void onTagTabClick() {
        // todo add missing code
    }

    public void onDashboardClick() {
        mainController.getStageController().displayView(new DashboardView());
    }

    public void registerObserver(TabObserver o) {
        tabModel.registerObserver(o);
    }
}
