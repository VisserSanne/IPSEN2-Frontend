package nello.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import nello.controller.ExperimentController;
import nello.controller.MainController;

public class ExperimentCreateView implements FXMLPopup<ExperimentController> {

    private final String fxmlPath;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextArea descriptionTextField;
    @FXML
    private AnchorPane root;
    private ExperimentController controller;

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

    @Override
    public void setLocation(double x, double y) {
        this.root.setLayoutX(x);
        this.root.setLayoutY(y);
    }
}
