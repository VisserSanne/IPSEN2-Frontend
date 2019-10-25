package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginView extends AbstractView implements Initializable {

    @FXML
    private BorderPane root;

    @FXML
    private Label mainMessage;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField textfieldEmail;


    public LoginView() {
        super("/view/LoginView.fxml");
    }

    public void onTextFieldChange(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            root.requestFocus();
            onLoginButtonClick();
        }
    }

    public void onResetButtonClick(MouseEvent mouseEvent) {
        System.out.println("clicked on reset");
    }

    public void onRegisterButtonClick(MouseEvent mouseEvent) {
        System.out.println("clicked on register");
    }

    public void onLoginButtonClick() {
        System.out.println("clicked on login");
        System.out.println("textfield text " + textfieldEmail.getText());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("called");
        errorMessage.setText("");
    }
}
