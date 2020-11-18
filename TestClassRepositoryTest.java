package lab3.repository;

import lab3.model.Course;
import lab3.model.Student;
import lab3.model.Teacher;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestClassRepositoryTest {
    public static Course course;
    public static Teacher teacher;
    public static Student student;
    public static Courserepository courserepository;
    public static TeacherRepository teacherRepository;
    public static Studentrepository studentrepository;

    @BeforeEach
    void setUp() {

        //declarare pentru teste
        List<Course> cursuri_prof_1=new ArrayList<>();
        List<Student> studenti_curs_1=new ArrayList<>();
        List<Course> cursuri_elev_1=new ArrayList<>();
        teacher=new Teacher("Cristian","Cretulescu",1,cursuri_prof_1);
        course=new Course(1,"ASC",teacher,3,studenti_curs_1,6);
        student=new Student("gigel","frone",100,24,cursuri_elev_1);
        List<Course> cursuri_repo=new ArrayList<>();
        List<Student> studenti_repo=new ArrayList<>();
        List<Teacher> teacheri_repo=new ArrayList<>();
        cursuri_repo.add(course);
        studenti_repo.add(student);
        teacheri_repo.add(teacher);
        courserepository=new Courserepository(cursuri_repo);
        teacherRepository=new TeacherRepository(teacheri_repo);
        studentrepository=new Studentrepository(studenti_repo);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void TestRepo()
    {
        //verifica daca exista course,daca dupa ce i sters returneaza entitate,daca il salveaza returneaza entitatea ca fiind existenta
        Assert.assertTrue(courserepository.findOne((long) 1)==course);
        Assert.assertTrue(teacherRepository.delete((long) 1)==teacher);
        Assert.assertTrue(studentrepository.save(student)==student);
    }
}