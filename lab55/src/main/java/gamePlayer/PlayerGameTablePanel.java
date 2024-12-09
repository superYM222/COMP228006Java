package gamePlayer;

import dataConnection.DataConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PlayerGameTablePanel extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;
    private DataConnect dataConnect;

    public PlayerGameTablePanel(DataConnect dataConnect) {
        this.dataConnect = dataConnect;

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        tableModel.setColumnIdentifiers(new String[]{"player_game_id", "game_id", "player_id", "playing_date", "score"});
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void loadData() {
        ArrayList<Object[]> data = dataConnect.loadDataFromDatabase();
        tableModel.setRowCount(0);

        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }
}
