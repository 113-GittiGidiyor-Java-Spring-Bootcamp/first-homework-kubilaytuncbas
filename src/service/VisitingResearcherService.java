package service;

import models.VisitingResearcher;
import repository.CrudRepository;
import repository.VisitingResearcherRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class VisitingResearcherService implements CrudRepository<VisitingResearcher>, VisitingResearcherRepository {
    EntityManager em= EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<VisitingResearcher> findAll() {
        return null;
    }

    @Override
    public VisitingResearcher findById(int id) {
        return null;
    }

    @Override
    public void saveToDatabase(VisitingResearcher object) {

    }

    @Override
    public void deleteFromDatabase(VisitingResearcher object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(VisitingResearcher object, int id) {

    }
}
