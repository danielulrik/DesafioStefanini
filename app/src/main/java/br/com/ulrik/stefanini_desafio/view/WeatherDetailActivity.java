package br.com.ulrik.stefanini_desafio.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.ulrik.stefanini_desafio.R;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;
import br.com.ulrik.stefanini_desafio.presenter.WeatherDetail;
import br.com.ulrik.stefanini_desafio.presenter.WeatherDetailPresenter;

public class WeatherDetailActivity extends AppCompatActivity implements WeatherDetailView {

    private WeatherDetailPresenter presenter;
    private TextView textViewName;
    private TextView textViewDescription;
    private TextView textViewTemp;
    private TextView textViewMinTemp;
    private TextView textViewMaxTemp;
    private ImageView imageViewIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        presenter = new WeatherDetail(this);
        textViewName = findViewById(R.id.text_view_city_name);
        textViewTemp = findViewById(R.id.text_view_temperature);
        textViewMinTemp = findViewById(R.id.text_view_temp_min);
        textViewMaxTemp = findViewById(R.id.text_view_temp_max);
        imageViewIcon = findViewById(R.id.image_view_icon);
        textViewDescription = findViewById(R.id.text_view_description);

        presenter.load((WeatherResponse) getIntent().getSerializableExtra(WeatherSearchActivity.WEATHER_DETAILS));
    }

    @Override
    public void setCityName(String name) {
        textViewName.setText(name);
    }

    @Override
    public void setTemperature(String temp) {
        textViewTemp.setText(temp);
    }

    @Override
    public void setMaxTemperature(String tempMax) {
        textViewMaxTemp.setText(tempMax);
    }

    @Override
    public void setMinTemperature(String tempMin) {
        textViewMinTemp.setText(tempMin);
    }

    @Override
    public void setDescription(String description) {
        textViewDescription.setText(description);
    }

    @Override
    public void setIcon(final String icon) {
        // TODO TIRAR DAQUI
        new AsyncTask<Void, Void, Void>() {
            Bitmap bmp;
            @Override
            protected Void doInBackground(Void[] objects) {
                URL url = null;
                try {
                    url = new URL(icon);
                    bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void o) {
                imageViewIcon.setImageBitmap(bmp);
            }
        }.execute();
    }
}
