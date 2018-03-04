package br.com.ulrik.stefanini_desafio.view;

import java.util.List;

import br.com.ulrik.stefanini_desafio.model.City;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */

public interface WeatherSearchView {
    /**
     * Updates de list of cities
     *
     * @param cities city objects that will be used to update the list
     */
    void updateList(List<City> cities);

    /**
     * Go to the weather detail screen
     *
     * @param weather object that will be used to show the details
     */
    void goToWeatherDetail(WeatherResponse weather);

    /**
     * Show a message in the ui
     *
     * @param message message that will show up to the user
     */
    void showMessage(String message);
}
