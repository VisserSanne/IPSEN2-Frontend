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
        circle.setRadius(15);
        circle.setFill(Color.web("#ba81eb"));
        Label l = new Label(initials);


        return new Node[]{circle, l};

    }
}
