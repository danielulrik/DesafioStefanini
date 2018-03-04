package br.com.ulrik.stefanini_desafio.view;

import java.util.List;

import br.com.ulrik.stefanini_desafio.model.City;
import br.com.ulrik.stefanini_desafio.model.api.ResponseWeather;
import br.com.ulrik.stefanini_desafio.model.api.Weather;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */

public interface WeatherSearchView {
    void updateList(List<City> cities);

    void goToCityDetail(ResponseWeather weather);

    void showMessage(String message);
}
