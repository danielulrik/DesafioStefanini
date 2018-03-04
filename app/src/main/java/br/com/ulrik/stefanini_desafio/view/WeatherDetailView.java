package br.com.ulrik.stefanini_desafio.view;

import android.graphics.Bitmap;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public interface WeatherDetailView {
    void setCityName(String name);

    void setTemperature(String temp);

    void setMaxTemperature(String tempMax);

    void setMinTemperature(String tempMin);

    void setDescription(String description);

    void setIcon(Bitmap icon);

    void showMessage(String message);
}
