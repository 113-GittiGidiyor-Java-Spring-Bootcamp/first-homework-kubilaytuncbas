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
    public List<Course> findAll()
    {
        return em.createQuery("from Course",Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public void saveToDatabase(Course course) {
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(Course course) {

    }

    @Override
    public void deleteFromDatabase(int id) {

        try {
            em.getTransaction().begin();

            Course findCourse = em.find(Course.class, id);
            em.remove(id);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void updateOnDatabase(Course course, int id) {

        try {
            em.getTransaction().begin();

            Course findCourse = em.find(Course.class, id);
            findCourse.setCourseName(course.getCourseName());
            findCourse.setCourseCode(course.getCourseCode());
            findCourse.setCreditScore(course.getCreditScore());
            em.merge(findCourse);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }
}
