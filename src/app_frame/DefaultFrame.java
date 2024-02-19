package app_frame;

import course.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultFrame extends JFrame {

    public JPanel coursesPanel=new JPanel(new FlowLayout()); //we can scroll the courses and it will solve placement problem.
    public static JPanel existingPanel = new JPanel();
    JScrollPane scrollPane;
    public JButton buttonAdd= new JButton();
    public JPanel panelAdd=new JPanel();
    public JLabel labelGPA=new JLabel();
    JLabel addInfoLabel=new JLabel();
    JTextField courseNameField= new JTextField();
    JTextField courseUnitField= new JTextField();
    String[] gradeOptions = {"A", "A-","B+","B","B-","C+","C","C-","D+","D","F"};
    JComboBox<String> gradesComboBox=new JComboBox(gradeOptions);
    JCheckBox courseIncludedBox=new JCheckBox();
    JButton courseConfirm=new JButton();
    JButton courseBack=new JButton();
    public static JLabel performLabel=new JLabel();
    public DefaultFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600,800);
        this.setTitle("GPA CALCULATOR");
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.darkGray);

        performLabel.setBounds(100,10,300,30);
        performLabel.setForeground(Color.RED);
        performLabel.setVisible(true);

        JLabel infoLabel = new JLabel();
        infoLabel.setBounds(50,30,400,25);
        infoLabel.setForeground(Color.white);
        infoLabel.setText("Course Name                 Unit             Grade     Included");
        infoLabel.setVisible(true);

        addInfoLabel.setBounds(50,650,400,25);
        addInfoLabel.setForeground(Color.white);
        addInfoLabel.setText("Course Name                 Unit             Grade     Included");
        addInfoLabel.setVisible(true);

        coursesPanel.setVisible(true);
        coursesPanel.setBounds(50,50,500 ,500);
        coursesPanel.setBackground(Color.black);
        coursesPanel.setLayout(new BoxLayout(coursesPanel, BoxLayout.Y_AXIS));

        existingPanel.setBackground(Color.black);
        existingPanel.setLayout(new BoxLayout(existingPanel, BoxLayout.Y_AXIS));

        scrollPane= new JScrollPane(existingPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //try needed
        scrollPane.setPreferredSize(new Dimension(500, 500));
        scrollPane.getVerticalScrollBar().setBackground(Color.DARK_GRAY);
        scrollPane.getVerticalScrollBar().setForeground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        buttonAdd.setVisible(true);
        buttonAdd.setLocation(200,700);
        buttonAdd.setSize(120,50);
        buttonAdd.setText("ADD COURSE");
        buttonAdd.setBackground(Color.lightGray);

        panelAdd.setVisible(false);
        panelAdd.setLocation(50,700);
        panelAdd.setSize(500,35);
        panelAdd.setBackground(Color.lightGray);

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
        courseBack.setSize(75,25);

        courseConfirm.setLocation(405,5);
        courseConfirm.setText("ADD");
        courseConfirm.setSize(75,25);

        labelGPA.setVisible(true);
        labelGPA.setLocation(100,550);
        labelGPA.setSize(400,50);
        labelGPA.setForeground(Color.lightGray);

        panelAdd.setLayout(null);

        this.add(coursesPanel);
        this.add(panelAdd);
        this.add(buttonAdd);
        this.add(labelGPA);
        this.add(performLabel);
        this.add(infoLabel);
        this.add(addInfoLabel);

        coursesPanel.add(scrollPane,BorderLayout.CENTER);
        panelAdd.add(courseNameField);
        panelAdd.add(courseUnitField);
        panelAdd.add(courseIncludedBox);
        panelAdd.add(gradesComboBox);
        panelAdd.add(courseBack);
        panelAdd.add(courseConfirm);

        courseConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int errorCount =0;
                if (courseNameField.getText().isEmpty()) {
                    performLabel.setText("Course should have a name!");
                    performLabel.setForeground(Color.red);
                    errorCount++;
                }
                if (CourseManager.nameChecker(courseNameField.getText())) {
                    performLabel.setText("Course already in the list!");
                    performLabel.setForeground(Color.red);
                    errorCount++;
                }
                if (!courseUnitField.getText().matches("\\d+$")) {
                    performLabel.setText("Couse unit should be a number.");
                    performLabel.setForeground(Color.red);
                    errorCount++;
                }
                if (errorCount == 0) {
                    Course new_course = new Course(courseNameField.getText(), Integer.parseInt(courseUnitField.getText()), (String) gradesComboBox.getSelectedItem(), courseIncludedBox.isSelected());
                    CourseManager.courses.put(new_course.getName(), new_course);
                    CourseManager.writeToFile(new_course.getName(), new_course.getUnits(), new_course.getGrade(), new_course.isIncluded());
                    LabelCourse labelCourse = new LabelCourse(new_course);
                    labelCourse.setMaximumSize(new Dimension(500, 35));
                    JPanel blackPanel = new JPanel();
                    blackPanel.setBackground(Color.black);
                    blackPanel.setPreferredSize(new Dimension(500, 15));
                    blackPanel.setMaximumSize(new Dimension(500, 15));
                    existingPanel.add(labelCourse);
                    existingPanel.add(blackPanel);
                    panelAdd.setVisible(false);
                    buttonAdd.setVisible(true);
                    CourseManager.gpaCalculator();
                    performLabel.setText("COURSE ADDED SUCCESSFULLY");
                    performLabel.setForeground(Color.green);
                    DefaultFrame.this.repaint();
                }
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

}
