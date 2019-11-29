package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import nello.controller.MainController;
import nello.controller.ProfileController;
import nello.model.User;
import nello.model.UserRole;
import nello.observable.ProfileObservable;
import nello.observer.ProfileObserver;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProfileView implements FXMLView<ProfileController>, Initializable, ProfileObserver {
    @FXML
    private ComboBox dropdownUserRole;

    @FXML
    private TextField textFieldInitials;

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private PasswordField textFieldNewPassword;

    @FXML
    private PasswordField textFieldConfirmNewPassword;

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonBack;

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
        setupUser(o.getUser());
        showDropdownUserRoles(o.getUser().getRole());
    }

    public void setupUser(User user) {
        String name = user.getNetworkMember().getName();
        String firstName = name.split(" ")[0];
        String lastName = name.split(" ")[name.split(" ").length - 1];

        this.textFieldInitials.setText(firstName.substring(0, 1) + lastName.substring(0, 1));
        this.textFieldFirstName.setText(firstName);
        this.textFieldLastName.setText(lastName);
        this.textFieldEmail.setText(user.getEmail());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getController().registerObserver(this);
    }

    public void onSaveButtonClick() {
        getController().onSaveButtonClick(
            textFieldFirstName.getText(),
            textFieldLastName.getText(),
            textFieldEmail.getText(),
            dropdownUserRole.getValue().toString(),
            textFieldPassword.getText(),
            textFieldNewPassword.getText(),
            textFieldConfirmNewPassword.getText()
        );
    }

    public void onBackButtonClick(MouseEvent event) {
        getController().onBackButtonClick();
    }

    public void showDropdownUserRoles(UserRole userRole) {
        for (UserRole role : controller.getUserRoles()) {
            dropdownUserRole.getItems().add(role.getName());
        }
        dropdownUserRole.getSelectionModel().select(userRole.getValue() -1);
    }
}
