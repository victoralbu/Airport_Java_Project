package service;

import dao.InvoicesDao;
import model.InvoicesEntity;
import model.ReservationsEntity;

import javax.persistence.Persistence;
import java.util.List;

public class InvoicesService<T> {
    private InvoicesDao invoicesDao;
    private Class<T> entityClass;

    public InvoicesService() {
        try {
            invoicesDao = new InvoicesDao(Persistence.createEntityManagerFactory("default"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addInvoice(InvoicesEntity newInvoice) {
        if (invoicesDao != null) {
            invoicesDao.create(newInvoice);
        } else System.out.println("...Dao e NULL");
    }

    public void updateInvoice(InvoicesEntity updatedInvoice) {
        if (invoicesDao != null) {
            invoicesDao.update(updatedInvoice);
        } else System.out.println("...Dao e NULL");
    }

    public List<InvoicesEntity> getAllInvoices() {
        if (invoicesDao != null) {
            return invoicesDao.findAll();
        } else return null;
    }

    public void removeInvoice(InvoicesEntity removeInvoice, int invoicesId) {
        if (invoicesDao != null) {
            invoicesDao.remove(removeInvoice, removeInvoice.getIdReservation());
        } else System.out.println("...Dao e NULL");
    }

    public T find(int id) {
        if (invoicesDao != null) {
            T x = (T) invoicesDao.find(id);
            return x;
        } else return null;
    }
}
