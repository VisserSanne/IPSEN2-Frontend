package nello.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import nello.factories.ViewFactory;
import nello.util.ResourceUtil;
import nello.view.AbstractFXMLView;
import nello.view.FXMLView;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

public class StageController {

    private final FXMLLoader fxmlLoader;
    private static Logger logger = Logger.getLogger(StageController.class.getCanonicalName());
    private final ViewFactory viewFactory;
    private MainController mainController;
    private Stage primaryStage;
    private Scene mainScene;

    public StageController(MainController mainController) {
        this.mainController = mainController;
        this.fxmlLoader = new FXMLLoader();
        this.viewFactory = new ViewFactory();

    }

    private Pane rootOf(FXMLView view) throws IOException {
        // get controller
        IController controller = mainController.getController(view.getController());

        //get view
        AbstractFXMLView viewController = viewFactory.createView(view);

        viewController.setController(controller); // weird warning
        viewController.onCreate();

        URL resourcePath = ResourceUtil.get(viewController.getFxmlPath());
        fxmlLoader.setLocation(resourcePath);
        fxmlLoader.setController(viewController);
        viewController.beforeDisplay();
        return fxmlLoader.load();
    }

    public void setStage(Stage primaryStage) {
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

    public void loadView(FXMLView startView) {
        try {
            Pane root = rootOf(startView);
            this.mainScene.setRoot(root);

        } catch (IOException e) {
            logger.severe("Failed to load view: " + startView);
            e.printStackTrace();
        }
    }
}
