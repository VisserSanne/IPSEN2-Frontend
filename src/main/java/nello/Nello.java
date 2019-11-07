package nello;

import javafx.stage.Stage;
import nello.controller.ExperimentController;
import nello.controller.LoginController;
import nello.controller.MainController;
import nello.controller.StageController;
import nello.model.Experiment;
import nello.view.ExperimentCreateView;
import nello.view.ExperimentOverviewView;
import nello.view.FXMLView;
import nello.view.LoginView;


public class Nello {

    private final static String APP_NAME = "Nello";
    private final static String VERSION = "v1.0";

    // define start view
    private final static FXMLView<LoginController> START_VIEW = new LoginView();
    private final static FXMLView<ExperimentController> EXPERIMENT_OVERVIEW_CONTROLLER_FXML_VIEW = new ExperimentOverviewView();

    private MainController mainController;

    public Nello() {
        this.mainController = MainController.getInstance();
    }

    public void shine(Stage primaryStage) {
        primaryStage.setTitle(String.format("%s %s", APP_NAME, VERSION));
        StageController stageController = mainController.getStageController();
        stageController.prepareStage(primaryStage);
        stageController.displayView(START_VIEW);
        mainController.getExperimentController().setExperiment(new Experiment());
        stageController.displayPopup(EXPERIMENT_OVERVIEW_CONTROLLER_FXML_VIEW);
        stageController.displayPopup(new ExperimentCreateView(), 500, 500);
    }

    public void shine() {
        mainController.getStageController().show();
    }

    public void close() {
        mainController.getStageController().close();
    }
}
