package nello.view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class UserInitialsComponent extends StackPane {

    public UserInitialsComponent(String initials) {
        super(createChildren(initials));
    }

    private static Node[] createChildren(String initials) {
        Circle circle = new Circle();
        circle.setRadius(12.5);
        circle.setFill(Color.web("#ba81eb"));
        Label l = new Label(initials);
        l.setTextFill(Color.WHITE);
        l.setStyle("-fx-font-size: 11px;");

        return new Node[]{circle, l};

    }
}
