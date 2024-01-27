package course;

public class Course {
    String name;
    double grade=0;
    int units;
    boolean included=true;
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
