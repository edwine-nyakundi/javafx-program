package student;

public class Student {
    private String name;
    private String grade;
    private double GPA;
    private int volunteerHours;

    public Student(String name, String grade, double GPA, int volunteerHours) {
        this.name = name;
        this.grade = grade;
        this.GPA = GPA;
        this.volunteerHours = volunteerHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getVolunteerHours() {
        return volunteerHours;
    }

    public void setVolunteerHours(int volunteerHours) {
        this.volunteerHours = volunteerHours;
    }
}
