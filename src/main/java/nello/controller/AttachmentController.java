package nello.controller;

public class AttachmentController implements IController {

    public pickAttachment(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(stage);
    }

}
