package pane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;

public class FirstPane {

    private List<TextField> textFields = new ArrayList<>(); // 모든 TextField를 저장할 리스트

    public BorderPane createPane() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20, 12, 13, 14));
        pane.setHgap(5);
        pane.setVgap(5);

        VBox vbox = new VBox(0);
        VBox vBox2 = new VBox(0);
        vBox2.setSpacing(0);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(5, 5, 5, 5));

        RadioButton rdComputer = new RadioButton("Computer-Science");
        RadioButton rdBusiness = new RadioButton("Business");


        ObservableList<String> items = FXCollections.observableArrayList("Java", "Python", "C#");
        ToggleGroup group = new ToggleGroup();
        rdComputer.setToggleGroup(group);
        rdBusiness.setToggleGroup(group);

        hbox.getChildren().addAll(rdComputer, rdBusiness);


        ComboBox<String> comboBox = new ComboBox<>(items);
        ListView<String> listView = new ListView<>(items);
        comboBox.setPrefWidth(200);
        comboBox.setValue("Java");
        comboBox.setStyle("-fx-font-size: 14px; -fx-pref-height: 35px;");


        listView.setPrefWidth(200);
        listView.setPrefHeight(150);
        listView.setMaxHeight(100);
        listView.setMinHeight(150);
        listView.setMaxWidth(200);
        listView.setMinWidth(200);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Button display = new Button("Display");

        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPadding(new Insets(0));
        textArea.setPrefSize(1000, 100);

        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        vBox2.getChildren().addAll(display, scrollPane);
        vBox2.setSpacing(2);
        vBox2.setAlignment(Pos.BOTTOM_CENTER);
        hbox.setAlignment(Pos.BASELINE_RIGHT);
        vbox.getChildren().addAll(hbox, comboBox, listView);
        hbox.setPadding(new Insets(5, 3, 10, 0));
        vbox.setPadding(new Insets(5, 0, 10, 0));

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(pane);
        borderPane.setRight(vbox);
        borderPane.setBottom(vBox2);
        borderPane.setPadding(new Insets(0));

        CheckBox checkbox = new CheckBox("Student Council");
        HBox provinceBox = new HBox(checkbox);
        provinceBox.setSpacing(0);
        provinceBox.setAlignment(Pos.CENTER_LEFT);

        CheckBox checkbox2 = new CheckBox("Volunteer Work");
        HBox phoneBox = new HBox(checkbox2);
        phoneBox.setSpacing(1);
        phoneBox.setAlignment(Pos.CENTER_LEFT);
        checkbox.setStyle("-fx-padding: 0; -fx-font-weight: bold;");
        checkbox2.setStyle("-fx-padding: 0; -fx-font-weight: bold;");
        checkbox.setScaleX(0.8);
        checkbox.setScaleY(0.8);
        checkbox2.setScaleX(0.8);
        checkbox2.setScaleY(0.8);


        TextField nameField = new TextField();
        nameField.setPrefWidth(250);
        pane.add(new Label("Name:"), 0, 0);
        pane.add(nameField, 1, 0);
        textFields.add(nameField); // 리스트에 추가

        TextField addressField = new TextField();
        addressField.setPrefWidth(250);
        pane.add(new Label("Address:"), 0, 1);
        pane.add(addressField, 1, 1);
        textFields.add(addressField);

        TextField provinceField = new TextField();
        provinceField.setPrefWidth(250);
        pane.add(new Label("Province:"), 0, 2);
        pane.add(provinceField, 1, 2);
        pane.add(checkbox, 3, 2);
        textFields.add(provinceField);

        TextField cityField = new TextField();
        cityField.setPrefWidth(250);
        pane.add(new Label("City:"), 0, 3);
        pane.add(cityField, 1, 3);
        textFields.add(cityField);

        TextField postalField = new TextField();
        postalField.setPrefWidth(250);
        pane.add(new Label("Postal code:"), 0, 4);
        pane.add(postalField, 1, 4);
        textFields.add(postalField);

        TextField phoneField = new TextField();
        phoneField.setPrefWidth(250);
        pane.add(new Label("Phone Number:"), 0, 5);
        pane.add(phoneField, 1, 5);
        pane.add(checkbox2, 3, 5);
        textFields.add(phoneField);

        TextField emailField = new TextField();
        emailField.setPrefWidth(250);
        pane.add(new Label("Email:"), 0, 6);
        pane.add(emailField, 1, 6);
        textFields.add(emailField);


        new Handler(textFields, textArea, display, listView ,checkbox,checkbox2, comboBox, rdComputer , rdBusiness);

        return borderPane;
    }
}
