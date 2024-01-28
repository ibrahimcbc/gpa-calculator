package course;

import java.util.HashMap;

public class CourseManager {
    HashMap courses= new HashMap();
    void add_course(String name,Course course){

        courses.put(name,course);

    }

}
