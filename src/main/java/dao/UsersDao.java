package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.UsersEntity;

public class UsersDao extends GenericDao<UsersEntity> {

    private EntityManagerFactory factory;

    public UsersDao(EntityManagerFactory factory) {
        super(UsersEntity.class);
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

    // for login
    public List<UsersEntity> find(String name) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UsersEntity> q = cb.createQuery(UsersEntity.class);

        Root<UsersEntity> c = q.from(UsersEntity.class);
        ParameterExpression<String> paramName = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("username"), paramName));
        TypedQuery<UsersEntity> query = em.createQuery(q);
        query.setParameter(paramName, name);

        List<UsersEntity> results = query.getResultList();
        return results;
    }

}

