package lab3.controller;

import lab3.model.Course;
import lab3.model.Person;
import lab3.model.Student;
import lab3.model.Teacher;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SimpleTestClassToBeDeleted {
    public static Course course=new Course();
    public static Teacher teacher=new Teacher();
    public static RegistrationSystem registrationSystem=new RegistrationSystem();
    @BeforeEach
    void setUp() {

        List<Course> cursuri_prof_1=new ArrayList<>();
        List<Student> studenti_curs_1=new ArrayList<>();
        teacher=new Teacher("Cristian","Cretulescu",1,cursuri_prof_1);
        course=new Course(1,"ASC",teacher,3,studenti_curs_1,6);
    }

    @AfterEach
    void tearDown() {

    }
    @Test
    public void testSample() {
        //verifica daca capacitatea ii mai mica decat numarul din lista de studenti,se va return null daca lista de cursuri ii goala si null dca acele disponibile nu exista
        Assert.assertEquals(true, registrationSystem.verificare_capacitate_curs(course));
        Assert.assertNull(registrationSystem.retrievecourseswithfreeplaces());
        Assert.assertNull(registrationSystem.getallCourses());
    }


}
