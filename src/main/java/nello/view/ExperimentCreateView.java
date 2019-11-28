package nello.view;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import nello.controller.ExperimentController;
import nello.controller.MainController;
import nello.model.Experiment;

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
    private Experiment.Phase phase;

    public ExperimentCreateView(Experiment.Phase phase) {
        this.fxmlPath = "/view/ExperimentCreateView.fxml";
        this.controller = MainController.getInstance().getExperimentController();
        this.phase = phase;
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

    /**
     * When a new experiment is made and the save button is clicked, this first checks if any fields are empty
     * If all fields are filled out it sends the data to the controller
     * @param event event of the mouse click
     * @author Valerie Timmerman
     * @author Thomas Warbout
     */

    public void onSaveButtonClick(MouseEvent event) {
        if(descriptionTextField.getText().isEmpty() && descriptionTextField.getText().equals("De omschrijving mag niet leeg blijven.")){
            descriptionTextField.setPromptText("De omschrijving mag niet leeg blijven.");
        } else if(nameTextField.getText().isEmpty() && nameTextField.getText().equals("Er moet een naam opgegeven worden.")) {
            nameTextField.setPromptText("Er moet een naam opgegeven worden.");
        } else {
            getController().create(vasteDienst.isSelected(), phase, nameTextField.getText(), descriptionTextField.getText());
        }
    }

    public Experiment.Phase getPhase() {
        return phase;
    }
}
