package nello.view;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nello.controller.MainController;
import nello.controller.ProfileController;

import java.awt.event.MouseEvent;

public class ProfileView implements FXMLView<ProfileController> {

    @FXML
    private MenuBar menuWindow;

    @FXML
    private Menu menuBarExpriments;

    @FXML
    private TextField textRole;

    public void setTextRole(TextField textRole) {
        this.textRole = textRole;
    }

    @FXML
    private TextField textFullName;

    public void setTextFullName(TextField textFullName) {
        this.textFullName = textFullName;
    }

    @FXML
    private TextField textInitials;

    public void setTextInitials(TextField textInitials) {
        this.textInitials = textInitials;
    }

    @FXML
    private TextField textEmail;

    public void setTextEmail(TextField textEmail) {
        this.textEmail = textEmail;
    }

    @FXML
    private Label labelRole;

    @FXML
    private Label labelFullName;

    @FXML
    private Label labelInitials;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelBio;

    @FXML
    private Button buttonSave;

    @FXML
    private void inputTextBio(MouseEvent event) {

    }

    @FXML
    private void inputTextEmail(MouseEvent event) {

    }

    @FXML
    private void inputTextFullName(MouseEvent event) {

    }

    @FXML
    private void inputTextInitials(MouseEvent event) {

    }

    @FXML
    private void inputTextRole(MouseEvent event) {

    }

    @FXML
    private void onSaveButtonClick(MouseEvent event) {

    }

    private final String fxmlPath;
    private ProfileController controller;

    public ProfileView() {
        this.fxmlPath = "/view/ProfileView.fxml";
        this.controller = MainController.getInstance().getProfileController();
    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public ProfileController getController() {
        return controller;
    }

    @Override
    public void setController(ProfileController controller) {
        this.controller = controller;
    }
}
