package nello.view;

public abstract class AbstractView {

    private String FXMLPath;

    public AbstractView(String FXMLPath) {
        this.FXMLPath = FXMLPath;
    }

    public String getFXMLPath() {
        return FXMLPath;
    }
}
