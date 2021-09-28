package dao;

import model.FlightsEntity;
import model.ReservationsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FlightsDao extends GenericDao<FlightsEntity>{
    private EntityManagerFactory factory;

    public FlightsDao(EntityManagerFactory factory) {
        super(FlightsEntity.class);
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
