package br.com.ulrik.stefanini_desafio.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import br.com.ulrik.stefanini_desafio.R;
import br.com.ulrik.stefanini_desafio.adapter.CityAdapter;
import br.com.ulrik.stefanini_desafio.model.City;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;
import br.com.ulrik.stefanini_desafio.presenter.WeatherSearch;

public class WeatherSearchActivity extends AppCompatActivity implements WeatherSearchView, CityAdapter.ItemClickListener {

    public static final String WEATHER_DETAILS = "details";
    private WeatherSearch presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheather_search);
        setTitle(R.string.cities_title);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        presenter = new WeatherSearch(this);
        presenter.init();
    }

    @Override
    public void updateList(List<City> cities) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_cities);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        CityAdapter adapter = new CityAdapter(cities);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(City city) {
        presenter.searchCity(city.getId());
    }

    @Override
    public void goToWeatherDetail(WeatherResponse weather) {
        Intent intent = new Intent(this, WeatherDetailActivity.class);
        intent.putExtra(WEATHER_DETAILS, weather);
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
