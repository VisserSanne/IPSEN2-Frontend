package nello.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import nello.controller.ExperimentController;
import nello.controller.MainController;

public class ExperimentCreateView implements FXMLView<ExperimentController> {


    @FXML
    private TextField nameTextField;

    @FXML
    private TextArea descriptionTextField;

    private ExperimentController controller;
    private final String fxmlPath;
    private double y;
    private double x;

    public ExperimentCreateView() {
        this.fxmlPath = "/view/ExperimentCreateView.fxml";
        this.controller = MainController.getInstance().getExperimentController();
    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public ExperimentController getController() {
        return controller;
    }

    @Override
    public void setController(ExperimentController controller) {
        this.controller = controller;
    }


    public void onSaveButtonClick(MouseEvent event) {
        System.out.println("save this experiment");
    }

}
