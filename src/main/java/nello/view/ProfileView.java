package nello.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import nello.controller.MainController;
import nello.controller.ProfileController;
import nello.observable.ProfileObservable;
import nello.observer.ProfileObserver;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ProfileView implements FXMLView<ProfileController>, ProfileObserver {

    @FXML
    private TextField textFieldRole;

    @FXML
    private TextField textFieldFullName;

    @FXML
    private TextField textFieldInitials;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private Button buttonSave;

    @FXML
    private void onEmailChange(KeyEvent event) {
        this.controller.onEmailChange(textFieldEmail.getText());
    }

    @FXML
    private void onFullNameChange(KeyEvent event) {
        this.controller.onFullNameChange(textFieldFullName.getText());
    }

    @FXML
    private void onSaveButtonClick(MouseEvent event) {
        this.controller.onSaveButtonClick();
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

    @Override
    public void update(ProfileObservable o) {
        this.textFieldEmail.setText(o.getUser().getEmail());
        this.textFieldFullName.setText(o.getUser().getNetworkMember().getName());
    }
}
