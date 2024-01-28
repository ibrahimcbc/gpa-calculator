package app_frame;

import course.*;

import javax.swing.*;
import java.awt.*;

public class DefaultFrame extends JFrame {
    JButton addButton= new JButton();

    CourseManager courseManager=new CourseManager();

    LabelCourse labelCourse= new LabelCourse(new Course("COMP132",3,3.70,true));
    public DefaultFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(600,600);
        this.setTitle("GPA CALCULATOR");
        this.setLayout(null); //TODO
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        addButton.setVisible(true);
        addButton.setLocation(400,400);
        addButton.setSize(50,50);
        addButton.setText("ADD");
        addButton.setBackground(Color.GREEN);

        this.add(addButton);
        this.add(labelCourse);
    }



}
