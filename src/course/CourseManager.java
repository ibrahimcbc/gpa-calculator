package course;

import app_frame.DefaultFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Scanner;

public class CourseManager {
    DefaultFrame defaultFrame=new DefaultFrame();
    HashMap<String,Course> courses= new HashMap();
    String file= "src\\course\\courses.txt";
    public void addCourse(String name,Course course){
        for(String course_name : courses.keySet()){
            if(course_name.equals(name)){
                System.out.println("Course already taken.");
                break;
            }
        }
        courses.put(name,course);
    }

    public void writeToFile(String courseName,int courseUnit, String courseGrade, boolean courseIncluded){
        String courseToAppend= courseName+";"+courseUnit+";"+courseGrade+";"+courseIncluded+"\n";
        try {
            Files.write(Path.of(file), courseToAppend.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error appending to the file: " + e.getMessage());
        }

    }

    public void getCoursesFromTxt(){
        try {
            Scanner scanner=new Scanner(new File(file));

            while(scanner.hasNextLine()){
                String line= scanner.nextLine(); //TODO try with early declare String line
                String[] parts= line.split(";");
                String courseName= parts[0];
                int courseUnit= Integer.parseInt(parts[1]);
                String courseGrade= parts[2];
                boolean courseIncluded= Boolean.parseBoolean(parts[3]);
                Course course= new Course(courseName,courseUnit,courseGrade,courseIncluded);
                courses.put(courseName,course);
            }
            scanner.close();
        } catch (FileNotFoundException e){
            System.err.println("File not found" + e.getMessage());
        }
    }

    public void listCourses(){
        for(Course course : courses.values()){
            LabelCourse newLabel= new LabelCourse(course);
            newLabel.setVisible(true); //TODO is this necessary?
            LabelCourse.heightOnPage +=50;
        }
    }

    public double gpaCalculator(){
        int totalUnit=0;
        double totalGrade=0.00;
        for(Course course : courses.values()){
            if(course.included){
                totalUnit+=course.getUnits();
                totalGrade+= course.gradeWeight;
            }
        }
        return totalGrade/totalUnit;
    }

    public CourseManager(){
        defaultFrame.buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course new_course=new Course("COMP201",3,"B",true);
                courses.put(new_course.getName(),new_course);
                writeToFile(new_course.getName(),new_course.getUnits(),new_course.getGrade(),new_course.isIncluded());
            }
        });
    }
}
