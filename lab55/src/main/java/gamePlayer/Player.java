package gamePlayer;

import dataConnection.DataConnect;

import javax.swing.*;
import java.awt.event.*;

public class Player extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel ld_Id;
    private JLabel lb_first_name;
    private JLabel lb_last_name;
    private JLabel lb_address;
    private JLabel lb_postalCode;
    private JLabel lb_province;
    private JLabel lb_phoneNum;
    private JTextField player_id;
    private JTextField first_name;
    private JTextField last_name;
    private JTextField address;
    private JTextField postal_code;
    private JTextField province;
    private JTextField phone_number;

    public Player() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void onOK() {
        String id = player_id.getText();
        String fname = first_name.getText();
        String lname = last_name.getText();
        String addr = address.getText();
        String pcode = postal_code.getText();
        String prov = province.getText();
        String phone = phone_number.getText();

        DataConnect dataConnect = new DataConnect();
        dataConnect.saveDataPlayer(id, fname, lname, addr, pcode, prov, phone);

        JOptionPane.showMessageDialog(contentPane, "Player saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void onCancel() {
        dispose();
    }
}
