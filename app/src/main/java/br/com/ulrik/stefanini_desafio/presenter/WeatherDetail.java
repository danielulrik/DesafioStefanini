package br.com.ulrik.stefanini_desafio.presenter;


import java.util.List;

import br.com.ulrik.stefanini_desafio.model.api.Weather;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;
import br.com.ulrik.stefanini_desafio.util.Format;
import br.com.ulrik.stefanini_desafio.view.WeatherDetailView;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public class WeatherDetail implements WeatherDetailPresenter {

    private WeatherDetailView view;

    public WeatherDetail(WeatherDetailView view) {
        this.view = view;
    }

    @Override
    public void load(WeatherResponse weather) {
        view.setCityName(weather.getName());
        view.setTemperature(Format.formatTempCelsius(weather.getMain().getTemp()));
        view.setMaxTemperature(Format.formatTempCelsius(weather.getMain().getTempMax()));
        view.setMinTemperature(Format.formatTempCelsius(weather.getMain().getTempMin()));

        List<Weather> weathers = weather.getWeather();
        if (!weathers.isEmpty()) {
            view.setDescription(weather.getWeather().get(0).getDescription());
            view.setIcon(String.format("http://openweathermap.org/img/w/%s.png", weather.getWeather().get(0).getIcon()));
        }
    }
}

