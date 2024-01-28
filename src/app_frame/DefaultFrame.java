package app_frame;

import javax.swing.*;
import java.awt.*;

public class DefaultFrame extends JFrame {
    JButton addButton= new JButton();
    JButton removeButton= new JButton();
    JButton editButton= new JButton();
    public DefaultFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(600,600);
        this.setTitle("GPA CALCULATOR");
        this.setLayout(null); //TODO
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        addButton.setVisible(true);
        addButton.setSize(150,150);
        addButton.setText("ADD");
        addButton.setBackground(Color.GREEN);

        this.add(addButton);
    }



}
