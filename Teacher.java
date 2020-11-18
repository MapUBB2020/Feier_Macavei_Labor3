package lab3.model;
import java.util.List;
public class Teacher extends Person{
    int id;
    List<Course> courses;
    public Teacher()
    {
    }
    public Teacher(String firstName, String lastName, int id, List<Course> courses) {
        super(firstName, lastName);
        this.id = id;
        this.courses = courses;
    }

    public int getTeacherId() {
        return id;
    }

    public void setTeacherId(int id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return  "{ "+"id_profesor: "+id + " " + firstName +" "+lastName+" }";
    }
}