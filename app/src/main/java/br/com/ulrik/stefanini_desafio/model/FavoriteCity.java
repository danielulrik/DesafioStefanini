package br.com.ulrik.stefanini_desafio.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.Model;

import br.com.ulrik.stefanini_desafio.database.AppDatabase;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */
@Table(database = AppDatabase.class)
public class FavoriteCity extends BaseModel {

    @PrimaryKey
    private int cityId;
    @Column
    private String name;
    @Column
    private String weatherDescription;
    @Column
    private String temperature;

    public FavoriteCity() {
    }

    public FavoriteCity(int cityId, String name, String weatherDescription, String temperature) {
        this.cityId = cityId;
        this.name = name;
        this.weatherDescription = weatherDescription;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
