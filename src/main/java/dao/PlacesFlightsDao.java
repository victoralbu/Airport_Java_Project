package dao;

import model.PlacesFlightsEntity;
import model.ReservationsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PlacesFlightsDao extends GenericDao<PlacesFlightsEntity>{
    private EntityManagerFactory factory;

    public PlacesFlightsDao(EntityManagerFactory factory) {
        super(PlacesFlightsEntity.class);
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
