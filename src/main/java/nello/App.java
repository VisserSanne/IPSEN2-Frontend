package nello;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class App extends Application {


    public static void main(String[] args) {
        System.out.println("Hello Nello!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Nello nello = new Nello();
        nello.shine(primaryStage);
        nello.shine();
    }
}
