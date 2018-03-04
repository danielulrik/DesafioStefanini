package br.com.ulrik.stefanini_desafio.presenter;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */

public interface WeatherSearchPresenter {
    void init();

    /**
     * Access the weather api and updates the ui
     * @param city city id
     */
    void searchCity(int city);
}
