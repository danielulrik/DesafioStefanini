package br.com.ulrik.stefanini_desafio.view;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.ulrik.stefanini_desafio.R;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;
import br.com.ulrik.stefanini_desafio.presenter.WeatherDetail;
import br.com.ulrik.stefanini_desafio.presenter.WeatherDetailPresenter;

public class WeatherDetailActivity extends AppCompatActivity implements WeatherDetailView {

    private WeatherResponse response;
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

        response = (WeatherResponse) getIntent().getSerializableExtra(WeatherSearchActivity.WEATHER_DETAILS);
        presenter.load(response);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_favorite_city) {
            presenter.favoriteCity(response);
        }
        return true;
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
    public void setIcon(final Bitmap icon) {
        imageViewIcon.setImageBitmap(icon);
    }
}
