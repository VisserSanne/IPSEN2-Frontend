package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import nello.controller.MainController;
import nello.controller.ProfileController;
import nello.observable.ProfileObservable;
import nello.observer.ProfileObserver;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileView implements FXMLView<ProfileController>, Initializable, ProfileObserver {

    @FXML
    private TextField textFieldUserRole;

    @FXML
    private TextField textFieldFullName;

    @FXML
    private TextField textFieldInitials;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private Button buttonSave;

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
        System.out.println(o.getUser());
        this.textFieldUserRole.setText(o.getUser().getUserRole().getName());
        this.textFieldEmail.setText(o.getUser().getEmail());
        this.textFieldFullName.setText(o.getUser().getNetworkMember().getName());
        this.textFieldInitials.setText(o.getUser().getNetworkMember().getInitials());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getController().registerObserver(this);
    }

    public void onFullNameChange(KeyEvent keyEvent) {
    }

    public void onEmailChange(KeyEvent keyEvent) {
    }

    public void onSaveButtonClick(MouseEvent mouseEvent) {
    }
}
