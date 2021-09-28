package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PlacesFlightsEntityPK implements Serializable {
    private int idplacesFlights;
    private int idflight;
    private int placesIdPlaces;

    @Column(name = "idplaces_flights")
    @Id
    public int getIdplacesFlights() {
        return idplacesFlights;
    }

    public void setIdplacesFlights(int idplacesFlights) {
        this.idplacesFlights = idplacesFlights;
    }

    @Column(name = "idflight")
    @Id
    public int getIdflight() {
        return idflight;
    }

    public void setIdflight(int idflight) {
        this.idflight = idflight;
    }

    @Column(name = "places_idPlaces")
    @Id
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

        PlacesFlightsEntityPK that = (PlacesFlightsEntityPK) o;

        if (idplacesFlights != that.idplacesFlights) return false;
        if (idflight != that.idflight) return false;
        if (placesIdPlaces != that.placesIdPlaces) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idplacesFlights;
        result = 31 * result + idflight;
        result = 31 * result + placesIdPlaces;
        return result;
    }
}
