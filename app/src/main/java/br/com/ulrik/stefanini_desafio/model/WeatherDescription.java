package br.com.ulrik.stefanini_desafio.model;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public class WeatherDescription {
    private String description;
    private String icon;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "WeatherDescription{" +
                "description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
