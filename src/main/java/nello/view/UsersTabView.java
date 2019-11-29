package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import nello.controller.MainController;
import nello.controller.UsersTabController;
import nello.model.User;
import nello.observable.UsersTabObservable;
import nello.observer.UsersTabObserver;

import java.net.URL;
import java.util.ResourceBundle;


public class UsersTabView implements FXMLView<UsersTabController>, Initializable, UsersTabObserver {

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, Long> tableColumnID;

    @FXML
    private TableColumn<User, String> tableColumnUser;

    @FXML
    private TableColumn<User, String> tableColumnEmail;

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
        User[] users = o.getUserList();
        if (users != null) {
            showusers(users);
        }
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
        if (!textFieldEdit.getText().isEmpty()) {
            getController().onEditButtonClick(Integer.parseInt(textFieldEdit.getText()));
        }
    }

    public void onDeleteButtonClick() {
        if (!textFieldDelete.getText().isEmpty()) {
            getController().onDeleteButtonClick(Integer.parseInt(textFieldDelete.getText()));
        }
    }

    public void showusers(User[] users) {
        for (User user: users) {
            this.tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
            this.tableColumnUser.setCellValueFactory(new PropertyValueFactory<>("email"));
            this.tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        }
        tableView.getItems().setAll(users);
    }
}
