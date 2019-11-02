package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import nello.controller.ExperimentOverviewController;
import nello.controller.MainController;

import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

public class ExperimentOverviewView implements FXMLView<ExperimentOverviewController>, Initializable {


    private static final String DATA_FOR_RANDOM_STRING = "abcdefghijklmnopqrstuvwxyz";
    private final String fxmlPath;
    @FXML
    public StackPane dummy_user;
    @FXML
    public Label titleLabel;
    @FXML
    public Label descriptionLabel;
    @FXML
    public Label statusLabel;
    @FXML
    public Label lastModified;
    @FXML
    public Label businessOwnerLabel;
    @FXML
    public Label costLabel;
    @FXML
    public FlowPane costFlowPane;
    @FXML
    public Label dummy_cost;
    @FXML
    public Label incomeLabel;
    @FXML
    public FlowPane incomeFlowPane;
    @FXML
    private HBox userList;
    private ExperimentOverviewController controller;

    public ExperimentOverviewView() {
        this.fxmlPath = "/view/ExperimentOverviewView.fxml";
        this.controller = MainController.getInstance().getExperimentOverviewController();
    }

    public static String generateRandomString(int length) {
        Random random = new Random();
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            // debug
            System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

            sb.append(rndChar);

        }

        return sb.toString();

    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public ExperimentOverviewController getController() {
        return controller;
    }

    @Override
    public void setController(ExperimentOverviewController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.titleLabel.setText("Marktplaats Expertise");
        this.descriptionLabel.setText("Expertisebank, marktplaats of talentenbank: de Om'er wil mensen makkelijk en snel kunnen vinden op expertise, kennis of talent");
        this.descriptionLabel.setWrapText(true);
        this.statusLabel.setText("Exploratie fase: gesprek met leverancier app p-direct staat gebpland, HR development is aangehaakt");
        this.businessOwnerLabel.setText("Ashna Wiar");
        this.lastModified.setText(String.format(this.lastModified.getText(), "Ashna Wiar", new Date().toString()));
        // hide 'geen' text
        this.costLabel.setText("");
        this.incomeLabel.setText("");
        Label new_cost = new Label("20k funding");
        new_cost.getStyleClass().add("label-finance");
        Label new_cost_2 = new Label("40k funding");
        new_cost_2.getStyleClass().add("label-finance");
        this.costFlowPane.getChildren().addAll(new_cost, new_cost_2);

        for (int i = 0; i < 5; i++) {
            Label c = new Label(generateRandomString(10));
            c.getStyleClass().add("label-finance");
            this.costFlowPane.getChildren().add(c);
        }

        for (int i = 0; i < 5; i++) {
            Label c = new Label(generateRandomString(10));
            c.getStyleClass().add("label-finance");
            this.incomeFlowPane.getChildren().add(c);
        }


    }

}
