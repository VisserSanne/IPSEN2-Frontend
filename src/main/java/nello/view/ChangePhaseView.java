package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import nello.controller.AddMembersController;
import nello.controller.ChangePhaseController;
import nello.controller.MainController;
import nello.observable.AddMembersObservable;
import nello.observer.AddMembersObserver;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangePhaseView implements FXMLView<ChangePhaseController>, Initializable {

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
    public void setController(AddMembersController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // register to observable
        getController().registerObserver(this);
    }

    @Override
    public void update(AddMembersObservable observable) {
    }

}
