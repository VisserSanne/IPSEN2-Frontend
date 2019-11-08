package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import nello.controller.DashboardController;
import nello.controller.MainController;
import nello.model.Experiment;
import nello.observable.DashboardObservable;
import nello.observer.DashboardObserver;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardView implements FXMLView<DashboardController>, DashboardObserver, Initializable {

    @FXML
    private VBox phaseIdeeVbox;

    /**
     * path to fxml file
     */
    private final String fxmlPath;

    /**
     * controller for this view.
     */
    private DashboardController controller;


    public DashboardView() {
        this.fxmlPath = "/view/Dashboard.fxml";
        this.controller = MainController.getInstance().getDashboardController();
    }

    public void onMenuButtonClick() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getController().registerObserver(this::update);
    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public DashboardController getController() {
        return controller;
    }

    @Override
    public void setController(DashboardController controller) {
        this.controller = controller;
    }

    @Override
    public void update(DashboardObservable observable) {
        System.out.println("view update");
        Experiment[] experimentList = observable.getExperimentList();
        for (Experiment experiment : experimentList) {
            ExperimentComponent component = new ExperimentComponent(this, experiment);
            component.setOnMouseClicked(event -> onExperimentClick(event, component, experiment));
            switch (experiment.getPhase()) {
                case IDEE:
                    phaseIdeeVbox.getChildren().add(component);
                    break;
            }

        }

    }

    private void onExperimentClick(MouseEvent event, ExperimentComponent component, Experiment experiment) {
        System.out.println(event.getTarget() + " " + component);
        getController().onExperimentClick(experiment);
    }

    public void onComponentOptionClick(Experiment experiment) {
        getController().onOpenExperimentClick(experiment);
    }

    public void onAddExperimentIdea(MouseEvent event) {
        getController().onAddExperimentClick(Experiment.Phase.IDEE, event);
    }

    public void onAddVastdienst(MouseEvent event) {
        getController().onAddExperimentClick(Experiment.Phase.VASTEDIENST, event);


    }

    public void onAddExperimentLabOut(MouseEvent event) {
        getController().onAddExperimentClick(Experiment.Phase.LABUIT, event);
    }

    public void onAddExperimentLabIn(MouseEvent event) {
        getController().onAddExperimentClick(Experiment.Phase.LABIN, event);
    }
}
