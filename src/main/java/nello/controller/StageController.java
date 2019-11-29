package nello.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import nello.util.ResourceUtil;
import nello.view.BeforeDisplay;
import nello.view.FXMLView;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Logger;

public class StageController {

    private static final double MAX_WIDTH = 1366;
    private static final double MAX_HEIGHT = 768;
    private static Logger logger = Logger.getLogger(StageController.class.getCanonicalName());
    private HashMap<FXMLView, Pane> openViews = new HashMap<>();
    private Stage primaryStage;
    private Scene mainScene;


    private Pane rootOf(FXMLView view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL resourcePath = ResourceUtil.get(view.getFXMLPath());
        System.out.println(resourcePath);
        fxmlLoader.setLocation(resourcePath);
        fxmlLoader.setController(view);
        return fxmlLoader.load();
    }

    public void prepareStage(Stage primaryStage) {
        this.mainScene = new Scene(new Pane());
        this.primaryStage = primaryStage;
        this.primaryStage.setMaxHeight(MAX_HEIGHT);
        this.primaryStage.setMaxWidth(MAX_WIDTH);
        this.primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(ResourceUtil.get("/img/login/logo_nello.png").toExternalForm()));
        primaryStage.setScene(mainScene);
    }

    public void show() {
        this.primaryStage.show();
    }

    public void hide() {
        this.primaryStage.hide();
    }

    public void close() {
        this.primaryStage.close();
    }


    public void displayView(FXMLView view) {
        try {
            Pane root = rootOf(view);

            if (view instanceof BeforeDisplay) {
                ((BeforeDisplay) view).beforeShow();
            }
            this.openViews.put(view, root);
            this.mainScene.setRoot(root);

        } catch (IOException e) {
            logger.severe("Failed to load view: " + view.getFXMLPath());
            e.printStackTrace();
        }
    }

    /**
     * display as popup centerd in screen.
     *
     * @param popup
     */
    public void displayPopup(FXMLView popup) {
        this.displayPopup(popup, -1, -1, null);
    }

    public void displayPopup(FXMLView popup, EventHandler<MouseEvent> eventHandler) {
        this.displayPopup(popup, -1, -1, eventHandler);
    }

    public void displayPopup(FXMLView popup, double x, double y, EventHandler<MouseEvent> eventHandler) {
        try {
            Pane root = rootOf(popup);

            if (popup instanceof BeforeDisplay) {
                ((BeforeDisplay) popup).beforeShow();
            }

            if (x == -1 && y == -1) {
                System.out.println("centered popup");
                BorderPane closableBorderPane = getClosableBorderPane(root, popup, eventHandler);
                this.openViews.put(popup, closableBorderPane);
                ((Pane) this.mainScene.getRoot()).getChildren().add(closableBorderPane);
            } else {
                root.setLayoutX(x);
                root.setLayoutY(y);
                AnchorPane closablePane = getClosablePane(root, popup, eventHandler);
                this.openViews.put(popup, closablePane);
                ((Pane) this.mainScene.getRoot()).getChildren().add(closablePane);
            }

        } catch (IOException e) {
            logger.severe("Failed to load popup: " + popup.getFXMLPath());
            e.printStackTrace();
        }
    }


    public void closeView(FXMLView view) {
        if (!openViews.containsKey(view))
            return;

        Pane root = openViews.get(view);
        removePane(root);
        openViews.remove(view);
    }

    private void removePane(Pane root) {

        ((Pane) this.mainScene.getRoot()).getChildren().remove(root);
    }


    private BorderPane getClosableBorderPane(Pane child, FXMLView popup, EventHandler<MouseEvent> eventHandler) {
        BorderPane root = new BorderPane();
        root.setCenter(child);
        root.setMinWidth(MAX_WIDTH);
        root.setMaxWidth(MAX_WIDTH);
        root.setMinHeight(MAX_HEIGHT);
        root.setMaxHeight(MAX_HEIGHT);
        root.setStyle("-fx-background-color: rgba(0,0,0,0.2)");
        root.setOnMouseClicked(event -> {


            if (event.getTarget().equals(root)) {
                if (eventHandler != null)
                    eventHandler.handle(event);


                removePane(root);
                closeView(popup);
            }
        });
        return root;
    }

    private AnchorPane getClosablePane(Pane child, FXMLView popup, EventHandler<MouseEvent> eventHandler) {
        AnchorPane root = new AnchorPane(child);
        root.setMaxWidth(MAX_WIDTH);
        root.setMinWidth(MAX_WIDTH);
        root.setMinHeight(MAX_HEIGHT);
        root.setMaxHeight(MAX_HEIGHT);
        root.setOnMouseClicked(event -> {
            removePane(root);
            closeView(popup);
        });

        return root;
    }

    public Pane getRoot(FXMLView view) {
        try {
            return rootOf(view);
        } catch (IOException e) {
            logger.severe("Failed to load popup: " + view.getFXMLPath());
            e.printStackTrace();
        }
        return null;
    }

    public void closeAllView() {
        for (Pane view : openViews.values()) {
            removePane(view);
            openViews.remove(view);
        }
    }
}
