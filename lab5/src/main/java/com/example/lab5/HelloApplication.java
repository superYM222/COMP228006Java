package com.example.lab5;
import com.example.lab5.database.ConnectDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;

import static com.example.lab5.database.ConnectDatabase.getConnection;

public class HelloApplication extends Application {
    private JFrame frame;
    private JTextField playerIdField, firstNameField, lastNameField, addressField, postalCodeField, provinceField, phoneNumberField;
    private JComboBox<String> gameComboBox;
    @Override

    public void start(Stage stage) throws IOException {

        frame = new JFrame("Game and Player Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Input Fields
        JPanel inputPanel = new JPanel(new GridLayout(8, 2));
        inputPanel.add(new JLabel("Player ID:"));
        playerIdField = new JTextField();
        inputPanel.add(playerIdField);

        inputPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        inputPanel.add(firstNameField);

        inputPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField);

        inputPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Postal Code:"));
        postalCodeField = new JTextField();
        inputPanel.add(postalCodeField);

        inputPanel.add(new JLabel("Province:"));
        provinceField = new JTextField();
        inputPanel.add(provinceField);

        inputPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        inputPanel.add(phoneNumberField);

        inputPanel.add(new JLabel("Game Title:"));
        gameComboBox = new JComboBox<>();
        populateGames();
        inputPanel.add(gameComboBox);

        // Buttons
        JButton insertButton = new JButton("Insert Player");
        insertButton.addActionListener(e -> insertPlayer());

        JButton updateButton = new JButton("Update Player");
        updateButton.addActionListener(e -> updatePlayer());

        JButton reportButton = new JButton("View Players & Games");
        reportButton.addActionListener(e -> viewReports());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(reportButton);

        // Frame Layout
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }
    private void populateGames() {
        try (Connection connection = ConnectDatabase.getConnection()) {
            String query = "SELECT game_title FROM game";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                gameComboBox.addItem(resultSet.getString("game_title"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error populating games: " + e.getMessage());
        }
    }

    private void insertPlayer() {
        String query = "INSERT INTO player (player_id, first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Integer.parseInt(playerIdField.getText()));
            statement.setString(2, firstNameField.getText());
            statement.setString(3, lastNameField.getText());
            statement.setString(4, addressField.getText());
            statement.setString(5, postalCodeField.getText());
            statement.setString(6, provinceField.getText());
            statement.setString(7, phoneNumberField.getText());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Player inserted successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error inserting player: " + e.getMessage());
        }
    }

    private void updatePlayer() {
        String query = "UPDATE player SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ? WHERE player_id = ?";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, firstNameField.getText());
            statement.setString(2, lastNameField.getText());
            statement.setString(3, addressField.getText());
            statement.setString(4, postalCodeField.getText());
            statement.setString(5, provinceField.getText());
            statement.setString(6, phoneNumberField.getText());
            statement.setInt(7, Integer.parseInt(playerIdField.getText()));
            statement.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Player updated successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error updating player: " + e.getMessage());
        }
    }

    private void viewReports() {
        // Display reports in a new JTable window
    }

    public void run() {
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        launch();

    }
}