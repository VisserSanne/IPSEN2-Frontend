package nello;

import javafx.stage.Stage;
import nello.controller.MainController;
import nello.controller.StageController;
import nello.view.FXMLView;

public class Nello {

    private final static String APP_NAME = "Nello";
    private final static String VERSION = "v1.0";

    // define start view
    private final static FXMLView START_VIEW = FXMLView.LOGIN;
    private MainController mainController;

    public Nello() {
        this.mainController = new MainController();
        setup();

    }

    private void setup() {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");
    }

    public void setStage(Stage primaryStage) {
        primaryStage.setTitle(String.format("%s %s", APP_NAME, VERSION));
        StageController stageController = mainController.getStageController();
        stageController.setStage(primaryStage);
        stageController.loadView(START_VIEW);
    }

    public void show() {
        mainController.getStageController().show();
    }

    public void close() {
        mainController.getStageController().close();
    }
}
