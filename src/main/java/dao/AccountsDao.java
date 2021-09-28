package dao;

import model.AccountsEntity;
import model.PlacesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AccountsDao extends GenericDao<AccountsEntity>{
    private EntityManagerFactory factory;

    public AccountsDao(EntityManagerFactory factory) {
        super(AccountsEntity.class);
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
