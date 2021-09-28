package service;

import dao.ReservationsDao;
import model.ReservationsEntity;

import javax.persistence.Persistence;
import java.util.List;

public class ReservationsService<T> {

    private ReservationsDao reservationsDao;
    private Class<T> entityClass;

    public ReservationsService() {
        try {
            reservationsDao = new ReservationsDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addReservation(ReservationsEntity newReservation) {
        if (reservationsDao != null) {
            reservationsDao.create(newReservation);
        } else System.out.println("...Dao e NULL");
    }

    public void updateReservation(ReservationsEntity updatedReservation) {
        if (reservationsDao != null) {
            reservationsDao.update(updatedReservation);
        } else System.out.println("...Dao e NULL");
    }

    public List<ReservationsEntity> getAllReservations() {
        if (reservationsDao != null) {
            return reservationsDao.findAll();
        } else return null;
    }

    public void removeReservation(ReservationsEntity removeReservation, int reservationId) {
        if (reservationsDao != null) {
            reservationsDao.remove(removeReservation, removeReservation.getIdReservation());
        } else System.out.println("...Dao e NULL");
    }

    public T find(int id) {
        if (reservationsDao != null) {
            T x = (T) reservationsDao.find(id);
            return x;
        } else return null;
    }
}
