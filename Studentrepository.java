package lab3.repository;

import lab3.model.Course;
import lab3.model.Student;

import java.util.List;

public class Studentrepository implements ICrudRepository<Student> {

    List<Student> StundentList;
    public Studentrepository(List<Student> students){
        this.StundentList = students;
    }

    public List<Student> getStudentList() {
        return StundentList;
    }

    public void setStudentList(List<Student> StundentList) {
        this.StundentList = StundentList;
    }


    @Override
    public Student findOne(Long id) {
        for(Student i : StundentList)
        {
            if (i.getStudentID() == id)
                return i;
        }
        return null;
    }

    @Override
    public Iterable<Student> findAll() {
        return StundentList;
    }

    @Override
    public Student save(Student entity) {
        for (Student i : StundentList)
        {
            if (i.getStudentID() == entity.getStudentID())
                return entity;
        }
        StundentList.add(entity);
        return null;
    }

    @Override
    public Student delete(Long id) {
        Student student;
        for (Student i : StundentList)
            if (i.getStudentID() == id) {
                student = i;
                StundentList.remove(i);
                return student;
            }
        return null;
    }
    @Override
    public Student update(Student entity) {
        for (Student i : StundentList)
        {
            if (i.getStudentID() == entity.getStudentID()) {
                int aux = StundentList.indexOf(i);
                StundentList.set(aux, entity);
                return null;
            }
        }
        return entity;
    }
}
