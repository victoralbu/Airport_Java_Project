package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "places", schema = "aeroport", catalog = "")
public class PlacesEntity {
    private int idPlaces;
    private String seatNumber;
    private Collection<PlacesFlightsEntity> placesFlightsByIdPlaces;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlaces")
    public int getIdPlaces() {
        return idPlaces;
    }

    public void setIdPlaces(int idPlaces) {
        this.idPlaces = idPlaces;
    }

    @Basic
    @Column(name = "seatNumber")
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlacesEntity that = (PlacesEntity) o;

        if (idPlaces != that.idPlaces) return false;
        if (seatNumber != null ? !seatNumber.equals(that.seatNumber) : that.seatNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPlaces;
        result = 31 * result + (seatNumber != null ? seatNumber.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "placesByPlacesIdPlaces")
    public Collection<PlacesFlightsEntity> getPlacesFlightsByIdPlaces() {
        return placesFlightsByIdPlaces;
    }

    public void setPlacesFlightsByIdPlaces(Collection<PlacesFlightsEntity> placesFlightsByIdPlaces) {
        this.placesFlightsByIdPlaces = placesFlightsByIdPlaces;
    }

    @Override
    public String toString() {
        return "PlacesEntity{" +
                "idPlaces=" + idPlaces +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}
