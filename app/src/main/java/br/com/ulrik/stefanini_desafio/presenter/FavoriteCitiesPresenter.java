package br.com.ulrik.stefanini_desafio.presenter;

import br.com.ulrik.stefanini_desafio.model.FavoriteCity;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */
public interface FavoriteCitiesPresenter {
    void init();

    void favoriteCityClicked(FavoriteCity favoriteCity);
}
