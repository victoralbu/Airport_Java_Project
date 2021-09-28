package dao;

import model.ReservationsEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ReservationsDao extends GenericDao<ReservationsEntity>{
    private EntityManagerFactory factory;

    public ReservationsDao(EntityManagerFactory factory) {
        super(ReservationsEntity.class);
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
