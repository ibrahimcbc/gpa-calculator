package course;

import java.util.HashMap;

public class Course {
    String name; //title of course
    String grade; //grade of course (such as A:4.00 , A-:3.70)
    double gradeWeight;
    int units; //weight of course, such as 1,3
    boolean included=true; //is course included in weighted total, for simulate course scenarios
    static HashMap<String,Double> gradeLetterToDouble;
    static {
        gradeLetterToDouble= new HashMap<>();
        gradeLetterToDouble.put("A",4.00);
        gradeLetterToDouble.put("A-",3.70);
        gradeLetterToDouble.put("B+",3.30);
        gradeLetterToDouble.put("B",3.00);
        gradeLetterToDouble.put("B-",2.70);
        gradeLetterToDouble.put("C+",2.30);
        gradeLetterToDouble.put("C",2.00);
        gradeLetterToDouble.put("C-",1.70);
        gradeLetterToDouble.put("D+",1.30);
        gradeLetterToDouble.put("D",1.00);
        gradeLetterToDouble.put("F",0.00);
    }
    public Course(String name, int units, String grade, boolean included){
         this.name= name;
         this.units=units;
         this.grade=grade;
         this.included=included;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }
}
