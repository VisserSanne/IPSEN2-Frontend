package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nello.controller.MainController;
import nello.controller.UserRegistrationController;
import nello.observable.UserRegistrationObservable;
import nello.observer.UserRegistrationObserver;

import java.net.URL;
import java.util.ResourceBundle;

public class UserRegistrationView implements FXMLView<UserRegistrationController>, UserRegistrationObserver, Initializable {

    private final String fxmlPath;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField emailField;
    @FXML
    private Label messagLabel;
    private UserRegistrationController controller;

    public UserRegistrationView() {
        this.fxmlPath = "/view/RegisterView.fxml";
        this.controller = MainController.getInstance().getUserRegistrationController();
    }


    public void onRegisterButtonClick() {
        System.out.println("called");
        getController().onRegisterButtonClick(firstnameField.getText(), lastnameField.getText(), emailField.getText());
    }

    public void onBackButtonClick() {
        System.out.println("terug");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.messagLabel.setText("");
        getController().registerObserver(this::update);
    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public UserRegistrationController getController() {
        return controller;
    }

    @Override
    public void setController(UserRegistrationController controller) {
        this.controller = controller;

    }

    @Override
    public void update(UserRegistrationObservable o) {
        System.out.println("update view dude");
        if (o.getErrorMessages().size() != 0) {
            this.messagLabel.setText((String) o.getErrorMessages().values().toArray()[0]);
        } else {
            this.messagLabel.setText("");
        }
    }
}
