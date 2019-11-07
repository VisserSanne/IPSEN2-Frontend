package nello;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import nello.controller.DashboardController;
import nello.controller.MainController;
import nello.controller.StageController;
import nello.model.NetworkMember;
import nello.model.User;
import nello.model.UserRole;
import nello.view.DashboardView;
import nello.view.FXMLView;
import nello.view.ProfileView;
import nello.view.TabView;

import java.util.Date;


public class Nello {

    private final static String APP_NAME = "Nello";
    private final static String VERSION = "v1.0";

    // define start view
    private final static FXMLView<DashboardController> START_VIEW = new DashboardView();

    private MainController mainController;

    public Nello() {
        this.mainController = MainController.getInstance();
    }

    public void shine(Stage primaryStage) {
        primaryStage.setTitle(String.format("%s %s", APP_NAME, VERSION));
        StageController stageController = mainController.getStageController();
        stageController.prepareStage(primaryStage);
        stageController.displayView(START_VIEW);

        User u = new User(1,
                new NetworkMember(1, "Ashna", "Wiar", false),
                "Ashna_wiar@hotmail.com", "", UserRole.GUEST, new Date());
        mainController.getProfileController().setUser(u);
        System.out.println("getting view");
        FXMLView profileView = new ProfileView();
        System.out.println("before load");
        Pane root = mainController.getStageController().getRoot(profileView);
        System.out.println("afther load");
        TabView tabView = new TabView(root);

        stageController.displayView(tabView);

    }

    public void shine() {
        mainController.getStageController().show();
    }

    public void close() {
        mainController.getStageController().close();
    }
}
