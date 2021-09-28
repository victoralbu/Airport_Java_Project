package service;

import dao.PlaneDao;
import model.PlaneEntity;

import javax.persistence.Persistence;
import java.util.List;

public class PlaneService<T> {
    private PlaneDao planeDao;
    private Class<T> entityClass;

    public PlaneService() {
        try {
            planeDao = new PlaneDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addPlane(PlaneEntity newPlane) {
        if (planeDao != null) {
            planeDao.create(newPlane);
        } else System.out.println("...Dao e NULL");
    }

    public void updatePlane(PlaneEntity updatedPlane) {
        if (planeDao != null) {
            planeDao.update(updatedPlane);
        } else System.out.println("...Dao e NULL");
    }

    public List<PlaneEntity> getAllPlane() {
        if (planeDao != null) {
            return planeDao.findAll();
        } else return null;
    }

    public void removePlane(PlaneEntity removePlane, int planeId) {
        if (planeDao != null) {
            planeDao.remove(removePlane, removePlane.getIdPlane());
        } else System.out.println("...Dao e NULL");
    }

    public T find(int id) {
        if (planeDao != null) {
            T x = (T) planeDao.find(id);
            return x;
        } else return null;
    }
}
