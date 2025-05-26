package utils;

import entities.Client;

import javax.swing.*;
import java.awt.*;

public class ClientLabel extends JLabel {
    public ClientLabel(Client client) {
        setText(client.getName());
        setForeground(new Color(210, 210, 210));
        setFont(new Font("", Font.BOLD, 70));
        setBounds(200, 400, 800, 100);
        setHorizontalAlignment(CENTER);
        setVisible(true);
    }
}
