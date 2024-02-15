package course;

import app_frame.DefaultFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CourseManager {
    static DefaultFrame defaultFrame=new DefaultFrame();
    public static HashMap<String,Course> courses= new HashMap();
    public static String file= "src\\course\\courses.txt";
    public void addCourse(String name,Course course){
        for(String course_name : courses.keySet()){
            if(course_name.equals(name)){
                System.out.println("Course already taken.");
                break;
            }
        }
        courses.put(name,course);
    }

    public static void writeToFile(String courseName, int courseUnit, String courseGrade, boolean courseIncluded){
        String courseToAppend= courseName+";"+courseUnit+";"+courseGrade+";"+courseIncluded+"\n";
        try {
            Files.write(Path.of(file), courseToAppend.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error appending to the file: " + e.getMessage());
        }

    }

    public static void changeCourseToFile(String courseName, String newCourseName,int courseUnit, String courseGrade, boolean courseIncluded) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[0].equals(courseName)) {
                    parts[0] = newCourseName;
                    parts[1]= String.valueOf(courseUnit);
                    parts[2]= courseGrade;
                    parts[3]= String.valueOf(courseIncluded);
                }
                lines.add(String.join(";", parts));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCoursesFromTxt(){
        try {
            Scanner scanner=new Scanner(new File(file));
            while(scanner.hasNextLine()){
                String line= scanner.nextLine(); //TODO try with early declare String line
                String[] parts= line.split(";");
                if(parts.length==4) {
                    String courseName = parts[0].trim();
                    int courseUnit = Integer.parseInt(parts[1].trim());
                    String courseGrade = parts[2].trim();
                    boolean courseIncluded = Boolean.parseBoolean(parts[3].trim());
                    Course course = new Course(courseName, courseUnit, courseGrade, courseIncluded);
                    courses.put(courseName, course);
                }else{
                    System.out.println("Wrong saving format error.");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e){
            System.err.println("File not found" + e.getMessage());
        }
        System.out.println("getCoursesFromTxt function executed successfully, courses in txt become to objects in hashmap");
    }

    public void listCourses(){
        for(Course course : courses.values()){
            LabelCourse newLabel= new LabelCourse(course);
            newLabel.setVisible(true); //TODO is this necessary?
            LabelCourse.heightOnPage +=50;
            defaultFrame.addCoursePanel(newLabel);
        }
        System.out.println("listCourses function done successfully, courses labeled to frame.");
    }

    private static String formatDouble(double value){
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        return decimalFormat.format(value);
    }

    public static void gpaCalculator(){
        int totalUnit=0;
        double totalGrade=0.00;
        if(courses.isEmpty()){
            defaultFrame.labelGPA.setText("TOTAL GPA: "+ 0.00);
        }else{
            for(Course course : courses.values()){
                if(course.included){
                    System.out.println("course active: unit: "+course.getUnits()+" weight: "+ course.getLetterPoint());
                    totalUnit+=course.getUnits();
                    totalGrade+= course.getLetterPoint()*course.getUnits();
                }
            }
        }
        defaultFrame.labelGPA.setText("TOTAL GPA: "+formatDouble(totalGrade/totalUnit));
    }

    void printCourses(){
        for(Course course:courses.values()){
            System.out.println(course.getName()+" "+course.getUnits()+" "+course.getGrade()+" "+course.isIncluded()+"\n");
        }
    }

    public CourseManager(){

        getCoursesFromTxt(); //hashmape attı dataları
        listCourses();
        printCourses();
        gpaCalculator(); //TODO isin bitince sil

    }
}
