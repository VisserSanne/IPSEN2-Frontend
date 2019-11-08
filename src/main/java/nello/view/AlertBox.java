package nello.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import nello.controller.IController;
import nello.model.Experiment;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class AlertBox implements IController, FXMLView<AlertBox>, Initializable {

    private final String message;
    private final Level level;
    private final double duration;
    @FXML
    private Label titleLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private VBox root;
    private AlertBox controller;


    public AlertBox(String message, Level level, double duration) {
        this.message = message;
        this.level = level;
        this.duration = duration;
        System.out.println("created");
    }

    @Override
    public String getFXMLPath() {
        return "/view/AlertBox.fxml";
    }

    @Override
    public AlertBox getController() {
        return this;
    }

    @Override
    public void setController(AlertBox controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Color color = Experiment.StatusColor.GROEN.getAsColor();
        if (this.level.equals(Level.SEVERE)) {
            this.titleLabel.setText("Error!");
            color = Experiment.StatusColor.ROOD.getAsColor();
        }
        if (this.level.equals(Level.WARNING)) {
            this.titleLabel.setText("Alert!");

            color = Experiment.StatusColor.ORANJE.getAsColor();
        }
        if (this.level.equals(Level.FINE)) {
            this.titleLabel.setText("Succesvol");
            color = Experiment.StatusColor.GROEN.getAsColor();
        }

        this.root.setBackground(new Background(new BackgroundFill(color, new CornerRadii(5, false), new Insets(0))));
        this.messageLabel.setText(message);
        startCountDown(this.duration);
    }

    private void startCountDown(double duration) {
        Platform.runLater(() -> {
            try {
                TimeUnit.SECONDS.sleep((long) (duration + 2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((Pane) this.root.getParent()).getChildren().remove(root);
        });
    }
}
