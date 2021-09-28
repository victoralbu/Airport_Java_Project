package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.PlacesDao;
import model.PlacesEntity;
import model.PlaneEntity;


public class PlacesService<T> {
    private PlacesDao placesDao;
    private Class<T> entityClass;

    public PlacesService() {
        try {
            placesDao = new PlacesDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addPlace(PlacesEntity newPlace) {
        if (placesDao != null) {
            placesDao.create(newPlace);
        } else System.out.println("...Dao e NULL");
    }

    public void updatePlace(PlacesEntity updatedPlace){
        if (placesDao != null) {
            placesDao.update(updatedPlace);
        } else System.out.println("...Dao e NULL");
    }

    public List<PlacesEntity> getAllPlaces() {
        if (placesDao != null) {
            return placesDao.findAll();
        } else return null;
    }

    public void removePlaces(PlacesEntity removePlaces, int placeId) {
        if (placesDao != null) {
            placesDao.remove(removePlaces, removePlaces.getIdPlaces());
        } else System.out.println("...Dao e NULL");
    }

    public T find(int id) {
        if (placesDao != null) {
            T x = (T) placesDao.find(id);
            return x;
        } else return null;
    }

}
