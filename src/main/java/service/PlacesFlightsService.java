package service;

import dao.PlacesFlightsDao;
import model.InvoicesEntity;
import model.PlacesFlightsEntity;

import javax.persistence.Persistence;
import java.util.List;

public class PlacesFlightsService<T> {
    private PlacesFlightsDao placesFlightsDao;
    private Class<T> entityClass;

    public PlacesFlightsService() {
        try {
            placesFlightsDao = new PlacesFlightsDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addPlacesFlights(PlacesFlightsEntity newPlaceFlight) {
        if (placesFlightsDao != null) {
            placesFlightsDao.create(newPlaceFlight);
        } else System.out.println("...Dao e NULL");
    }

    public void updatePlacesFlights(PlacesFlightsEntity updatedPlaceFlight) {
        if (placesFlightsDao != null) {
            placesFlightsDao.update(updatedPlaceFlight);
        } else System.out.println("...Dao e NULL");
    }

    public List<PlacesFlightsEntity> getAllPlacesFlights() {
        if (placesFlightsDao != null) {
            return placesFlightsDao.findAll();
        } else return null;
    }

    public void removePlacesFlights(PlacesFlightsEntity removePlaceFlight, int PlaceFlightId) {
        if (placesFlightsDao != null) {
            placesFlightsDao.remove(removePlaceFlight, removePlaceFlight.getIdplacesFlights());
        } else System.out.println("...Dao e NULL");
    }

    public T find(int id) {
        if (placesFlightsDao != null) {
            T x = (T) placesFlightsDao.find(id);
            return x;
        } else return null;
    }
}
