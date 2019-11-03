package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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

    @FXML
    private VBox networkMemberVbox;

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
        this.titleLabel.setText(generateRandomString(30));
        this.descriptionLabel.setText(generateRandomString(125));
        this.descriptionLabel.setWrapText(true);
        this.statusLabel.setText(generateRandomString(125));
        this.businessOwnerLabel.setText("Ashna Wiar");
        this.lastModified.setText(String.format(this.lastModified.getText(), "Ashna Wiar", new Date().toString()));
        // hide 'geen' text
        this.costLabel.setText("");
        this.incomeLabel.setText("");

        for (int i = 0; i < 5; i++) {
            Label c = new Label(generateRandomString(10));
            c.getStyleClass().add("tag-finance");
            this.costFlowPane.getChildren().add(c);
        }

        for (int i = 0; i < 5; i++) {
            Label c = new Label(generateRandomString(10));
            c.getStyleClass().add("tag-finance");
            this.incomeFlowPane.getChildren().add(c);
        }

        for (int i = 0; i < 10; i++) {
            NetworkMemberComponent n = new NetworkMemberComponent(generateRandomString((int) (Math.random() * 100)), randomBoolean(), randomBoolean());
            Line line = new Line(0, 0, 255, 0);
            line.setStroke(Color.web("#cecece"));
            networkMemberVbox.getChildren().addAll(n, line);

        }


    }

    private boolean randomBoolean() {
        return Math.random() < 0.5;
    }

}
