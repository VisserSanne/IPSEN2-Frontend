package nello.controller;

import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AttachmentController implements IController {

    private final Desktop desktop = Desktop.getDesktop();

    public void pickAttachment(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            openFile(file);
        }
    }


    private void openFile(File file) {
        EventQueue.invokeLater(() -> {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.getStackTrace();
            }
        });
    }

}
