package course;

import java.util.HashMap;

public class CourseManager {
    HashMap<String,Course> courses= new HashMap();
    void add_course(String name,Course course){
        for(String course_name : courses.keySet()){
            if(course_name.equals(name)){
                System.out.println("Course already taken.");
            }
        }
        Course new_course= new Course(name,3,4.00,true); //values will be taken from other functions TODO
        courses.put(name,new_course);

    }

}
