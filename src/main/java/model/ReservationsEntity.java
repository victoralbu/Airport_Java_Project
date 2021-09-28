package model;

import javax.persistence.*;

@Entity
@Table(name = "reservations", schema = "aeroport")
public class ReservationsEntity {
    private int idReservation;
    private int idUsers;
    private int idflight;
    private int idPlane;
    private String status;
    private InvoicesEntity invoicesByIdReservation;
    private UsersEntity usersByIdUsers;
    private FlightsEntity flightsByIdflight;
    private PlaneEntity planeByIdPlane;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Basic
    @Column(name = "idUsers")
    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Basic
    @Column(name = "idflight")
    public int getIdflight() {
        return idflight;
    }

    public void setIdflight(int idflight) {
        this.idflight = idflight;
    }

    @Basic
    @Column(name = "idPlane")
    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationsEntity that = (ReservationsEntity) o;

        if (idReservation != that.idReservation) return false;
        if (idUsers != that.idUsers) return false;
        if (idflight != that.idflight) return false;
        if (idPlane != that.idPlane) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReservation;
        result = 31 * result + idUsers;
        result = 31 * result + idflight;
        result = 31 * result + idPlane;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "reservationsByIdReservation", fetch = FetchType.EAGER)
    public InvoicesEntity getInvoicesByIdReservation() {
        return invoicesByIdReservation;
    }

    public void setInvoicesByIdReservation(InvoicesEntity invoicesByIdReservation) {
        this.invoicesByIdReservation = invoicesByIdReservation;
    }

    @ManyToOne
    @JoinColumn(name = "idUsers", referencedColumnName = "idUser", nullable = false, insertable = false, updatable = false)
    public UsersEntity getUsersByIdUsers() {
        return usersByIdUsers;
    }

    public void setUsersByIdUsers(UsersEntity usersByIdUsers) {
        this.usersByIdUsers = usersByIdUsers;
    }

    @ManyToOne
    @JoinColumn(name = "idflight", referencedColumnName = "idflight", nullable = false, insertable = false, updatable = false)
    public FlightsEntity getFlightsByIdflight() {
        return flightsByIdflight;
    }

    public void setFlightsByIdflight(FlightsEntity flightsByIdflight) {
        this.flightsByIdflight = flightsByIdflight;
    }

    @ManyToOne
    @JoinColumn(name = "idPlane", referencedColumnName = "idPlane", nullable = false, insertable = false, updatable = false)
    public PlaneEntity getPlaneByIdPlane() {
        return planeByIdPlane;
    }

    public void setPlaneByIdPlane(PlaneEntity planeByIdPlane) {
        this.planeByIdPlane = planeByIdPlane;
    }

    @Override
    public String toString() {
        return "ReservationsEntity{" +
                "idReservation=" + idReservation +
                ", idUsers=" + idUsers +
                ", idflight=" + idflight +
                ", idPlane=" + idPlane +
                ", status='" + status + '\'' +
                ", invoicesByIdReservation=" + invoicesByIdReservation +
                ", flightsByIdflight=" + flightsByIdflight +
                ", planeByIdPlane=" + planeByIdPlane +
                '}';
    }
}
