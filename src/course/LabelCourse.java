package course;

import app_frame.DefaultFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

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
        this.setLayout(null); //inactivated
        //this.setSize(500,35); //TODO change height
        this.setPreferredSize(new Dimension(500, 35));
        this.setLocation(50,heightOnPage); //heightOnPage=50 and increasing in every new LabelCourse by 50
        this.setBackground(Color.ORANGE);
        this.setVisible(true);

        courseName.setLocation(20,5);
        courseName.setText(course.getName());
        courseName.setSize(85,25);

        courseNameField.setLocation(20,5);
        courseNameField.setText(course.getName());
        courseNameField.setSize(85,25);

        courseUnit.setLocation(135,5);
        courseUnit.setText(String.valueOf(course.getUnits()));
        courseUnit.setSize(25,25);

        courseUnitField.setLocation(135,5);
        courseUnitField.setText(String.valueOf(course.getUnits()));
        courseUnitField.setSize(25,25);

        courseGrade.setLocation(210,5);
        courseGrade.setText(course.getGrade());
        courseGrade.setSize(25,25);

        gradesComboBox.setLocation(200,5);
        gradesComboBox.setSelectedItem(course.getGrade());
        gradesComboBox.setSize(42,25);

        courseIncluded.setLocation(255,5);
        if(course.isIncluded()){
            courseIncluded.setBackground(Color.GREEN);
        }else{
            courseIncluded.setBackground(Color.RED);
        }
        courseIncluded.setSize(25,25);

        courseIncludedBox.setLocation(255,5);
        courseIncludedBox.setSelected(course.isIncluded());
        courseIncludedBox.setSize(25,25);

        courseEdit.setLocation(320,5);
        courseEdit.setText("EDIT");
        courseEdit.setSize(65,25);

        courseBack.setLocation(320,5);
        courseBack.setText("BACK");
        courseBack.setSize(75,25);

        courseRemove.setLocation(420,5);
        courseRemove.setText("DEL");
        courseRemove.setSize(60,25);

        courseConfirm.setLocation(420,5);
        courseConfirm.setText("APPLY");
        courseConfirm.setSize(75,25);

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

        showBasicMode();

        courseEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEditMode();
            }
        });

        courseRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= course.getName();
                CourseManager.courses.remove(name);
                try {
                    CourseManager.deleteCourseFromTxt(name);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                DefaultFrame.existingPanel.removeAll();
                CourseManager.listCourses();
                DefaultFrame.existingPanel.revalidate();
                DefaultFrame.existingPanel.repaint();
            }
        });

        courseBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBasicMode();
            }
        });

        courseConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= course.getName();
                if(!courseNameField.getText().isEmpty()){
                    course.setName(courseNameField.getText());
                    LabelCourse.this.courseName.setText(courseNameField.getText());
                }else{
                    //TODO give empty error
                }
                if(!courseUnitField.getText().isEmpty()){
                    if(isInteger(courseUnit.getText())){
                        course.setUnits(Integer.parseInt(courseUnitField.getText()));
                        LabelCourse.this.courseUnit.setText(courseUnitField.getText());
                }else{
                        //TODO give type error
                    }
                }else{
                    //TODO give empty error
                }
                course.setGrade((String) gradesComboBox.getSelectedItem());
                LabelCourse.this.courseGrade.setText((String) gradesComboBox.getSelectedItem());
                course.setIncluded(courseIncludedBox.isSelected());
                if(course.isIncluded()){
                    courseIncluded.setBackground(Color.GREEN);
                }else{
                    courseIncluded.setBackground(Color.RED);
                }
                //LabelCourse.this.repaint();
                try {
                    CourseManager.changeCourseToFile(name,course.getName(),course.getUnits(),course.getGrade(),course.isIncluded());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                showBasicMode();
                CourseManager.gpaCalculator();
            }
        });
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showEditMode(){
        courseName.setVisible(false);
        courseUnit.setVisible(false);
        courseGrade.setVisible(false);
        courseIncluded.setVisible(false);
        courseEdit.setVisible(false);
        courseRemove.setVisible(false);

        courseNameField.setVisible(true);
        courseUnitField.setVisible(true);
        gradesComboBox.setVisible(true);
        courseIncludedBox.setVisible(true);
        courseBack.setVisible(true);
        courseConfirm.setVisible(true);
    }

    private void showBasicMode(){
        courseName.setVisible(true);
        courseUnit.setVisible(true);
        courseGrade.setVisible(true);
        courseIncluded.setVisible(true);
        courseEdit.setVisible(true);
        courseRemove.setVisible(true);

        courseNameField.setVisible(false);
        courseUnitField.setVisible(false);
        gradesComboBox.setVisible(false);
        courseIncludedBox.setVisible(false);
        courseBack.setVisible(false);
        courseConfirm.setVisible(false);
    }
}
