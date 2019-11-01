package nello.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nello.controller.MainController;
import nello.controller.ProfileController;

import java.awt.event.MouseEvent;

public class ProfileView implements FXMLView<ProfileController> {

    @FXML
    private TextField textRole;

    @FXML
    private TextField textFullName;

    @FXML
    private TextField textInitials;

    @FXML
    private TextField textEmail;

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
    void inputTextBio(MouseEvent event) {

    }

    @FXML
    void inputTextEmail(MouseEvent event) {

    }

    @FXML
    void inputTextFullName(MouseEvent event) {

    }

    @FXML
    void inputTextInitials(MouseEvent event) {

    }

    @FXML
    void inputTextRole(MouseEvent event) {

    }

    @FXML
    void onSaveButtonClick(MouseEvent event) {

    }

    private final String fxmlPath;
    private ProfileController controller;

    public ProfileView() {
        this.fxmlPath = "/view/ProfileView.fxml";
        this.controller = MainController.getInstance().getProfileController();
    }

    @Override
    public String getFXMLPath() {
        return null;
    }

    @Override
    public ProfileController getController() {
        return null;
    }

    @Override
    public void setController(ProfileController controller) {

    }
}
