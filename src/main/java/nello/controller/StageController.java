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

    private final FXMLLoader fxmlLoader;
    private static Logger logger = Logger.getLogger(StageController.class.getCanonicalName());
    private Stage primaryStage;
    private Scene mainScene;

    public StageController() {
        this.fxmlLoader = new FXMLLoader();
    }

    private Pane rootOf(FXMLView view) throws IOException {
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
}
