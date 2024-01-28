package course;

public class Course {
    String name; //title of course
    double grade=0; //grade of course (such as A:4.00 , A-:3.70)
    int units; //weight of course, such as 1,3
    boolean included=true; //is course included in weighted total, for simulate course scenarios
    public Course(String name, int units, double grade, boolean included){
         name= this.name;
         units= this.units;
         grade= this.grade;
        included= this.included;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
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
