package nello.view;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import nello.controller.MainController;
import nello.controller.TabController;

import java.net.URL;
import java.util.ResourceBundle;

public class TabView implements FXMLView<TabController>, Initializable {
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

    public void onTabChange(Event event) {
        if (profile.isSelected()) {
            getController().onProfileTabClick();
        } else if (gebruikers.isSelected()) {
            System.out.println("gebuikers");
        } else if (tags.isSelected()) {
            System.out.println("tags");
        }
    }
}
