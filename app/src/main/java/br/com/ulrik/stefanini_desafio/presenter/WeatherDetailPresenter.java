package br.com.ulrik.stefanini_desafio.presenter;

import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public interface WeatherDetailPresenter {
    void load(WeatherResponse weather);

    void favoriteCity(WeatherResponse response);
}
