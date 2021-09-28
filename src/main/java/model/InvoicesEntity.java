package model;

import javax.persistence.*;

@Entity
@Table(name = "invoices", schema = "aeroport", catalog = "")
public class InvoicesEntity {
    private int idReservation;
    private Integer sum;
    private Byte paid;
    private ReservationsEntity reservationsByIdReservation;

    @Id
    @Column(name = "idReservation")
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Basic
    @Column(name = "sum")
    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "paid")
    public Byte getPaid() {
        return paid;
    }

    public void setPaid(Byte paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoicesEntity that = (InvoicesEntity) o;

        if (idReservation != that.idReservation) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;
        if (paid != null ? !paid.equals(that.paid) : that.paid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReservation;
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "idReservation", referencedColumnName = "idReservation", nullable = false)
    public ReservationsEntity getReservationsByIdReservation() {
        return reservationsByIdReservation;
    }

    public void setReservationsByIdReservation(ReservationsEntity reservationsByIdReservation) {
        this.reservationsByIdReservation = reservationsByIdReservation;
    }

    @Override
    public String toString() {
        return "InvoicesEntity{" +
                "idReservation=" + idReservation +
                ", sum=" + sum +
                ", paid=" + paid +
                '}';
    }
}
