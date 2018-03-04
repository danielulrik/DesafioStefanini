package br.com.ulrik.stefanini_desafio.presenter;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import br.com.ulrik.stefanini_desafio.model.FavoriteCity;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;
import br.com.ulrik.stefanini_desafio.service.WeatherService;
import br.com.ulrik.stefanini_desafio.view.FavoriteCitiesActivity;
import br.com.ulrik.stefanini_desafio.view.FavoriteCitiesView;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public class FavoriteCities implements FavoriteCitiesPresenter {

    private FavoriteCitiesView view;

    public FavoriteCities(FavoriteCitiesView view) {
        this.view = view;
    }

    @Override
    public void init() {
        List<FavoriteCity> cityList = SQLite.select().from(FavoriteCity.class).queryList();
        if (cityList.isEmpty()) {
            view.showEmptyListMessage();
        } else {
            view.updateList(cityList);
        }
    }

    @Override
    public void favoriteCityClicked(FavoriteCity favoriteCity) {
        new WeatherService(new WeatherService.OnRequestStatus() {
            @Override
            public void success(WeatherResponse weather) {
                view.goToWeatherDetail(weather);
            }

            @Override
            public void fail() {
                view.showMessage("Não foi possível conectar com o serviço, favor verificar sua conexão.");
            }
        }).searchCity(favoriteCity.getCityId());
    }

}
