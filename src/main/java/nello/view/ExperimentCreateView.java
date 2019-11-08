package nello.view;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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

    @FXML
    private CheckBox vasteDienst;

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
        if(descriptionTextField.getText().isEmpty() && descriptionTextField.getText().equals("De omschrijving mag niet leeg blijven.")){
            descriptionTextField.setPromptText("De omschrijving mag niet leeg blijven.");
        } else if(nameTextField.getText().isEmpty() && nameTextField.getText().equals("Er moet een naam opgegeven worden.")) {
            nameTextField.setPromptText("Er moet een naam opgegeven worden.");
        } else {
            getController().create(vasteDienst.isSelected(), nameTextField.getText(), descriptionTextField.getText());
        }
    }

}
