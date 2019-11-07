package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import nello.controller.ExperimentController;
import nello.controller.MainController;
import nello.observable.ExperimentObservable;
import nello.observer.ExperimentObserver;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ExperimentOverviewView implements FXMLView<ExperimentController>, ExperimentObserver, Initializable {


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

    private ExperimentController controller;

    public ExperimentOverviewView() {
        this.fxmlPath = "/view/ExperimentOverviewView.fxml";
        this.controller = MainController.getInstance().getExperimentController();
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
    public ExperimentController getController() {
        return controller;
    }

    @Override
    public void setController(ExperimentController controller) {
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

//        for (int i = 0; i < 10; i++) {
//            NetworkMemberComponent n = new NetworkMemberComponent(generateRandomString((int) (Math.random() * 100)), randomBoolean(), randomBoolean());
//            Line line = new Line(0, 0, 255, 0);
//            line.setStroke(Color.web("#cecece"));
//            networkMemberVbox.getChildren().addAll(n, line);
//
//        }

        getController().registerObserver(this);

    }

    private boolean randomBoolean() {
        return Math.random() < 0.5;
    }

    /**
     * Resets all the information when the model had changed
     *
     * @param o observable that has changed
     * @author Valerie Timmerman
     */

    @Override
    public void update(ExperimentObservable o) {

        this.titleLabel.setText(o.getName());
        this.descriptionLabel.setText(o.getDescription());
        this.statusLabel.setText(o.getStatus());
        this.businessOwnerLabel.setText(o.getBusinessOwner());
        this.lastModified.setText(String.format(this.lastModified.getText(), o.getLastModified().toString()));
        updateFinance(o.getIncomes(), incomeFlowPane);
        updateFinance(o.getCosts(), costFlowPane);
    }

    /**
     * Clears all the old items in a finance FlowPane and reloads new items when a change occurs in the experiment
     *
     * @param list list of strings with finance items
     * @param flowPane the FlowPane of that needs to be updated
     * @author Valerie Timmerman
     */

    private void updateFinance(List<String> list, FlowPane flowPane) {

        flowPane.getChildren().clear();

        for(String item: list) {
            Label itemLabel = new Label(item);
            itemLabel.getStyleClass().add("tag-finance");
            flowPane.getChildren().add(itemLabel);
        }

    }
}
