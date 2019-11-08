package nello.view;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import nello.controller.MainController;
import nello.controller.TabController;
import nello.observable.TabObservable;
import nello.observer.TabObserver;

import java.net.URL;
import java.util.ResourceBundle;

public class TabView implements FXMLView<TabController>, Initializable, TabObserver {
    /**
     * path to fxml file
     */
    private final String fxmlPath;

    public Tab profile;
    public Tab gebruikers;
    public Tab tags;
    private Node profileView;

    /**
     * controller for this view.
     */
    private TabController controller;

    public TabView(Node profileView) {
        this.fxmlPath = "/view/TabView.fxml";
        this.controller = MainController.getInstance().getTabController();
        this.profileView = profileView;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profile.setContent(profileView);
        getController().registerObserver(this);
    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public TabController getController() {
        return controller;
    }

    @Override
    public void setController(TabController controller) {

    }

    public void onDashboardClick() {
        getController().onDashboardClick();
    }

    public void onTabChange(Event event) {
        if (profile.isSelected()) {
            getController().onProfileTabClick();
        } else if (gebruikers.isSelected()) {
            System.out.println("gebruikers");
        } else if (tags.isSelected()) {
            System.out.println("tags");
        }
    }

    @Override
    public void update(TabObservable o) {
        switch (o.getActiveTab()) {
            case "gebruikers":
                gebruikers.getTabPane().getSelectionModel().select(gebruikers);
                break;
            case "profile":
                profile.getTabPane().getSelectionModel().select(profile);
                break;
        }
    }
}
