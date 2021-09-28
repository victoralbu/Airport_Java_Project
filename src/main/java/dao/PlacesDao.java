package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import model.PlacesEntity;


public class PlacesDao extends GenericDao<PlacesEntity> {

    private EntityManagerFactory factory;

    public PlacesDao(EntityManagerFactory factory) {
        super(PlacesEntity.class);
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

