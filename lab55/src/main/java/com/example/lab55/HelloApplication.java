package com.example.lab55;

import dataConnection.DataConnect;
import gamePlayer.Player;
import gamePlayer.PlayerGame;
import gamePlayer.PlayerGameTablePanel;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;

import javax.swing.*;
import java.awt.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        SwingNode swingNode = new SwingNode();
        createSwingContent(swingNode);

        StackPane root = new StackPane();
        root.getChildren().add(swingNode);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Player Game Manager");
        stage.setScene(scene);
        stage.show();
    }

    private void createSwingContent(SwingNode swingNode) {
        SwingUtilities.invokeLater(() -> {
            // 메인 패널 설정
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            // 데이터 연결 및 테이블 패널 생성
            DataConnect dataConnect = new DataConnect();
            PlayerGameTablePanel tablePanel = new PlayerGameTablePanel(dataConnect);

            // 테이블 크기 조정
            JScrollPane tableScrollPane = new JScrollPane(tablePanel);
            tableScrollPane.setPreferredSize(new Dimension(700, 200)); // 테이블 크기 줄임

            // 버튼 패널 1 (Player 관련 버튼)
            JPanel buttonPanel1 = new JPanel(new FlowLayout());
            JButton addPlayerButton = new JButton("Add Player");
            addPlayerButton.addActionListener(e -> {
                Player playerDialog = new Player();
                playerDialog.setVisible(true);
            });
            buttonPanel1.add(addPlayerButton);


            JPanel buttonPanel2 = new JPanel(new FlowLayout());

            // Add Data 버튼
            JButton addDataButton = new JButton("Add Data");
            addDataButton.addActionListener(e -> {
                PlayerGame playerGameDialog = new PlayerGame(tablePanel, dataConnect);
                playerGameDialog.setVisible(true);
            });

            // Show Table 버튼
            JButton showTableButton = new JButton("Refresh Table");
            showTableButton.addActionListener(e -> {
                tablePanel.loadData(); // 테이블 데이터를 메인 화면에서 갱신
            });

            buttonPanel2.add(addDataButton);
            buttonPanel2.add(showTableButton);

            // 메인 패널에 컴포넌트 추가
            mainPanel.add(tableScrollPane, BorderLayout.CENTER); // 테이블 패널 중앙
            mainPanel.add(buttonPanel1, BorderLayout.NORTH); // Add Player 버튼 위쪽
            mainPanel.add(buttonPanel2, BorderLayout.SOUTH); // Game 버튼 아래쪽

            // SwingNode에 메인 패널 설정
            swingNode.setContent(mainPanel);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
