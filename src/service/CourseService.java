package service;

import models.Course;
import repository.CourseRepository;
import repository.CrudRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CrudRepository<Course>, CourseRepository {

    EntityManager em= EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public void saveToDatabase(Course object) {

    }

    @Override
    public void deleteFromDatabase(Course object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(Course object, int id) {

    }
}
