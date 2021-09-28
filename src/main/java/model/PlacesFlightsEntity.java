package model;

import javax.persistence.*;

@Entity
@Table(name = "places_flights", schema = "aeroport", catalog = "")
@IdClass(PlacesFlightsEntityPK.class)
public class PlacesFlightsEntity {
    private int idplacesFlights;
    private Byte isBusy;
    private Byte isBusiness;
    private int idflight;
    private int placesIdPlaces;
    private FlightsEntity flightsByIdflight;
    private PlacesEntity placesByPlacesIdPlaces;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplaces_flights")
    public int getIdplacesFlights() {
        return idplacesFlights;
    }

    public void setIdplacesFlights(int idplacesFlights) {
        this.idplacesFlights = idplacesFlights;
    }

    @Basic
    @Column(name = "isBusy")
    public Byte getIsBusy() {
        return isBusy;
    }

    public void setIsBusy(Byte isBusy) {
        this.isBusy = isBusy;
    }

    @Basic
    @Column(name = "isBusiness")
    public Byte getIsBusiness() {
        return isBusiness;
    }

    public void setIsBusiness(Byte isBusiness) {
        this.isBusiness = isBusiness;
    }

    @Id
    @Column(name = "idflight")
    public int getIdflight() {
        return idflight;
    }

    public void setIdflight(int idflight) {
        this.idflight = idflight;
    }

    @Id
    @Column(name = "places_idPlaces")
    public int getPlacesIdPlaces() {
        return placesIdPlaces;
    }

    public void setPlacesIdPlaces(int placesIdPlaces) {
        this.placesIdPlaces = placesIdPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlacesFlightsEntity that = (PlacesFlightsEntity) o;

        if (idplacesFlights != that.idplacesFlights) return false;
        if (idflight != that.idflight) return false;
        if (placesIdPlaces != that.placesIdPlaces) return false;
        if (isBusy != null ? !isBusy.equals(that.isBusy) : that.isBusy != null) return false;
        if (isBusiness != null ? !isBusiness.equals(that.isBusiness) : that.isBusiness != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idplacesFlights;
        result = 31 * result + (isBusy != null ? isBusy.hashCode() : 0);
        result = 31 * result + (isBusiness != null ? isBusiness.hashCode() : 0);
        result = 31 * result + idflight;
        result = 31 * result + placesIdPlaces;
        return result;
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
    @JoinColumn(name = "places_idPlaces", referencedColumnName = "idPlaces", nullable = false, insertable = false, updatable = false)
    public PlacesEntity getPlacesByPlacesIdPlaces() {
        return placesByPlacesIdPlaces;
    }

    public void setPlacesByPlacesIdPlaces(PlacesEntity placesByPlacesIdPlaces) {
        this.placesByPlacesIdPlaces = placesByPlacesIdPlaces;
    }

    @Override
    public String toString() {
        return "PlacesFlightsEntity{" +
                "idplacesFlights=" + idplacesFlights +
                ", isBusy=" + isBusy +
                ", isBusiness=" + isBusiness +
                ", idflight=" + idflight +
                ", placesIdPlaces=" + placesIdPlaces +
                ", placesByPlacesIdPlaces=" + placesByPlacesIdPlaces +
                '}';
    }
}
