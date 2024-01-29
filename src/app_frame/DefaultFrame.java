package app_frame;

import course.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultFrame extends JFrame {
    JButton buttonAdd= new JButton();
    JPanel panelAdd=new JPanel();
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

        buttonAdd.setVisible(true);
        buttonAdd.setLocation(400,400);
        buttonAdd.setSize(50,50);
        buttonAdd.setText("ADD");
        buttonAdd.setBackground(Color.GREEN);

        this.add(buttonAdd);
        this.add(labelCourse);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course new_course=new Course("COMP201",3,3.00,true);
                courseManager.addCourse("COMP132",new_course);
            }
        });
    }


}
