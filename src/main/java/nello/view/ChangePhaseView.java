package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import nello.controller.ChangePhaseController;
import nello.controller.MainController;
import nello.observable.ChangePhaseObservable;
import nello.observer.ChangePhaseObserver;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangePhaseView implements FXMLView<ChangePhaseController>, ChangePhaseObserver, Initializable {

    private final String fxmlPath;

    @FXML
    private Label zoekLid;

    @FXML
    private Label personOne;

    @FXML
    private Label personTwo;

    @FXML
    private Label personThree;

    @FXML
    private Label lettersPersonOne;

    @FXML
    private Label lettersPersonTwo;

    @FXML
    private Label lettersPersonThree;

    @FXML
    private ImageView back;


    private ChangePhaseController controller;

    public ChangePhaseView() {
        this.fxmlPath = "/view/ChangePhaseView.fxml";
        this.controller = MainController.getInstance().getChangePhaseController();
    }


    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public ChangePhaseController getController() {
        return controller;
    }

    @Override
    public void setController(ChangePhaseController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // register to observable
        getController().registerObserver(this);
    }

    @Override
    public void update(ChangePhaseObservable observable) {

    }
}
