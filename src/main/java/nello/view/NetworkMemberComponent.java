package nello.view;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nello.util.ResourceUtil;


public class NetworkMemberComponent extends HBox {

    public NetworkMemberComponent(String name, boolean isEinstein, boolean isBusiness) {
        super(createChildrenNodes(name, isEinstein, isBusiness));
    }

    private static Node[] createChildrenNodes(String name, boolean isEinstein, boolean isBusiness) {

        // amount of nodes needed
        int node_size = isEinstein ? 4 : 2;

        Node[] children = new Node[node_size];
        children[0] = getIconImageView(isBusiness);
        children[1] = getNameLabel(name);

        if (!isEinstein)
            return children;

        // create region
        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);

        // add space between name and einsteinTag
        children[2] = region;

        // create einstein tag.
        children[3] = getEinsteinTag();

        return children;
    }

    private static Node getIconImageView(boolean isBusiness) {
        String icon = isBusiness ? "icon_briefcase" : "icon_user";
        String iconPath = String.format("/img/icon/%s.png", icon);
        return new ImageView(new Image(ResourceUtil.get(iconPath).toExternalForm()));
    }

    private static Label getNameLabel(String name) {
        Label nameLabel = new Label(name);
        nameLabel.setMinHeight(22);
        nameLabel.setMaxHeight(22);
        nameLabel.setMaxWidth(120);
        nameLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        HBox.setMargin(nameLabel, new Insets(0, 0, 0, 21));
        nameLabel.setTooltip(new Tooltip(name));
        return nameLabel;
    }

    private static Label getEinsteinTag() {
        Label tag = new Label("Einstein");
        tag.getStyleClass().add("tag-einstein");
        tag.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tag.setBackground(new Background(new BackgroundFill(Color.web("#ead545"), CornerRadii.EMPTY, Insets.EMPTY)));
        tag.setPadding(new Insets(2, 14, 2, 14));
        tag.setBorder(new Border(new BorderStroke(Color.web("#beac34"), BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
        tag.setMaxHeight(26);
        tag.textFillProperty().set(Color.WHITE);
        tag.textFillProperty().setValue(Color.WHITE);
        return tag;
    }


}
