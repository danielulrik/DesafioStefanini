
package br.com.ulrik.stefanini_desafio.model.api;

import java.util.List;

public class ResponseWeather {

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

}
