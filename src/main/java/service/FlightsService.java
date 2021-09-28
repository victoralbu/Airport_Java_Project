package service;

import dao.FlightsDao;
import model.FlightsEntity;

import javax.persistence.Persistence;
import java.util.List;

public class FlightsService<T> {
    private FlightsDao flightsDao;
    private Class<T> entityClass;

    public FlightsService() {
        try {
            flightsDao = new FlightsDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addFlight(FlightsEntity newFlight) {
        if (flightsDao != null) {
            flightsDao.create(newFlight);
        } else System.out.println("...Dao e NULL");
    }

    public void updateFlight(FlightsEntity updatedFlight) {
        if (flightsDao != null) {
            flightsDao.update(updatedFlight);
        } else System.out.println("...Dao e NULL");
    }

    public List<FlightsEntity> getAllFlights() {
        if (flightsDao != null) {
            return flightsDao.findAll();
        } else return null;
    }

    public void removeFlight(FlightsEntity removeFlight, int flightId) {
        if (flightsDao != null) {
            flightsDao.remove(removeFlight, removeFlight.getIdflight());
        } else System.out.println("...Dao e NULL");

    }

    public T find(int id) {
        if (flightsDao != null) {
            T x = (T) flightsDao.find(id);
            return x;
        } else return null;

    }
}
