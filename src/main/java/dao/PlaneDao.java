package dao;

import model.PlaneEntity;
import model.ReservationsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PlaneDao extends GenericDao<PlaneEntity>{
    private EntityManagerFactory factory;

    public PlaneDao(EntityManagerFactory factory) {
        super(PlaneEntity.class);
        this.factory = factory;
    }

    @Override
    public EntityManager getEntityManager() {
        try {
            return factory.createEntityManager();
        } catch (Exception ex) {
            System.out.println("The entity manager cannot be created!");
            return null;
        }
    }
}
