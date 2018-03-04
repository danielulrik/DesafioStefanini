package br.com.ulrik.stefanini_desafio.model;

import com.raizlabs.android.dbflow.annotation.Table;

import br.com.ulrik.stefanini_desafio.database.AppDatabase;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */
public class City {

    private int id;
    private String country;
    private Coordinate coord;
    private String name;
    private int zoom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }
}
