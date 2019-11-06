package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nello.controller.AddMembersController;
import nello.controller.MainController;
import nello.observable.AddMembersObservable;
import nello.observer.AddMembersObserver;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMembersView implements FXMLView<AddMembersController>, AddMembersObserver, Initializable {

    private final String fxmlPath;

    @FXML
    private Label zoekLid;


    private AddMembersController controller;

    public AddMembersView() {
        this.fxmlPath = "/view/AddMembersView.fxml";
        this.controller = MainController.getInstance().getAddMembersController();
    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public AddMembersController getController() {
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
