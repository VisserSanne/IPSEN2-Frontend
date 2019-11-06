package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import nello.controller.DashboardController;
import nello.controller.MainController;
import nello.model.Experiment;
import nello.observable.DashboardObservable;
import nello.observer.DashboardObserver;

import java.net.URL;
import java.time.LocalDate;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //long id, Category category, Phase phase, String businessOwner, String description, String name,
        //                      StatusColor statusColor, LocalDate createDate, LocalDate endDate, String status, List<Log> logs,
        //                      List<Attachment> attachments, List<String> incomes, List<String> costs, boolean isLocked, LocalDateTime lastModified
        Experiment e = new Experiment(1, Experiment.Category.INWERKING, Experiment.Phase.IDEE, "Ashna Wiar",
                "this is a example text", "Thomas hersen experiment", Experiment.StatusColor.GROEN, LocalDate.now(), null,
        null, null, null, null, null, false, null);

        phaseIdeeVbox.getChildren().addAll(new ExperimentComponent(e));


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

    }
}