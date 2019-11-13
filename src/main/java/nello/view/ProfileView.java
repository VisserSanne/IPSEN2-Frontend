package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        System.out.println("update:" + o.getUser().getNetworkMember().getName());
        String name = o.getUser().getNetworkMember().getName();
        String firstName = name.split(" ")[0];
        String lastName = name.split(" ")[name.split(" ").length - 1];

        this.textFieldUserRole.setText(o.getUser().getRole().getName());
        this.textFieldInitials.setText(firstName.substring(0, 1) + lastName.substring(0, 1));
        this.textFieldFirstName.setText(firstName);
        this.textFieldLastName.setText(lastName);
        this.textFieldEmail.setText(o.getUser().getEmail());
        this.textFieldPassword.setText(o.getUser().getPassword());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getController().registerObserver(this);
    }

    public void onSaveButtonClick(MouseEvent mouseEvent) {
        getController().onSaveButtonClick(
                textFieldFirstName.getText(),
                textFieldLastName.getText(),
                textFieldEmail.getText(),
                textFieldPassword.getText());
    }

    public void onBackButtonClick(MouseEvent event) {
        getController().onBackButtonClick();

    }
}
