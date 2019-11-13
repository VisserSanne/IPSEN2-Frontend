package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import nello.controller.MainController;
import nello.controller.UsersTabController;
import nello.observable.UsersTabObservable;
import nello.observer.UsersTabObserver;

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

    private final String fxmlPath;
    private UsersTabController controller;

    public UsersTabView() {
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
        return controller;
    }

    @Override
    public void setController(UsersTabController controller) {
        this.controller = controller;
    }

    public void onEditButtonClick(MouseEvent mouseEvent) {
        getController().onEditButtonClick(Integer.parseInt(textFieldEdit.getText()));
    }

    public void onDeleteButtonClick(MouseEvent event) {
        getController().onDeleteButtonClick(Integer.parseInt(textFieldDelete.getText()));
    }

}
