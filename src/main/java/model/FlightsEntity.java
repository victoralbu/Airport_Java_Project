package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "flights", schema = "aeroport", catalog = "")
public class FlightsEntity {
    private int idflight;
    private String placeOfDeparture;
    private String placeOfLanding;
    private Double price;
    private Timestamp timeOfDeparture;
    private Timestamp timeOfLanding;
    private Collection<PlacesFlightsEntity> placesFlightsByIdflight;
    private Collection<ReservationsEntity> reservationsByIdflight;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idflight")
    public int getIdflight() {
        return idflight;
    }

    public void setIdflight(int idflight) {
        this.idflight = idflight;
    }

    @Basic
    @Column(name = "placeOfDeparture")
    public String getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public void setPlaceOfDeparture(String placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    @Basic
    @Column(name = "placeOfLanding")
    public String getPlaceOfLanding() {
        return placeOfLanding;
    }

    public void setPlaceOfLanding(String placeOfLanding) {
        this.placeOfLanding = placeOfLanding;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "timeOfDeparture")
    public Timestamp getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(Timestamp timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    @Basic
    @Column(name = "timeOfLanding")
    public Timestamp getTimeOfLanding() {
        return timeOfLanding;
    }

    public void setTimeOfLanding(Timestamp timeOfLanding) {
        this.timeOfLanding = timeOfLanding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightsEntity that = (FlightsEntity) o;

        if (idflight != that.idflight) return false;
        if (placeOfDeparture != null ? !placeOfDeparture.equals(that.placeOfDeparture) : that.placeOfDeparture != null)
            return false;
        if (placeOfLanding != null ? !placeOfLanding.equals(that.placeOfLanding) : that.placeOfLanding != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (timeOfDeparture != null ? !timeOfDeparture.equals(that.timeOfDeparture) : that.timeOfDeparture != null)
            return false;
        if (timeOfLanding != null ? !timeOfLanding.equals(that.timeOfLanding) : that.timeOfLanding != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idflight;
        result = 31 * result + (placeOfDeparture != null ? placeOfDeparture.hashCode() : 0);
        result = 31 * result + (placeOfLanding != null ? placeOfLanding.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (timeOfDeparture != null ? timeOfDeparture.hashCode() : 0);
        result = 31 * result + (timeOfLanding != null ? timeOfLanding.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "flightsByIdflight")
    public Collection<PlacesFlightsEntity> getPlacesFlightsByIdflight() {
        return placesFlightsByIdflight;
    }

    public void setPlacesFlightsByIdflight(Collection<PlacesFlightsEntity> placesFlightsByIdflight) {
        this.placesFlightsByIdflight = placesFlightsByIdflight;
    }

    @OneToMany(mappedBy = "flightsByIdflight", cascade = CascadeType.ALL)
    public Collection<ReservationsEntity> getReservationsByIdflight() {
        return reservationsByIdflight;
    }

    public void setReservationsByIdflight(Collection<ReservationsEntity> reservationsByIdflight) {
        this.reservationsByIdflight = reservationsByIdflight;
    }

    @Override
    public String toString() {
        return "FlightsEntity{" +
                "idflight=" + idflight +
                ", placeOfDeparture='" + placeOfDeparture + '\'' +
                ", placeOfLanding='" + placeOfLanding + '\'' +
                ", price=" + price +
                ", timeOfDeparture=" + timeOfDeparture +
                ", timeOfLanding=" + timeOfLanding +
                ", placesFlightsByIdflight=" + placesFlightsByIdflight +
                '}';
    }
}
