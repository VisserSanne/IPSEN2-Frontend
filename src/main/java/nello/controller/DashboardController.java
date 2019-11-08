package nello.controller;

import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.Pane;
import nello.model.DashboardModel;
import nello.observer.DashboardObserver;
import nello.view.ProfileView;
import nello.view.TabView;
import nello.view.UsersTabView;

public class DashboardController implements IController {
    private MainController mainController;
    private DashboardModel dashboardModel;

    @FXML
    public SplitMenuButton menu;

    public DashboardController(MainController mainController, DashboardModel dashboardModel) {
        this.mainController = mainController;
        this.dashboardModel = dashboardModel;
    }

    public void onProfileClick() {
        Pane usersTabView = mainController.getStageController().getRoot(new UsersTabView());
        Pane profileView = mainController.getStageController().getRoot(new ProfileView());
        mainController.getTabController().getTabModel().setActiveTab("profile");
        mainController.getStageController().displayView(new TabView(profileView, usersTabView));
    }

    public void onGebruikersClick() {
        Pane usersTabView = mainController.getStageController().getRoot(new UsersTabView());
        Pane profileView = mainController.getStageController().getRoot(new ProfileView());
        mainController.getTabController().getTabModel().setActiveTab("gebruikers");
        mainController.getStageController().displayView(new TabView(profileView, usersTabView));
    }

    /**
     * Register observers to model.
     *
     * @param observer {@link DashboardObserver} login observer.
     */
    public void registerObserver(DashboardObserver observer) {
        dashboardModel.registerObserver(observer);
    }
}
