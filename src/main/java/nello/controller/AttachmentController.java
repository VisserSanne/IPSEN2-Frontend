package nello.controller;

import com.google.gson.Gson;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nello.model.Attachment;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.Calendar;

public class AttachmentController implements IController {

    private MainController mainController;

    public AttachmentController(MainController mainController) {
        this.mainController = mainController;
    }

    public void pickAttachment() {
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        //Todo: add stage
        File file = fileChooser.showOpenDialog(buildSubStage());
        if (file != null) {
            setInDb(file);
        }


    }

    private void configureFileChooser(FileChooser fileChooser) {
        fileChooser.setTitle("Choose File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(
                "Textual documents and images", "doc", "txt", "jpg", "png");
        fileChooser.setSelectedExtensionFilter(filter);
    }


    private void setInDb(File file) {
        try {
            Attachment newAttachement = new Attachment(
                    1,
                    1,
                    "",
                    1,
                    null,
                    Attachment.FileType.DOCX,
                    true,
                    new java.sql.Date(Calendar.getInstance().getTime().getTime()));
//            FileInputStream inputStream = new FileInputStream(file);
//            int fileLength = (int) file.length();
//            byte[] incoming_file_data = new byte[fileLength]; // allocate byte array of right size
//            inputStream.read(incoming_file_data, 0, fileLength); // read into byte array
//            inputStream.close();

            String attachementJSON = new Gson().toJson(newAttachement);

            FormDataMultiPart formData = new FormDataMultiPart();
            FileDataBodyPart fileData = new FileDataBodyPart("file",file);

            formData.field(
                    "data",
                    attachementJSON,
                    MediaType.APPLICATION_JSON_TYPE
            ).bodyPart(fileData);


            mainController.getHttpController().postFormData(
                    "/attachments/",
                    formData

            ).getEntity();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public Stage buildSubStage(){
        Stage fileChooseStage = new Stage();
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 200);
        fileChooseStage.setScene(scene);
        return fileChooseStage;
    }
}