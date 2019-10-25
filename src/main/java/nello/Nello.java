package nello;

import javafx.stage.Stage;
import nello.controller.StageController;
import nello.view.FXMLView;

public class Nello {

    private StageController stageController;

    public Nello(Stage stage) {
        stageController = new StageController(stage, FXMLView.LOGIN);
    }
}
