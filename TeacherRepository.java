package lab3.repository;

import lab3.model.Student;
import lab3.model.Teacher;

import java.util.List;

public class TeacherRepository implements ICrudRepository<Teacher> {

    List<Teacher> TeacherList;
    public TeacherRepository(List<Teacher> teacher){
        this.TeacherList = teacher;
    }

    public List<Teacher> getTeacherList() {
        return TeacherList;
    }

    public void setTeacherList(List<Teacher> TeacherList) {
        this.TeacherList = TeacherList;
    }


    @Override
    public Teacher findOne(Long id) {
        for (Teacher i : TeacherList)
        {
            if (i.getTeacherId() == id)
                return i;
        }
        return null;
    }

    @Override
    public Iterable<Teacher> findAll() {
        return TeacherList;
    }

    @Override
    public Teacher save(Teacher entity) {
        for (Teacher i : TeacherList)
        {
            if (i.getTeacherId() == entity.getTeacherId())
                return entity;
        }
        TeacherList.add(entity);
        return null;
    }

    @Override
    public Teacher delete(Long id) {
        Teacher teacher;
        for (Teacher i : TeacherList)
        {
            if (i.getTeacherId() == id)
            {
                teacher = i;
                TeacherList.remove(i);
                return teacher;
            }
        }
        return null;
    }

    @Override
    public Teacher update(Teacher entity) {
        for (Teacher i : TeacherList)
        {
            if (i.getTeacherId() == entity.getTeacherId()) {
                int aux = TeacherList.indexOf(i);
                TeacherList.set(aux, entity);
                return null;
            }
        }
        return entity;
    }
}