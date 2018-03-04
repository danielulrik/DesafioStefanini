package br.com.ulrik.stefanini_desafio.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.ulrik.stefanini_desafio.R;
import br.com.ulrik.stefanini_desafio.adapter.FavoriteCitiesAdapter;
import br.com.ulrik.stefanini_desafio.model.FavoriteCity;
import br.com.ulrik.stefanini_desafio.model.api.WeatherResponse;
import br.com.ulrik.stefanini_desafio.presenter.FavoriteCities;
import br.com.ulrik.stefanini_desafio.presenter.FavoriteCitiesPresenter;

public class FavoriteCitiesActivity extends AppCompatActivity implements FavoriteCitiesView, View.OnClickListener, FavoriteCitiesAdapter.ItemClickListener {

    public static final String WEATHER_DETAILS = "details";

    private FavoriteCitiesPresenter presenter;
    private RecyclerView recyclerView;
    private TextView textViewEmpty;
    private LinearLayout header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_cities);
        setTitle(getString(R.string.title_favorite_cities));
        header = findViewById(R.id.header);
        textViewEmpty = findViewById(R.id.text_view_empty);
        recyclerView = findViewById(R.id.recycler_view_favorite_cities);
        Button buttonGoToCitiesSearch = findViewById(R.id.button_search);
        buttonGoToCitiesSearch.setOnClickListener(this);
        presenter = new FavoriteCities(this);
        presenter.init();
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, WeatherSearchActivity.class));
    }

    @Override
    public void updateList(List<FavoriteCity> cityList) {
        showList();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        FavoriteCitiesAdapter adapter = new FavoriteCitiesAdapter(cityList);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter == null) {
            presenter = new FavoriteCities(this);
        }
        presenter.init();
    }

    @Override
    public void onItemClick(FavoriteCity city) {
        presenter.favoriteCityClicked(city);
    }

    @Override
    public void showEmptyListMessage() {
        hideList();
        TextView textViewEmpty = findViewById(R.id.text_view_empty);
        textViewEmpty.setVisibility(View.VISIBLE);
        textViewEmpty.setText(R.string.text_empty_favorites);
    }

    /**
     * Sets the list and its components to View.VISIBLE
     */
    private void showList() {
        recyclerView.setVisibility(View.VISIBLE);
        textViewEmpty.setVisibility(View.GONE);
        header.setVisibility(View.VISIBLE);
    }

    /**
     * Sets the list and its components to View.GONE and shows the empty message
     */
    private void hideList() {
        recyclerView.setVisibility(View.GONE);
        textViewEmpty.setVisibility(View.VISIBLE);
        header.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToWeatherDetail(WeatherResponse weather) {
        Intent intent = new Intent(this, WeatherDetailActivity.class);
        intent.putExtra(WEATHER_DETAILS, weather);
        startActivity(intent);
    }
}
