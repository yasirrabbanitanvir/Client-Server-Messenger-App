package client;
//kaj   input licener that work when we input. 
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextListener implements DocumentListener {
    JTextField ipAddress;
    JTextField portAddress;
    JTextField userName;
    JButton connectButton;

    public TextListener(JTextField ipAddress, JTextField portAddress, JTextField userName, JButton connectButton) {
        this.ipAddress = ipAddress;
        this.portAddress = portAddress;
        this.userName = userName;
        this.connectButton = connectButton;
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        if(ipAddress.getText().trim().equals("") ||
           portAddress.getText().trim().equals("") ||
           userName.getText().trim().equals("")) {
            connectButton.setEnabled(false);
        }else {
            connectButton.setEnabled(true);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {//connect button visible and invisible 
        if(ipAddress.getText().trim().equals("") ||
                portAddress.getText().trim().equals("") ||
                userName.getText().trim().equals("")) {
            connectButton.setEnabled(false);
        }else {
            connectButton.setEnabled(true);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) { }
}