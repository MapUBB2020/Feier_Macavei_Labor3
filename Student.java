package lab3.model;
import java.util.List;
public class Student extends Person{

    long StudentID;
    int totalCredits;
    List <Course> enrolledCourses;
    //constructoru
    public Student(String firstName, String lastName, long studentID, int totalCredits, List<Course> enrolledCourses) {
        super(firstName, lastName);
        StudentID = studentID;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
    }
    //gettere si settere
    public long getStudentID() {
        return StudentID;
    }

    public void setStudentID(long studentID) {
        StudentID = studentID;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses)  {
        this.enrolledCourses = enrolledCourses;
    }
    //pentru a afisa frumos studentii
    @Override
    public String toString() {
        return  "{ "+"id_student: "+StudentID +" "+ firstName+" "+lastName+" }";
    }
}