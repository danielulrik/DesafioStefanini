package br.com.ulrik.stefanini_desafio.presenter;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.ulrik.stefanini_desafio.model.City;
import br.com.ulrik.stefanini_desafio.model.Data;
import br.com.ulrik.stefanini_desafio.model.api.ResponseWeather;
import br.com.ulrik.stefanini_desafio.service.WeatherApi;
import br.com.ulrik.stefanini_desafio.view.WeatherSearchView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */

public class WeatherSearch implements WeatherSearchPresenter, Callback<ResponseWeather> {

    private static final Gson GSON = new Gson();
    private WeatherSearchView view;

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
    public void searchCity(City city) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<ResponseWeather> weatherCall = weatherApi.getWeather(city.getId(), WeatherApi.API_KEY, "pt", "metric");
        weatherCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseWeather> call, Response<ResponseWeather> response) {
        if (response.isSuccessful()) {
            ResponseWeather weather = response.body();
            view.goToCityDetail(weather);
        } else {
            view.showMessage("Não foi possível conectar com o serviço, favor verificar sua conexão.");
        }
    }

    @Override
    public void onFailure(Call<ResponseWeather> call, Throwable t) {
        view.showMessage("Não foi possível conectar com o serviço, favor verificar sua conexão.");
    }
}
