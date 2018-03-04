package br.com.ulrik.stefanini_desafio.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.com.ulrik.stefanini_desafio.R;
import br.com.ulrik.stefanini_desafio.model.FavoriteCity;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */

public class FavoriteCitiesAdapter extends RecyclerView.Adapter<FavoriteCitiesAdapter.ViewHolder> {

    private ItemClickListener listener;
    private List<FavoriteCity> cities;

    public FavoriteCitiesAdapter(List<FavoriteCity> cities) {
        this.cities = cities;
    }

    @Override
    public FavoriteCitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_favorite_city, parent, false);

        TextView textViewName = layout.findViewById(R.id.text_view_city_name);
        TextView textViewDescription = layout.findViewById(R.id.text_view_city_weather_description);
        TextView textViewTemperature = layout.findViewById(R.id.text_view_city_temperature);

        return new ViewHolder(layout, textViewName, textViewDescription, textViewTemperature);
    }

    @Override
    public void onBindViewHolder(FavoriteCitiesAdapter.ViewHolder holder, int position) {
        holder.mTextViewName.setText(cities.get(position).getName());
        holder.mTextViewDescription.setText(cities.get(position).getWeatherDescription());
        holder.mTextViewTemperature.setText(cities.get(position).getTemperature());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextViewName, mTextViewDescription, mTextViewTemperature;
        ViewHolder(LinearLayout layout, TextView textViewName, TextView textViewDescription, TextView textViewTemperature) {
            super(layout);
            layout.setOnClickListener(this);
            mTextViewName = textViewName;
            mTextViewDescription = textViewDescription;
            mTextViewTemperature = textViewTemperature;
        }

        @Override
        public void onClick(View view) {
            if(listener != null && cities != null) {
                listener.onItemClick(cities.get(getAdapterPosition()));
            }
        }
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public interface ItemClickListener {
        void onItemClick(FavoriteCity city);
    }
}
