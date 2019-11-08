package nello.view.components;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import nello.model.Log;


public class LogItemComponent extends AnchorPane {

    public LogItemComponent(Log log) {
        super(createFrom(log));
        this.setPadding(new Insets(10, 0, 10, 0));
    }

    private static Node[] createFrom(Log log) {
        Circle circle = new Circle();
        circle.setFill(Color.web("#ba81eb"));
        circle.setRadius(12.5);
        circle.setLayoutX(0);
        circle.setLayoutY(0);
        Label status = new Label(log.getStatus());
        status.setWrapText(true);
        status.setPrefWidth(257);
        status.setMaxWidth(257);
        status.setTooltip(new Tooltip(log.getStatus()));
        Label date = new Label(String.format("Laats gewijzigd door: %s\n%s", log.getPerson(), log.getCreateDateTime().toString()));
        date.setStyle("-fx-font-size: 11px");
        VBox vBox = new VBox(status, date);
        vBox.setLayoutX(36);
        vBox.setSpacing(10);
        return new Node[]{circle, vBox};
    }
}
