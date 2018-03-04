package br.com.ulrik.stefanini_desafio.service;

import com.google.gson.Gson;

import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public class WeatherService implements Callback<WeatherResponse> {

    private static final Gson GSON = new Gson();
    private OnRequestStatus onRequestStatus;

    public WeatherService(OnRequestStatus onRequestStatus) {
        this.onRequestStatus = onRequestStatus;
    }

    public void searchCity(int city) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .build();
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<WeatherResponse> weatherCall = weatherApi.getWeather(city, WeatherApi.API_KEY, "pt", "metric");
        weatherCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
        if (response.isSuccessful()) {
            WeatherResponse weather = response.body();
            if (weather != null) {
                onRequestStatus.success(weather);
            } else {
                onRequestStatus.fail();
            }
        } else {
            onRequestStatus.fail();
        }
    }

    @Override
    public void onFailure(Call<WeatherResponse> call, Throwable t) {
        onRequestStatus.fail();
    }

    public interface OnRequestStatus {
        void success(WeatherResponse weather);
        void fail();
    }

}
