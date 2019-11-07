package nello.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import nello.controller.MainController;
import nello.controller.UsersTabController;
import nello.observable.UsersTabObservable;
import nello.observer.UsersTabObserver;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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

    public TableColumn<Long, Long> getTableColumnID() {
        return tableColumnID;
    }

    public TableColumn<String, String> getTableColumnUser() {
        return tableColumnUser;
    }

    public TableColumn<String, String> getTableColumnEmail() {
        return tableColumnEmail;
    }
}
