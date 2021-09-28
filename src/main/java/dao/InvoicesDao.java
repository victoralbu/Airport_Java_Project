package dao;

import model.InvoicesEntity;
import model.ReservationsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class InvoicesDao extends GenericDao<InvoicesEntity>{
    private EntityManagerFactory factory;

    public InvoicesDao(EntityManagerFactory factory) {
        super(InvoicesEntity.class);
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
