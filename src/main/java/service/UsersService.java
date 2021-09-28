package service;

import com.sun.istack.internal.NotNull;
import dao.UsersDao;
import model.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.Persistence;
import java.util.List;

public class UsersService<T> {

    private UsersDao userDao;
    private Class<T> entityClass;

    public UsersService() {
        try {
            userDao = new UsersDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addUser(UsersEntity newUser) {
        if (userDao != null) {
            userDao.create(newUser);
        } else System.out.println("...Dao e NULL");
    }

    public void updateUser(UsersEntity updatedUser) {
        if (userDao != null) {
            userDao.update(updatedUser);
        } else System.out.println("...Dao e NULL");
    }

    public List<UsersEntity> getAllUsers() {
        if (userDao != null) {
            return userDao.findAll();
        } else return null;
    }

    public void removeUser(UsersEntity removeUser, int userId) {
        if (userDao != null) {
            userDao.remove(removeUser, removeUser.getIdUser());
        } else System.out.println("...Dao e NULL");
    }

    public T find(int id) {
        if (userDao != null) {
            T x = (T) userDao.find(id);
            return x;
        } else return null;
    }

    public List<UsersEntity> login(String username, String password) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Query hbQuery = session.createSQLQuery("SELECT * FROM Users WHERE username = :param1 AND password = :param2");
            hbQuery.setParameter("param1", username);
            hbQuery.setParameter("param2", password);
            List<UsersEntity> l = hbQuery.list();
            if (l.isEmpty()) {
                return null;
            } else {
                return l;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
