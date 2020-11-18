package lab3.controller;

import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.repository.Courserepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RegistrationSystem {
    List<Course> cursuri=new ArrayList<>();
    public RegistrationSystem(List<Course> courseList) {
        this.cursuri = courseList;
    }
    public RegistrationSystem(){}
    //verificare daca numarul maxim de studenti si numarul din lista de studenti sunt eglae sau nu
    public boolean register(Course course, Student student)
    {
        if(course.getMaxEnrollment()==course.getStudentsEnrolled().size())
            return false;
        return true;
    }

    public boolean verificare_capacitate_curs(Course course)
    {
        if(course.getMaxEnrollment()==course.getStudentsEnrolled().size())
            return false;
        return true;
    }
    //returneaza toate cursurile
    public List<Course> getallCourses()
    {
        if(cursuri.size()==0)
            return null;
        return cursuri;
    }
    //returneaza toti studentii ede la un curs
    public List<Student> studentsenrolledforacourse(Course course)
    {

        return course.getStudentsEnrolled();
    }
    //returneaza cursurile care mai au locuri libere
    public List<Course> retrievecourseswithfreeplaces()
    {
        List<Course> cursuri_disponibile=new ArrayList<>();
        for(Course course:cursuri)
            if(verificare_capacitate_curs(course))
                cursuri_disponibile.add(course);
        if(cursuri_disponibile.size()==0)
            return null;
        return cursuri_disponibile;

    }
}
