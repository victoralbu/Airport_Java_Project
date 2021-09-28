package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "plane", schema = "aeroport", catalog = "")
public class PlaneEntity {
    private int idPlane;
    private String planeNr;
    private String companyName;
    private Collection<ReservationsEntity> reservationsByIdPlane;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlane")
    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    @Basic
    @Column(name = "planeNr")
    public String getPlaneNr() {
        return planeNr;
    }

    public void setPlaneNr(String planeNr) {
        this.planeNr = planeNr;
    }

    @Basic
    @Column(name = "companyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaneEntity that = (PlaneEntity) o;

        if (idPlane != that.idPlane) return false;
        if (planeNr != null ? !planeNr.equals(that.planeNr) : that.planeNr != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPlane;
        result = 31 * result + (planeNr != null ? planeNr.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "planeByIdPlane")
    public Collection<ReservationsEntity> getReservationsByIdPlane() {
        return reservationsByIdPlane;
    }

    public void setReservationsByIdPlane(Collection<ReservationsEntity> reservationsByIdPlane) {
        this.reservationsByIdPlane = reservationsByIdPlane;
    }

    @Override
    public String toString() {
        return "PlaneEntity{" +
                "idPlane=" + idPlane +
                ", planeNr='" + planeNr + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
