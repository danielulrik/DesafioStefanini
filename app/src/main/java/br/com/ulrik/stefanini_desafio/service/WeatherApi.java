package br.com.ulrik.stefanini_desafio.service;

import br.com.ulrik.stefanini_desafio.model.api.ResponseWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public interface WeatherApi {

    // http://api.openweathermap.org/data/2.5/weather?id=3470127&
    // appid=2bac87e0cb16557bff7d4ebcbaa89d2f&lang=pt&units=metric
    String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    String API_KEY = "2bac87e0cb16557bff7d4ebcbaa89d2f";

    @GET("weather/")
    Call<ResponseWeather> getWeather(@Query("id") Integer cityId,
                                             @Query("appid") String appId,
                                             @Query("lang") String lang,
                                             @Query("units") String units);
}
