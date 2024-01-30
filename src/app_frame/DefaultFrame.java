package app_frame;

import course.*;

import javax.swing.*;
import java.awt.*;

public class DefaultFrame extends JFrame {
    public JButton buttonAdd= new JButton();
    JPanel panelAdd=new JPanel();

    JLabel labelGPA=new JLabel();
    public DefaultFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(600,600);
        this.setTitle("GPA CALCULATOR");
        this.setLayout(null); //TODO
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.darkGray);

        buttonAdd.setVisible(true);
        buttonAdd.setLocation(400,400);
        buttonAdd.setSize(60,50);
        buttonAdd.setText("ADD");
        buttonAdd.setBackground(Color.lightGray);

        labelGPA.setVisible(true);


        this.add(buttonAdd);
        this.add(labelGPA);
    }
    public void addCoursePanel(LabelCourse labelCourse){
        this.add(labelCourse);
        this.repaint();
    }

}
