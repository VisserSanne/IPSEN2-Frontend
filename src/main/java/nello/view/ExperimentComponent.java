package nello.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import nello.model.Experiment;
import nello.util.ResourceUtil;


public class ExperimentComponent extends HBox {
    private static final int HEIGHT = 150;
    private static final int WIDTH = 275;

    public ExperimentComponent(Experiment experiment) {
        super(getChildrenNodes(experiment));
        setup();
    }

    private void setup() {
        this.setMaxWidth(WIDTH);
        this.setMaxHeight(HEIGHT);
        this.setMinWidth(WIDTH);
        this.setMinHeight(HEIGHT);
    }

    private static Node[] getChildrenNodes(Experiment experiment) {
        Node[] childeren = new Node[2];

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(HEIGHT);
        rectangle.setFill(experiment.getStatusColor().getValue());

        childeren[0] = rectangle;
        childeren[1] = getBody(experiment);
        return childeren;
    }

    private static AnchorPane getBody(Experiment experiment) {
        AnchorPane anchorPane = new AnchorPane();
        Label title           = new Label(experiment.getName());
        title.setMaxWidth(WIDTH);
        title.setTooltip(new Tooltip(experiment.getName()));
        title.setFont(new Font("Arial", 16));


        Label description = new Label("aalskjdfhlksajdhflkjasdhflkjashdlfkjhasdlkjfhalskjdfhlakjsdhfljkasdhfljkashdlfjkasdlfjkhasldjkfhalsjkdhflakjsdhflkjashdflkjhasdfaalskjdfhlksajdhflkjasdhflkjashdlfkjhasdlkjfhalskjdfhlakjsdhfljkasdhfljkashdlfjkasdlfjkhasldjkfhalsjkdhflakjsdhflkjashdflkjhasdf\"");
        description.setTooltip(new Tooltip("aalskjdfhlksajdhflkjasdhflkjashdlfkjhasdlkjfhalskjdfhlakjsdhfljkasdhfljkashdlfjkasdlfjkhasldjkfhalsjkdhflakjsdhflkjashdflkjhasdfaalskjdfhlksajdhflkjasdhflkjashdlfkjhasdlkjfhalskjdfhlakjsdhfljkasdhfljkashdlfjkasdlfjkhasldjkfhalsjkdhflakjsdhflkjashdflkjhasdf"));
        description.setLayoutX(15);
        description.setLayoutY(37);

        description.setPrefWidth(WIDTH);
        description.maxWidth(WIDTH);

        description.setPrefHeight(60);

        description.setAlignment(Pos.TOP_LEFT);
        description.setWrapText(true);
        description.setFont(new Font("Arial", 12));
//        description.setStyle("-fx-background-color: blue");


        ImageView imageView = new ImageView(new Image(ResourceUtil.get("/img.icons/options.png").toExternalForm()));
        imageView.setLayoutX(300);
        imageView.setLayoutY(17);


        title.setLayoutX(15);
        title.setLayoutY(10);
        title.setPrefWidth(Double.MAX_VALUE);
        title.setPrefHeight(20);
        title.setStyle("-fx-background-color: white;");


        HBox content = new HBox();
        for (int i = 0; i < 20; i++) {
            content.getChildren().add(new UserInitialsComponent("AJ"));
//            content.getChildren().get()
        }
        content.setSpacing(10);

        ScrollPane scrollPane = new ScrollPane(content);

        scrollPane.setLayoutY(95);
        scrollPane.setLayoutX(15);
        scrollPane.setPrefWidth(WIDTH);
        scrollPane.setMaxWidth(WIDTH);
        scrollPane.setPrefHeight(50);
        scrollPane.setMaxHeight(50);
        scrollPane.setId("scroll-pane");

        anchorPane.getChildren().addAll(title, imageView, description, scrollPane);
        return anchorPane;
    }

    private static HBox getHeader(Experiment experiment) {
        Node[] childeren = new Node[2];
        Label title = new Label(experiment.getName());
        ImageView button = new ImageView();
        childeren[0] = title;
        childeren[1] = button;
        return new HBox();
    }

//    private static Label descriptionBuilder() {
//
//    }
}
