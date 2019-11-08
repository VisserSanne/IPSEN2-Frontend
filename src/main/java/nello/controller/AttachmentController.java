package nello.controller;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

public class AttachmentController implements IController {

    public void pickAttachment() {
        JFileChooser fileChooser = new JFileChooser();
        configureFileChooser(fileChooser);
        //Todo: add stage
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            File chosenFile = fileChooser.getSelectedFile();
            setInDb(chosenFile);
        }


    }

    private void configureFileChooser(JFileChooser fileChooser) {
        fileChooser.setDialogTitle("Choose File");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Textual documents and images", "doc", "txt", "jpg", "png");
        fileChooser.setFileFilter(filter);
    }


    private byte[] setInDb(File file) {
        try {
            FileInputStream inputStream = new FileInputStream(file);
            int fileLength = (int) file.length();
            byte[] incoming_file_data = new byte[fileLength]; // allocate byte array of right size
            inputStream.read(incoming_file_data, 0, fileLength); // read into byte array
            inputStream.close();
            return incoming_file_data;
            //Todo: to db
        } catch (Exception err) {
            err.printStackTrace();
            return null;
        }

    }
}