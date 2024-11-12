package pane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.List;

public class Handler {

    private List<TextField> textFields;
    private TextArea textArea;
    private Button displayButton;
    private ListView<String> listView;
    private CheckBox checkBox;
    private CheckBox checkbox2;
    private ComboBox<String> comboBox;
    private RadioButton rdComputer;
    private RadioButton rdBusiness;

    public Handler(List<TextField> textFields, TextArea textArea, Button displayButton, ListView<String> listView, CheckBox checkBox, CheckBox checkbox2, ComboBox<String> comboBox, RadioButton rdComputer, RadioButton rdBusiness) {
        this.textFields = textFields;
        this.textArea = textArea;
        this.displayButton = displayButton;
        this.listView = listView;
        this.comboBox = comboBox;
        this.rdComputer = rdComputer;
        this.rdBusiness = rdBusiness;
        this.checkBox = checkBox;
        this.checkbox2 = checkbox2;

        initialize();
    }

    private void initialize() {

        displayButton.setOnAction(event -> {
            textArea.clear();
            String selectedItem = comboBox.getValue();

            for (TextField textField : textFields) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    textArea.appendText(text + "\n");
                }
            }
            textArea.appendText(selectedItem + '\n');
            if (checkBox.isSelected()) {
                textArea.appendText(checkBox.getText() + '\n');
            }else if (checkbox2.isSelected()) {
                textArea.appendText(checkbox2.getText() + '\n');
            }
        });

        rdBusiness.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                ObservableList<String> businessItems = FXCollections.observableArrayList("Business 101", "Finance", "Marketing");
                comboBox.setItems(businessItems);
                comboBox.setValue("Business 101");
                listView.setItems(businessItems);
            } else {
                ObservableList<String> computerItems = FXCollections.observableArrayList("Java", "Python", "C#");
                comboBox.setItems(computerItems);
                comboBox.setValue("Java");
                listView.setItems(computerItems);
            }
        });
    }
}
