package nello;

import javafx.stage.Stage;
import nello.controller.DashboardController;
import nello.controller.MainController;
import nello.controller.StageController;
import nello.view.DashboardView;
import nello.view.FXMLView;


public class Nello {

    private final static String APP_NAME = "Nello";
    private final static String VERSION = "v1.0";

    // define start view
    private final static FXMLView<DashboardController> START_VIEW = new DashboardView();

    private MainController mainController;

    public Nello() {
        this.mainController = MainController.getInstance();
    }

    public void illuminate(Stage primaryStage) {
        primaryStage.setTitle(String.format("%s %s", APP_NAME, VERSION));
        StageController stageController = mainController.getStageController();
        stageController.prepareStage(primaryStage);
        stageController.displayView(START_VIEW);

    }

    public void shine() {
        mainController.getStageController().show();
    }

    public void close() {
        mainController.getStageController().close();
    }
}
