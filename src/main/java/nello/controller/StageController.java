package nello.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import nello.util.ResourceUtil;
import nello.view.AbstractView;
import nello.view.FXMLView;

import java.io.IOException;
import java.net.URL;

public class StageController {
    private final FXMLLoader fxmlLoader;
    private final Stage primaryStage;

    public StageController(Stage stage, FXMLView startView) {
        this.primaryStage = stage;
        fxmlLoader = new FXMLLoader();
        initScene(startView);
    }

    private void initScene(FXMLView startView) {
        try {
            Pane root = rootOf(startView);
            Scene s = new Scene(root);
            primaryStage.setScene(s);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * clear the stage and set new view on active.
     *
     * @param view {@link AbstractView} that needs to be shown.
     */
    public void switchTo(FXMLView view) {
        try {
            Pane root = rootOf(view);
            primaryStage.getScene().setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Pane rootOf(FXMLView view) throws IOException {
        URL resourcePath = ResourceUtil.get(view.toString());
        fxmlLoader.setLocation(resourcePath);
        return fxmlLoader.load();
    }

}
