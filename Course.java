package lab3.model;
import java.util.List;
public class Course {
    long Id;
    String courseName;
    Person teacher;
    int maxEnrollment;
    List <Student> studentsEnrolled;
    int credits;
    public Course()
    {

    }
    //constructoru
    public Course(int id, String courseName, Person teacher, int maxEnrollment, List<Student> studentsEnrolled, int credits) {
        Id = id;
        this.courseName = courseName;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
    }
    //gettere si settere pentru frumoasaele atribute
    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    //cream un string ca s aputem afisa mai frumos
    public String toString()
    {
        return "Curs: {"+"\n"+"id: "+ Id +"\n" + "CourseName: " + courseName+"\n"+ "Teacher: " +  teacher + "\n"+ "MaxEnrold: " + maxEnrollment +"\n"+ "StudentsEnrolled: "+ studentsEnrolled+"\n" + "Credite: "+credits+"\n}";
    }
}