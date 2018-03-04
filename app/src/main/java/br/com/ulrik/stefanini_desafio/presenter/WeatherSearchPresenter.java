package br.com.ulrik.stefanini_desafio.presenter;

import br.com.ulrik.stefanini_desafio.model.City;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */

public interface WeatherSearchPresenter {
    void init();

    void searchCity(City city);
}
