package br.com.ulrik.stefanini_desafio.view;

import java.util.List;

import br.com.ulrik.stefanini_desafio.model.FavoriteCity;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */
public interface FavoriteCitiesView {
    void updateList(List<FavoriteCity> cityList);

    void showEmptyListMessage();

    void showMessage(String message);

    void goToWeatherDetail(WeatherResponse weather);
}
