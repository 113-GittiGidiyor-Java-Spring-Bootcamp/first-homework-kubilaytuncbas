package client;

import controller.CourseController;
import models.*;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        saveTestData();
        CourseController courseController=new CourseController();
        courseController.deleteCourse(1);

    }
    private static  void saveTestData() {
        Course course1 = new Course("JavaBackend", "101", 10);

        Student student1 = new Student("Kubilay", "Kagıthane", LocalDate.of(1998, Month.FEBRUARY, 19), "Erkek");

        VisitingResearcher visitingResearcher1 = new VisitingResearcher("Koray", "istanbul", "549421876", 500);

        PermanentInstructor permanentInstructor1 = new PermanentInstructor("Koray", "istanbul", "549421876", 10000);

        student1.getCourses().add(course1);
        course1.getStudents().add(student1);
        permanentInstructor1.getCourseList().add(course1);
        visitingResearcher1.getCourseList().add(course1);
        course1.setPermanentInstructor(permanentInstructor1);

        EntityManager em= EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();
            em.persist(course1);
            em.persist(student1);
            em.persist(visitingResearcher1);
            em.persist(permanentInstructor1);


            em.getTransaction().commit();
            System.out.println("All data persisted");
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }


    }
}
