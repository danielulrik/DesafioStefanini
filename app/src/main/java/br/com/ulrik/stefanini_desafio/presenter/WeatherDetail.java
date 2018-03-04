package br.com.ulrik.stefanini_desafio.presenter;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.ulrik.stefanini_desafio.model.FavoriteCity;
import br.com.ulrik.stefanini_desafio.model.api.Weather;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;
import br.com.ulrik.stefanini_desafio.util.Format;
import br.com.ulrik.stefanini_desafio.view.WeatherDetailView;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public class WeatherDetail implements WeatherDetailPresenter {

    private WeatherDetailView view;

    public WeatherDetail(WeatherDetailView view) {
        this.view = view;
    }

    @Override
    public void load(final WeatherResponse weather) {
        view.setCityName(weather.getName());
        view.setTemperature(Format.formatTempCelsius(weather.getMain().getTemp()));
        view.setMaxTemperature(Format.formatTempCelsius(weather.getMain().getTempMax()));
        view.setMinTemperature(Format.formatTempCelsius(weather.getMain().getTempMin()));

        List<Weather> weathers = weather.getWeather();
        if (!weathers.isEmpty()) {
            view.setDescription(weather.getWeather().get(0).getDescription());
            String icon = weather.getWeather().get(0).getIcon();
            new ImageLoader(new ImageLoader.OnLoaded() {
                @Override
                public void loaded(Bitmap bitmap) {
                    if (bitmap != null) view.setIcon(bitmap);
                }
            }).execute(icon);
        }
    }

    @Override
    public void favoriteCity(WeatherResponse response) {
        Weather weather = response.getWeather().get(0);
        FavoriteCity favoriteCity = new FavoriteCity(response.getCityId(), response.getName(),
                (weather != null ? weather.getDescription() : ""),
                Format.formatTempCelsius(response.getMain().getTemp()));
        favoriteCity.save();
        view.showMessage("A cidade foi adicionada aos favoritos.");
    }

    private static class ImageLoader extends AsyncTask<String, Void, Bitmap> {
        OnLoaded onLoaded;

        ImageLoader(OnLoaded onLoaded) {
            this.onLoaded = onLoaded;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bmp = null;
            URL url = null;
            try {
                url = new URL(String.format("http://openweathermap.org/img/w/%s.png", params[0]));
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (onLoaded != null) onLoaded.loaded(bitmap);
        }

        interface OnLoaded {
            void loaded(Bitmap bitmap);
        }
    }

}

