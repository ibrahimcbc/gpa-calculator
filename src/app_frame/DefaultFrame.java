package app_frame;

import course.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultFrame extends JFrame {
    public JButton buttonAdd= new JButton();
    public JPanel panelAdd=new JPanel();
    public JLabel labelGPA=new JLabel();

    JTextField courseNameField= new JTextField();
    JTextField courseUnitField= new JTextField();
    String[] gradeOptions = {"A", "A-","B+","B","B-","C+","C","C-","D+","D","F"};
    JComboBox<String> gradesComboBox=new JComboBox(gradeOptions);
    JCheckBox courseIncludedBox=new JCheckBox();
    JButton courseConfirm=new JButton();
    JButton courseBack=new JButton();
    public DefaultFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(600,800);
        this.setTitle("GPA CALCULATOR");
        this.setLayout(null); //TODO
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.darkGray);

        buttonAdd.setVisible(true);
        buttonAdd.setLocation(200,700);
        buttonAdd.setSize(60,50);
        buttonAdd.setText("ADD");
        buttonAdd.setBackground(Color.lightGray);

        panelAdd.setVisible(false);
        panelAdd.setLocation(50,400);
        panelAdd.setSize(500,35);
        panelAdd.setBackground(Color.cyan);

        courseNameField.setLocation(20,5);
        courseNameField.setSize(85,25);

        courseUnitField.setLocation(135,5);
        courseUnitField.setSize(25,25);

        gradesComboBox.setLocation(200,5);
        gradesComboBox.setSize(42,25);

        courseIncludedBox.setLocation(255,5);
        courseIncludedBox.setSize(25,25);

        courseBack.setLocation(320,5);
        courseBack.setText("BACK");
        courseBack.setSize(65,25);

        courseConfirm.setLocation(420,5);
        courseConfirm.setText("APPLY");
        courseConfirm.setSize(60,25);

        labelGPA.setVisible(true);
        labelGPA.setLocation(400,700);
        labelGPA.setSize(120,50);
        labelGPA.setForeground(Color.lightGray);

        panelAdd.setLayout(null);

        this.add(panelAdd);
        this.add(buttonAdd);
        this.add(labelGPA);

        panelAdd.add(courseNameField);
        panelAdd.add(courseUnitField);
        panelAdd.add(courseIncludedBox);
        panelAdd.add(gradesComboBox);
        panelAdd.add(courseBack);
        panelAdd.add(courseConfirm);

        courseConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course new_course=new Course(courseNameField.getText(),Integer.parseInt(courseUnitField.getText()),(String)gradesComboBox.getSelectedItem(),courseIncludedBox.isSelected());
                CourseManager.courses.put(new_course.getName(),new_course);
                CourseManager.writeToFile(new_course.getName(),new_course.getUnits(),new_course.getGrade(),new_course.isIncluded());
                LabelCourse labelCourse= new LabelCourse(new_course);
                addCoursePanel(labelCourse);
                panelAdd.setVisible(false);
                buttonAdd.setVisible(true);
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonAdd.setVisible(false);
                panelAdd.setVisible(true);
            }
        });

        courseBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAdd.setVisible(false);
                buttonAdd.setVisible(true);
            }
        });
    }
    public void addCoursePanel(LabelCourse labelCourse){
        System.out.println("DONE!!!!"); //TODO sorun 1 kere ekrana eklemesi sonra positionu ayarlayamıyor.
        this.add(labelCourse);
        this.repaint();
    }

}
