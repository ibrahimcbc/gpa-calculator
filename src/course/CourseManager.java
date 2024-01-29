package course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CourseManager {
    HashMap<String,Course> courses= new HashMap();
    String file= "courses.txt";
    public void addCourse(String name,Course course){
        for(String course_name : courses.keySet()){
            if(course_name.equals(name)){
                System.out.println("Course already taken.");
                break;
            }
        }
        courses.put(name,course);
    }

    public void getCoursesFromTxt(){
        try {
            Scanner scanner=new Scanner(new File(file));

            while(scanner.hasNextLine()){
                String line= scanner.nextLine(); //TODO try with early declare String line
                System.out.println(line); //TODO temporary code.
            }

            scanner.close();
        } catch (FileNotFoundException e){
            System.err.println("file not found");
        }
    }

    public void listCourses(){
        for(Course course : courses.values()){
            LabelCourse newLabel= new LabelCourse(course);
            newLabel.setVisible(true);
            LabelCourse.heightOnPage +=50;
        }
    }
}
