package br.com.ulrik.stefanini_desafio.presenter;

import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public interface WeatherDetailPresenter {
    void load(WeatherResponse weather);

    /**
     * Saves the city to the favorite list
     *
     * @param response object that will be used to produce the FavoriteCity object
     */
    void favoriteCity(WeatherResponse response);
}
