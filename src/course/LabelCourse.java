package course;

import app_frame.DefaultFrame;

import javax.swing.*;
import java.awt.*;

public class LabelCourse extends JPanel {

    /* basic mode properties */
    JLabel courseName = new JLabel();
    JLabel courseUnit = new JLabel();
    JLabel courseGrade= new JLabel();
    JPanel courseIncluded= new JPanel();
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
        this.setSize(500,35); //TODO change height
        this.setLocation(50,heightOnPage);
        this.setBackground(Color.ORANGE);

        courseName.setLocation(20,5);
        courseName.setText(course.getName());
        courseName.setSize(85,25);

        courseUnit.setLocation(135,5);
        courseUnit.setText(course.getUnits()+""); //tricky way to convert int to string
        courseUnit.setSize(25,25);

        courseGrade.setLocation(210,5);
        courseGrade.setText(course.getGrade());
        courseGrade.setSize(25,25);

        courseIncluded.setLocation(255,5);
        if(course.isIncluded()){
            courseIncluded.setBackground(Color.GREEN);
        }else{
            courseIncluded.setBackground(Color.RED);
        }
        courseIncluded.setSize(25,25);

        courseEdit.setLocation(320,5);
        courseEdit.setText("EDIT");
        courseEdit.setSize(65,25);

        courseRemove.setLocation(420,5);
        courseRemove.setText("DEL");
        courseRemove.setSize(60,25);

        //gradesComboBox.setLocation(1,1);

        this.add(courseName);
        this.add(courseUnit);
        this.add(courseGrade);
        this.add(courseIncluded);
        this.add(courseEdit);
        this.add(courseRemove);

        this.add(courseNameField); //setVisible(false) could be necessarity.
        this.add(courseUnitField);
        this.add(gradesComboBox);
        this.add(courseIncludedBox);
        this.add(courseConfirm);
        this.add(courseBack);

        courseName.setVisible(true);
        courseUnit.setVisible(true);
        courseGrade.setVisible(true);
        courseIncluded.setVisible(true);
        courseEdit.setVisible(true);
        courseRemove.setVisible(true);

    }
}
