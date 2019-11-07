package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import nello.controller.MainController;
import nello.controller.UsersTabController;
import nello.observable.UsersTabObservable;
import nello.observer.UsersTabObserver;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class UsersTabView implements FXMLView<UsersTabController>, Initializable, UsersTabObserver {

    @FXML
    private TableColumn<Long, Long> tableColumnID;

    @FXML
    private TableColumn<String, String> tableColumnUser;

    @FXML
    private TableColumn<String, String> tableColumnEmail;

    @FXML
    private TextField textFieldEdit;

    @FXML
    private TextField textFieldDelete;

    @FXML
    private Button onEditButton;

    @FXML
    private Button onDeleteButton;

    @FXML
    void onDeleteButtonClick(MouseEvent event) {
    }

    @FXML
    void onEditButtonClick(MouseEvent event) {
    }

    private final String fxmlPath;
    private UsersTabController controller;

    public UsersTabView(){
        this.fxmlPath = "/view/UsersTabView.fxml";
        this.controller = MainController.getInstance().getUsersTabController();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getController().registerObserver(this);
    }

    @Override
    public void update(UsersTabObservable o) {

    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public UsersTabController getController() {
        return null;
    }

    @Override
    public void setController(UsersTabController controller) {

    }

}
