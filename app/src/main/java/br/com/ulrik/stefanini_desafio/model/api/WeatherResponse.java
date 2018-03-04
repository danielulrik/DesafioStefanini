
package br.com.ulrik.stefanini_desafio.model.api;

import java.io.Serializable;
import java.util.List;

import br.com.ulrik.stefanini_desafio.model.City;

public class WeatherResponse implements Serializable {

    private int cityId;
    private String name;
    private Main main;
    private List<Weather> weather = null;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
