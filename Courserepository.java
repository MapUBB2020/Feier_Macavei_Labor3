package lab3.repository;

import lab3.model.Course;

import java.util.List;

public class Courserepository implements ICrudRepository<Course>{

    List<Course>  courseList;

    public Courserepository(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }


    @Override
    public Course findOne(Long id) {
        for (Course i : courseList)
        {
            if (i.getId() == id)
            {
                return i;
            }
        }
        return null;
    }

    @Override
    public Iterable<Course> findAll() {
        return courseList;
    }

    @Override
    public Course save(Course entity) {
        for (Course i : courseList)
        {
            if (i.getId() == entity.getId())
            {
                return entity;
            }
        }
        courseList.add(entity);
        return null;
    }

    @Override
    public Course delete(Long id) {
        Course course;
        for (Course i : courseList)
        {
            if (i.getId() == id)
            {
                course = i;
                courseList.remove(i);
                return course;
            }
        }
        return null;
    }

    @Override
    public Course update(Course entity) {
        for (Course i : courseList)
        {
            if (i.getId() == entity.getId())
            {
                int aux = courseList.indexOf(i);
                courseList.set(aux, entity);
                return null;
            }
        }
        return entity;
    }
}
