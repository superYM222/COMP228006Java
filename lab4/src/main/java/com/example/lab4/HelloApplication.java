package com.example.lab4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.FirstPane;
import javafx.scene.layout.BorderPane;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        FirstPane firstPane = new FirstPane();

        BorderPane pane = firstPane.createPane();

        Scene scene = new Scene(pane, 715, 400);

        stage.setTitle("Lab 4");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
