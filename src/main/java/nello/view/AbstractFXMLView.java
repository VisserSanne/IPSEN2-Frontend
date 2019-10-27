package nello.view;

import javafx.fxml.Initializable;
import nello.controller.IController;

import java.util.logging.Logger;

public abstract class AbstractFXMLView<C extends IController> implements Initializable {

    private final FXMLView fxmlPath;
    private final Logger logger = Logger.getLogger(AbstractFXMLView.class.getCanonicalName());
    private C controller;

    /**
     * private to package only.
     * construct a new FXMLView
     *
     * @param FXMLPath
     */
    AbstractFXMLView(FXMLView FXMLPath) {
        this.fxmlPath = FXMLPath;
    }

    /**
     * get Controller
     *
     * @return Controller
     */
    public C getController() {
        return controller;
    }

    /**
     * set Controller
     *
     * @param controller
     */
    public void setController(C controller) {
        assert controller != null;
        this.controller = controller;
    }

    /**
     * get path to FXML
     *
     * @return .fxml filepath of this view
     */
    public String getFxmlPath() {
        return fxmlPath.toString();
    }

    public void onCreate() {
        logger.info(String.format("created view: %s", fxmlPath));
    }

    public void beforeDisplay() {
        logger.info(String.format("attempting to display view: '%s'", this.fxmlPath));
    }

}
