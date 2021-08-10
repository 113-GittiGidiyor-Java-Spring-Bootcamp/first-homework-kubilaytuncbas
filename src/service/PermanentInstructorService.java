package service;

import models.PermanentInstructor;
import repository.CrudRepository;
import repository.PermanentInstructorRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class PermanentInstructorService implements CrudRepository<PermanentInstructor>, PermanentInstructorRepository {

    EntityManager em= EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<PermanentInstructor> findAll() {
        return null;
    }

    @Override
    public PermanentInstructor findById(int id) {
        return null;
    }

    @Override
    public void saveToDatabase(PermanentInstructor object) {

    }

    @Override
    public void deleteFromDatabase(PermanentInstructor object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(PermanentInstructor object, int id) {

    }
}
