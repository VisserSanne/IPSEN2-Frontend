package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import nello.controller.DashboardController;
import nello.controller.ExperimentController;
import nello.controller.MainController;
import nello.observable.ExperimentObservable;
import nello.observer.DashboardObserver;
import nello.observer.ExperimentObserver;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class EditExperimentView implements FXMLView<ExperimentController>, ExperimentObserver, Initializable {

    private ExperimentController controller;
    private String fxmlPath;

    public EditExperimentView() {
        this.controller = MainController.getInstance().getExperimentController();
        this.fxmlPath = "/view/EditExperimentView";
    }

    @FXML
    private TextField nameField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextArea statusArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void update(ExperimentObservable experimentObservable) {

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
     * When the user presses the save button, this sends the data to the controller
     *
     * @param event the mouse click event on the save button
     * @author Valerie Timmerman
     */

    public void onSaveButtonClick(MouseEvent event) {
        getController().updateExperiment(nameField.getText(), descriptionArea.getText(), statusArea.getText());
    }

}
