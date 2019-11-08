package nello.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import nello.model.Experiment;
import nello.util.ResourceUtil;


public class ExperimentComponent extends HBox {
    private static final int HEIGHT = 150;
    private static final int WIDTH = 290;

    public ExperimentComponent(DashboardView dashboardView, Experiment experiment) {
        super(getChildrenNodes(experiment, dashboardView));
        setup();
    }

    private static Node[] getChildrenNodes(Experiment experiment, DashboardView masterView) {
        Node[] childeren = new Node[2];

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(HEIGHT);
        rectangle.setFill(experiment.getStatusColor().getAsColor());

        childeren[0] = rectangle;
        childeren[1] = getBody(experiment, masterView);
        return childeren;
    }

    private static AnchorPane getBody(Experiment experiment, DashboardView masterView) {
        AnchorPane anchorPane = new AnchorPane();
        Label title = titleBuilder(experiment);
        ImageView imageView = menuBuilder();
        imageView.setOnMouseClicked(event -> {
            event.consume();
            masterView.onComponentOptionClick(experiment);
            System.out.println("clicked");
        });

        Label description = descriptionBuilder(experiment);
        ScrollPane scrollPane = userInitialsBuilder();

        anchorPane.getChildren().addAll(title, imageView, description, scrollPane);
        return anchorPane;
    }

    private static Label titleBuilder(Experiment experiment) {
        Label title = new Label(experiment.getName());
        title.setMaxWidth(WIDTH - 40);
        title.setTooltip(new Tooltip(experiment.getName()));
        title.setFont(new Font("Arial", 16));
        title.setLayoutX(15);
        title.setLayoutY(10);
        title.setPrefWidth(Double.MAX_VALUE);
        title.setPrefHeight(20);
        title.setStyle("-fx-background-color: white;");

        return title;
    }

    private static ImageView menuBuilder() {
        ImageView imageView = new ImageView(new Image(ResourceUtil.get("/img.icons/options.png").toExternalForm()));
        imageView.setLayoutX(WIDTH - 40);
        imageView.setLayoutY(17);
        imageView.setStyle("-fx-cursor: hand;");

        return imageView;
    }

    private static Label descriptionBuilder(Experiment experiment) {
        Label description = new Label(experiment.getDescription());
        description.setTooltip(new Tooltip(experiment.getDescription()));
        description.setLayoutX(15);
        description.setLayoutY(37);

        description.setPrefWidth(WIDTH - 40);
        description.maxWidth(WIDTH - 40);

        description.setPrefHeight(60);

        description.setAlignment(Pos.TOP_LEFT);
        description.setWrapText(true);
        description.setFont(new Font("Arial", 12));

        return description;
    }

    private static ScrollPane userInitialsBuilder() {
        HBox content = new HBox();
        for (int i = 0; i < 20; i++) {
            content.getChildren().add(new UserInitialsComponent("AJ"));
//            content.getChildren().get()
        }
        content.setSpacing(5);

        ScrollPane scrollPane = new ScrollPane(content);

        scrollPane.setLayoutY(95);
        scrollPane.setLayoutX(15);
        scrollPane.setPrefWidth(WIDTH - 40);
        scrollPane.setMaxWidth(WIDTH - 40);
        scrollPane.setPrefHeight(50);
        scrollPane.setMaxHeight(50);
        scrollPane.setId("scroll-pane");

        return scrollPane;
    }

    private void setup() {
        this.setMaxWidth(WIDTH);
        this.setMaxHeight(HEIGHT);
        this.setMinWidth(WIDTH);
        this.setMinHeight(HEIGHT);
        this.setStyle("-fx-background-color: #fff;");
    }
}
