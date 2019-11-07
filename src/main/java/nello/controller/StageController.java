package nello.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import nello.util.ResourceUtil;
import nello.view.BeforeDisplay;
import nello.view.FXMLView;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

public class StageController {

    private static Logger logger = Logger.getLogger(StageController.class.getCanonicalName());
    private Stage primaryStage;
    private Scene mainScene;


    private Pane rootOf(FXMLView view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL resourcePath = ResourceUtil.get(view.getFXMLPath());
        fxmlLoader.setLocation(resourcePath);
        fxmlLoader.setController(view);
        return fxmlLoader.load();
    }

    public void prepareStage(Stage primaryStage) {
        this.mainScene = new Scene(new Pane());
        this.primaryStage = primaryStage;
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

    public void loadView(FXMLView view) {
        try {
            Pane root = rootOf(view);

            if (view instanceof BeforeDisplay) {
                ((BeforeDisplay) view).beforeShow();
            }

            this.mainScene.setRoot(root);

        } catch (IOException e) {
            logger.severe("Failed to load view: " + view.getFXMLPath());
            e.printStackTrace();
        }
    }

    public void loadPopup(FXMLView view) {
        try {
            Pane root = rootOf(view);

            ((Pane) this.primaryStage.getScene().getRoot()).getChildren().add(root);
        } catch (IOException e) {
            logger.severe("Failed to load view: " + view.getFXMLPath());
            e.printStackTrace();
        }
    }

    public Pane getRoot(FXMLView view) {
        try {
            return rootOf(view);
        } catch (IOException e) {
            logger.severe("Failed to load view: " + view.getFXMLPath());
            e.printStackTrace();
        }
        return null;
    }
}
