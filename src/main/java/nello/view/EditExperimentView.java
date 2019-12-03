package nello.view;

import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import nello.controller.ExperimentController;
import nello.controller.MainController;
import nello.model.Experiment;
import nello.observable.ExperimentObservable;
import nello.observer.ExperimentObserver;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EditExperimentView implements FXMLView<ExperimentController>, ExperimentObserver, Initializable {
    @FXML
    public Pane parent;

    @FXML
    public TextField titleTextField;

    @FXML
    public TextArea descriptionTextField;

    @FXML
    public TextArea statusTextField;
    @FXML
    public TextField ownerTextField;

    @FXML
    public TextField costTextField;

    @FXML
    public TextField incomeTextField;

    @FXML
    public TextField networkMemberTextField;
    @FXML
    public CheckBox bussinessCheckBox;
    @FXML
    public FlowPane incomeFlowPane;
    @FXML
    public FlowPane costFlowPane;
    @FXML
    private ExperimentController controller;

    private final boolean isNew;
    @FXML
    private Rectangle statusColor;
    private String fxmlPath;


    public EditExperimentView(boolean isNew) {
        this.isNew = isNew;
        this.controller = MainController.getInstance().getExperimentController();
        this.fxmlPath = "/view/EditExperiment.fxml";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTextLimitTextArea(255, statusTextField);
        setTextLimitTextArea(255, descriptionTextField);
        setTextLimitTextField(255, titleTextField);
        setTextLimitTextField(255, ownerTextField);
        setTextLimitTextField(255, costTextField);
        setTextLimitTextField(255, incomeTextField);
        setTextLimitTextField(255, networkMemberTextField);
        getController().registerObserver(this::update);
    }


    @Override
    public void update(ExperimentObservable experiment) {
        updateTextField(titleTextField, experiment.getName());
        updateTextArea(descriptionTextField, experiment.getDescription());
        updateTextArea(statusTextField, experiment.getStatus());
        updateFinance(experiment.getCosts(), costFlowPane);
        updateFinance(experiment.getIncomes(), incomeFlowPane);
        this.statusColor.setFill(experiment.getStatusColor().getAsColor());
    }


    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public ExperimentController getController() {
        return controller;
    }

    @Override
    public void setController(ExperimentController controller) {
        this.controller = controller;
    }

    public void disableEditExperimentItems(Boolean disable) {
        for (Node node : parent.getChildren()) {
            node.setDisable(disable);
        }
    }

    public void onTitleChange(KeyEvent event) {
        getController().onNameChange(titleTextField.getText());
    }

    public void onDescriptionChange(KeyEvent event) {
        getController().onDescriptionChange(descriptionTextField.getText());
    }

    public void onStatusChange(KeyEvent event) {
        getController().onStatusChange(statusTextField.getText());
    }

    public void onOwnerChange(KeyEvent event) {
        getController().onOwnerChange(ownerTextField.getText());
    }

    public void addCost(MouseEvent event) {
        getController().onAddCost(costTextField.getText());
    }

    public void addIncome(MouseEvent event) {
        getController().onAddIncome(costTextField.getText());
    }

    public void addNetworkMember(MouseEvent event) {
        getController().onAddNetworkMember(networkMemberTextField.getText(), bussinessCheckBox.isSelected());
    }

    private void setTextLimitTextField(int limit, TextField textfield) {
        textfield.textProperty().addListener((observable, oldValue, newValue) -> {

            String text = textfield.getText();

            if (text.length() > limit) {
                textfield.setText(text.substring(0, text.length() - 1));
            }

        });
    }


    private void setTextLimitTextArea(int limit, TextArea textArea) {
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {

            String text = textArea.getText();

            if (text.length() > limit) {
                textArea.setText(text.substring(0, text.length() - 1));
            }

        });
    }

    private void updateFinance(List<String> list, FlowPane flowPane) {
        flowPane.getChildren().clear();
        if (list == null)
            return;

        for (String item : list) {
            Label itemLabel = new Label(item);
            itemLabel.getStyleClass().add("tag-finance");
            flowPane.getChildren().add(itemLabel);
        }

    }


    private void updateTextField(TextField textField, String newValue) {
        if (!textField.getText().equalsIgnoreCase(newValue))
            textField.setText(newValue);
    }

    private void updateTextArea(TextArea textArea, String newValue) {
        if (!textArea.getText().equalsIgnoreCase(newValue)) {
            textArea.setText(newValue);
        }
    }


    public void onStatusGreenMenuItemClick(ActionEvent actionEvent) {
        getController().onStatusColorChange(Experiment.StatusColor.GROEN);
    }

    public void onStatusOranjeMenuItemClick(ActionEvent actionEvent) {
        getController().onStatusColorChange(Experiment.StatusColor.ORANJE);

    }

    public void onStatusRedMenuItemClick(ActionEvent actionEvent) {
        getController().onStatusColorChange(Experiment.StatusColor.ROOD);
    }

    public void onFinishButtonClick(MouseEvent event) {
        getController().onFinishButtonClick();
    }

    public void onSaveButtonClick(MouseEvent event) {
        getController().onSaveButtonClick(isNew);
    }
}
