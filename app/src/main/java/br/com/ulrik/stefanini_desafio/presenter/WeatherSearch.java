package br.com.ulrik.stefanini_desafio.presenter;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.ulrik.stefanini_desafio.model.Data;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;
import br.com.ulrik.stefanini_desafio.service.WeatherService;
import br.com.ulrik.stefanini_desafio.view.WeatherSearchView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */

public class WeatherSearch implements WeatherSearchPresenter {

    private static final Gson GSON = new Gson();
    private WeatherSearchView view;
    private int selectedCity;

    public WeatherSearch(WeatherSearchView view) {
        this.view = view;
    }

    @Override
    public void init() {
        loadCities();
    }

    private void loadCities() {
        try {
            InputStream stream = ((Context) view).getAssets().open("city.list.json");
            Data data = GSON.fromJson(new InputStreamReader(stream), Data.class);
            view.updateList(data.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchCity(int city) {
        new WeatherService(new WeatherService.OnRequestStatus() {
            @Override
            public void success(WeatherResponse weather) {
                weather.setCityId(selectedCity);
                view.goToWeatherDetail(weather);
            }

            @Override
            public void fail() {
                showFailMessage();
            }
        }).searchCity(selectedCity = city);
    }

    private void showFailMessage() {
        view.showMessage("Não foi possível conectar com o serviço, favor verificar sua conexão.");
    }
}
