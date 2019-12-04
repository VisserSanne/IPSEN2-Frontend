package nello.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import nello.controller.ExperimentController;
import nello.controller.MainController;
import nello.model.Log;
import nello.model.Team;
import nello.observable.ExperimentObservable;
import nello.observer.ExperimentObserver;
import nello.view.components.LogItemComponent;

import java.net.URL;
import java.util.List;
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
    public Button addAttachment;

    @FXML
    public FlowPane incomeFlowPane;
    @FXML
    private HBox userList;

    @FXML
    private VBox networkMemberVbox;

    @FXML
    private VBox logVbox;

    @FXML
    private Rectangle statusColorRectangle;

    private ExperimentController controller;

    public ExperimentOverviewView() {
        this.fxmlPath = "/view/ExperimentOverviewView.fxml";
        this.controller = MainController.getInstance().getExperimentController();
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
//        System.out.println("called");
//        this.titleLabel.setText(generateRandomString(30));
//        this.descriptionLabel.setText(generateRandomString(125));
//        this.descriptionLabel.setWrapText(true);
//        this.statusLabel.setText(generateRandomString(125));
//        this.businessOwnerLabel.setText("Ashna Wiar");
//        this.lastModified.setText(String.format(this.lastModified.getText(), "Ashna Wiar", new Date().toString()));
//        // hide 'geen' text
//        this.costLabel.setText("");
//        this.incomeLabel.setText("");
//
//        for (int i = 0; i < 5; i++) {
//            Label c = new Label(generateRandomString(10));
//            c.getStyleClass().add("tag-finance");
//            this.costFlowPane.getChildren().add(c);
//        }
//
//        for (int i = 0; i < 5; i++) {
//            Label c = new Label(generateRandomString(10));
//            c.getStyleClass().add("tag-finance");
//            this.incomeFlowPane.getChildren().add(c);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            NetworkMemberComponent n = new NetworkMemberComponent(generateRandomString((int) (Math.random() * 100)), randomBoolean(), randomBoolean());
//            Line line = new Line(0, 0, 255, 0);
//            line.setStroke(Color.web("#cecece"));
//            networkMemberVbox.getChildren().addAll(n, line);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            Log l = new Log(i, generateRandomString(250), generateRandomString(10), LocalDateTime.now());
//            LogItemComponent logItemComponent = new LogItemComponent(l);
//            logVbox.getChildren().add(logItemComponent);
//        }
//
////        getController().registerObserver(this);
        getController().registerObserver(this);

    }

    private void updateTeamMembers(List<Team> teamMembers) {
        networkMemberVbox.getChildren().clear();

        for (Team member : teamMembers) {
//            NetworkMemberComponent n = new NetworkMemberComponent(member.getNetworkMember().getName(), member.isEinstein(), member.getNetworkMember().isBusiness());
//            Line line = new Line(0, 0, 255, 0);
//            line.setStroke(Color.web("#cecece"));
//            networkMemberVbox.getChildren().addAll(n, line);
        }

    }

    private boolean randomBoolean() {
        return Math.random() > 0.5;
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
//        this.lastModified.setText(String.format(this.lastModified.getText(), o.getLastModified().toString()));
        updateFinance(o.getIncomes(), incomeFlowPane);
        updateFinance(o.getCosts(), costFlowPane);
        this.statusColorRectangle.setFill(o.getStatusColor().getAsColor());
//        updateTeamMembers(o.getTeamMembers());
        updateLog(o.getLogs());
    }

    private void updateLog(List<Log> logs) {
        logVbox.getChildren().clear();
        System.out.println("updating log" + logs.toString());
        for (Log l : logs) {
            LogItemComponent logItemComponent = new LogItemComponent(l);
            logVbox.getChildren().add(logItemComponent);
        }
    }

    /**
     * Clears all the old items in a finance FlowPane and reloads new items when a change occurs in the experiment
     *
     * @param list     list of strings with finance items
     * @param flowPane the FlowPane of that needs to be updated
     * @author Valerie Timmerman
     */

    private void updateFinance(List<String> list, FlowPane flowPane) {
        flowPane.getChildren().clear();
        if (list == null)
            return;

        for (String item : list) {
            Label itemLabel = new Label(item);
            itemLabel.getStyleClass().add("tag-finance");
            flowPane.getChildren().add(itemLabel);
        }

    }

    public void pickAttachment(){
        getController().pickAttachment();
    }

    public void onEditButtonClick(MouseEvent event) {
        getController().onEditButtonClick(statusLabel.getText());
    }
}
