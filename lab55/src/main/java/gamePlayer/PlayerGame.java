package gamePlayer;

import dataConnection.DataConnect;

import javax.swing.*;

public class PlayerGame extends JDialog {
    private JPanel contentPane;
    private JButton btnOkay;
    private JButton buttonCancel;
    private JLabel lb_player_game_id;
    private JLabel lb_game_id;
    private JLabel lb_player_id;
    private JLabel lb_playing_data;
    private JLabel lb_score;
    private JTextField player_game_id;
    private JTextField game_id;
    private JTextField player_id;
    private JTextField playing_data;
    private JTextField score;
    private PlayerGameTablePanel tablePanel;
    private DataConnect dataConnect;

    public PlayerGame(PlayerGameTablePanel tablePanel, DataConnect dataConnect) {
        this.tablePanel = tablePanel;
        this.dataConnect = dataConnect;

        setContentPane(contentPane);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnOkay.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> dispose());
    }

    private void onOK() {
        String playerGameId = player_game_id.getText();
        String gameId = game_id.getText();
        String playerId = player_id.getText();
        String playingData = playing_data.getText();
        String scoreData = score.getText();

        dataConnect.saveDataPlayerandGame(playerGameId, gameId, playerId, playingData, scoreData);
        tablePanel.loadData();

        JOptionPane.showMessageDialog(contentPane, "Player Game saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
