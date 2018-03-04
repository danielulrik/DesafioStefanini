package br.com.ulrik.stefanini_desafio.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.ulrik.stefanini_desafio.R;

public class FavoriteCitiesActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonGoToCitiesSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_cities);
        buttonGoToCitiesSearch = findViewById(R.id.button_search);
        buttonGoToCitiesSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, WeatherSearchActivity.class));
    }
}
