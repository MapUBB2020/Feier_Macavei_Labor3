package lab3;

import lab3.controller.RegistrationSystem;
import lab3.model.Course;
import lab3.model.Person;
import lab3.model.Student;
import lab3.model.Teacher;
import lab3.repository.Courserepository;
import lab3.repository.Studentrepository;

import javax.security.auth.login.CredentialException;
import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class where program starts.
 */
public class StartApp {

    /**
     * Start point of the application
     * @param args command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        //declararea datelor de care avem nevoie in aplicatie cel putin pentru inceput
        List<Student> enrolled=new ArrayList<>();
        List<Student> enrolled_student_prof_1=new ArrayList<>();
        List<Student> enrolled_student_prof_2=new ArrayList<>();
        List<Student> enrolled_student_prof_3=new ArrayList<>();
        List<Course> cursuri_prof_1=new ArrayList<>();
        List<Course> cursuri_prof_2=new ArrayList<>();
        List<Course> cursuri_prof_3=new ArrayList<>();
        List<Course> cursuri_elev_1=new ArrayList<>();
        List<Course> cursuri_elev_2=new ArrayList<>();
        List<Course> cursuri_elev_3=new ArrayList<>();
        //declararea unor profesori
        Teacher teacher1=new Teacher("Diana","Cristea",1,cursuri_prof_1);
        Teacher teacher2=new Teacher("Catalin","Rusu",2,cursuri_prof_2);
        Teacher teacher3=new Teacher("Christian","Sacarea",3,cursuri_prof_3);
        //declararea unor cursuri
        Course course1=new Course(1,"BD",teacher1,2,enrolled_student_prof_1,6);
        Course course2=new Course(2,"MAP",teacher2,64,enrolled_student_prof_2,6);
        Course course3=new Course(3,"PL",teacher3,64,enrolled_student_prof_3,6);
        cursuri_prof_1.add(course1);
        cursuri_prof_2.add(course2);
        cursuri_prof_3.add(course3);

        //declararea unor studenti
        Student student1=new Student("Macavei","Darius",1,30,cursuri_elev_1);
        Student student2=new Student("Feier","Mihail",2,22,cursuri_elev_2);
        Student student3=new Student("George","Otgon",3,27,cursuri_elev_3);
        enrolled_student_prof_1.add(student1);
        enrolled_student_prof_1.add(student2);
        List<Course> array_repo_cursuri=new ArrayList<>();
        List<Student> array_repo_studenti=new ArrayList<>();
        array_repo_studenti.add(student1);
        array_repo_studenti.add(student2);
        array_repo_studenti.add(student3);
        array_repo_cursuri.add(course1);
        array_repo_cursuri.add(course2);
        array_repo_cursuri.add(course3);
        //crearea unor repositoryuri pentru studenti si cursuri
        Studentrepository repo_studenti=new Studentrepository(array_repo_studenti);
        Courserepository repo_courses=new Courserepository(array_repo_cursuri);
        RegistrationSystem registrationSystem=new RegistrationSystem(array_repo_cursuri);
        System.out.println("Apasati tasta 1 pentru a continua sau tasta 0 pentru a iesi din aplicatie:");
        //citim variabila optiune ca sa iteram prin aplicatie
        Scanner scanner= new Scanner(System.in);
        int optiune=scanner.nextInt();
        while(optiune!=0)
        {
            System.out.println("Alege varianta dorita apasand tasta corespunzatoare:");
            System.out.println("1.Adaugati un student la un curs");
            System.out.println("2.Afisarea tuturor cursurilor");
            System.out.println("3.Afisarea tuturor studentilor de la un anumit curs");
            System.out.println("4.Afisarea tuturor cursurilor disponibile");
            System.out.println("5.Afisarea creditelor unui student");
            System.out.println("6.Schimbarea creditului unui curs");
            System.out.println("7.Stergere curs,autorizat doar profesor");
            int optiune1=scanner.nextInt();
            //daca utilizatorul alege optiunea se va putea inscrie la un curs
            if(optiune1==1)
            {
                //aflam cine si unde vrea sa se inscrie
                System.out.println("Dati id-ul  studentului:");
                long id_student=scanner.nextLong();
                System.out.println("Dati id-ul cursului:");
                long id_curs=scanner.nextInt();
                boolean verificare;
                while(true) {
                    //verificam daca este loc la cursul respectiv
                    verificare = registrationSystem.register(repo_courses.findOne(id_curs), repo_studenti.findOne(id_student));
                    if (verificare) {//daca este loc atunci cautam cursul,vedem ce credite are si  crestem creditele elevului care doreste sa se
                        //inscrie la acest curs
                        Course curs_aux = repo_courses.findOne(id_curs);
                        Student student_aux=repo_studenti.findOne(id_student);
                        int valoare_veche;
                        int valore_veche_credite;
                        valore_veche_credite=student_aux.getTotalCredits();
                        valore_veche_credite+= curs_aux.getCredits();
                        if(valore_veche_credite>30)//daca valoarea depaseste 30 atunci are deja destule cresdite ii se va afisa un mesaj
                        {
                            System.out.println("Credite suficiente");
                            break;
                        }
                        //daca valoarea e buna atunci i se va schimba numarul de credite si in lista de curs va fi adaugat si acest elev
                        student_aux.setTotalCredits(valore_veche_credite);
                        valoare_veche = curs_aux.getMaxEnrollment();
                        valoare_veche -= 1;
                        curs_aux.setMaxEnrollment(valoare_veche);
                        List<Student> studenti_curs=new ArrayList<>();
                        studenti_curs=curs_aux.getStudentsEnrolled();
                        studenti_curs.add(repo_studenti.findOne(id_student));
                        repo_courses.update(curs_aux);
                        repo_studenti.update(student_aux);
                        break;
                    }
                    else
                    {       //nu mai sunt locuri si ar trebui sa si aleaga altul
                            System.out.println("Nu mai sunt locuri disponibile la cursul dorit, te rugam sa alegi altul!");
                            System.out.println("Dati id-ul cursului:");
                            id_curs = scanner.nextInt();
                    }
                }

            }
            if(optiune1==2)
            {
                //afisarea tuturor cursurilor
                List<Course> cursuri =new ArrayList<>();
                cursuri=registrationSystem.getallCourses();
                for(Course curs:cursuri)
                    System.out.println(curs.toString());
            }
            if(optiune1==3)
            {
                //afisarea studentilor de la un anumit curs
                //se da id ul cursului,se primeste lista cu elevi si se afiseaza
                System.out.println("Dati id-ul cursului:");
                long id_curs=scanner.nextInt();
                Course aux = repo_courses.findOne(id_curs);
                List<Student> studenti_curs=registrationSystem.studentsenrolledforacourse(aux);
                for(Student student:studenti_curs)
                    System.out.println(student);
            }
            if(optiune1==4)
            {
                //afisarea cursurilor care au spatii libere,adica conditia ca numarul de locuri ale cursului sa fie mai mic decat cel al celor inscrisi
                List<Course> cursuri=new ArrayList<>();
                cursuri=registrationSystem.retrievecourseswithfreeplaces();
                for(Course course:cursuri)
                    System.out.println(course.toString());
            }
            if(optiune1==5)
            {
                //vrem sa vedem pentru un anumit student cate credite are
                System.out.println("Dati id-ul  studentului:");
                long id_student=scanner.nextLong();
                int credite=repo_studenti.findOne(id_student).getTotalCredits();
                System.out.println("Creditele studentului sunt "+credite);

            }
            if(optiune1==6)
            {
                //daca dorim sa schimbam creditele unui curs,dupa ce l schimbam trebe sa verificam care dintre cei inscrisi mai pot ramane
                //adica daca creditele fiecarui elev mai sutn compatibile cu conditia <30
                Course curs_aux;
                int aux;
                System.out.println("Dati id-ul cursului:");
                long id_curs=scanner.nextInt();
                System.out.println("Dati noul credit dorit:");
                int nr_credit_nou= scanner.nextInt();
                List<Student> lista_stud_nou=new ArrayList<>();
                if(repo_courses.findOne(id_curs)!=null) {
                    curs_aux = repo_courses.findOne(id_curs);
                    List<Student> studenti_curs = curs_aux.getStudentsEnrolled();
                    for (Student i : studenti_curs) {
                        //aux ii valoarea de credite pe care le are elevu-cele vechi de la curs+cele noi
                        aux = i.getTotalCredits() - curs_aux.getCredits() + nr_credit_nou;
                        if (aux <= 30) {
                            i.setTotalCredits(aux);
                            repo_studenti.update(i);
                            lista_stud_nou.add(i);
                        }

                    }
                    //se actualizeaza lista de cei inscrisi,cei care si depasesc numaru de cresite li se va scoate cursuu si nu vor fi aduagati la curs
                    curs_aux.setStudentsEnrolled(lista_stud_nou);
                    curs_aux.setCredits(nr_credit_nou);
                    repo_courses.update(curs_aux);
                }
            }
            if(optiune1==7)
            {
                //un profesor sterge cursu si automat elevilor le se vor schimba creditele
                System.out.println("Dati id-ul profesor:");
                int id_profesor= scanner.nextInt();
                System.out.println("Dati id-ul cursuri:");
                long id_curs=scanner.nextInt();
                Course curs_aux= repo_courses.findOne(id_curs);
                List<Student> studenti_curs = curs_aux.getStudentsEnrolled();
                int aux_credite=curs_aux.getCredits();
                for (Student i : studenti_curs) {
                    i.setTotalCredits(i.getTotalCredits()-aux_credite);
                    repo_studenti.update(i);
                    }
                repo_courses.delete(id_curs);
            }


        }
    }
}
