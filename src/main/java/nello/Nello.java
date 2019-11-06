package nello;

import javafx.stage.Stage;
import nello.controller.ExperimentController;
import nello.controller.MainController;
import nello.controller.StageController;
import nello.controller.UserRegistrationController;
import nello.view.ExperimentOverviewView;
import nello.view.FXMLView;
import nello.view.UserRegistrationView;


public class Nello {

    private final static String APP_NAME = "Nello";
    private final static String VERSION = "v1.0";

    // define start view
    private final static FXMLView<UserRegistrationController> START_VIEW = new UserRegistrationView();
    private final static FXMLView<ExperimentController> EXPERIMENT_OVERVIEW_CONTROLLER_FXML_VIEW = new ExperimentOverviewView();

    private MainController mainController;

    public Nello() {
        this.mainController = MainController.getInstance();
    }

    public void shine(Stage primaryStage) {
        primaryStage.setTitle(String.format("%s %s", APP_NAME, VERSION));
        StageController stageController = mainController.getStageController();
        stageController.prepareStage(primaryStage);
        stageController.loadView(START_VIEW);
//        mainController.getExperimentController().setExperiment(new Experiment());
//        stageController.loadPopup(EXPERIMENT_OVERVIEW_CONTROLLER_FXML_VIEW);
    }

    public void shine() {
        mainController.getStageController().show();
    }

    public void close() {
        mainController.getStageController().close();
    }
}
