package course;

import app_frame.DefaultFrame;

import javax.swing.*;
import java.awt.*;

public class LabelCourse extends JPanel {

    /* basic mode properties */
    JLabel courseName = new JLabel();
    JLabel courseUnit = new JLabel();
    JLabel courseGrade= new JLabel();
    JLabel courseIncluded= new JLabel();
    JButton courseEdit=new JButton();
    JButton courseRemove= new JButton();

    /* edit mode properties */

    JTextField courseNameField= new JTextField();
    JTextField courseUnitField= new JTextField();
    String[] gradeOptions = {"A", "A-","B+","B","B-","C+","C","C-","D+","D","F"};
    JComboBox<String> gradesComboBox=new JComboBox(gradeOptions);
    JCheckBox courseIncludedBox=new JCheckBox();
    JButton courseConfirm=new JButton();
    JButton courseBack=new JButton();

    public static int heightOnPage=50;

    public LabelCourse(Course course){
        this.setLayout(null);
        this.setSize(500,80); //TODO change height
        this.setLocation(50,heightOnPage);
        this.setBackground(Color.ORANGE);

        courseName.setLocation(20,5);
        courseName.setText(course.getName());
        courseName.setSize(85,25);

        courseUnit.setLocation(135,5);
        courseUnit.setText(course.getUnits()+""); //tricky way to convert int to string
        courseUnit.setSize(25,25);

        courseGrade.setLocation(210,5);
        courseGrade.setSize(25,25);

        courseIncluded.setLocation(285,5);
        courseIncluded.setSize(25,25);

        courseEdit.setLocation(360,5);
        courseEdit.setSize(25,25);

        courseRemove.setLocation(435,5);
        courseRemove.setSize(25,25);

        //gradesComboBox.setLocation(1,1);

        this.add(courseName);
        this.add(courseUnit);
        this.add(courseGrade);
        this.add(courseIncluded);
        this.add(courseEdit);
        this.add(courseRemove);
        /*
        this.add(courseNameField);
        this.add(courseUnitField);
        this.add(gradesComboBox);
        this.add(courseIncludedBox);
        this.add(courseConfirm);
        this.add(courseBack);
        */
        courseName.setVisible(true);
        courseUnit.setVisible(true);
        courseGrade.setVisible(true);
        courseIncluded.setVisible(true);
        courseEdit.setVisible(true);
        courseRemove.setVisible(true);

    }
}
