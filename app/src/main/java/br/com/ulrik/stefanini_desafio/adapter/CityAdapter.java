package br.com.ulrik.stefanini_desafio.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.ulrik.stefanini_desafio.model.City;

/**
 * Created by Daniel Ulrik on 03/03/2018.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private ItemClickListener listener;
    private List<City> cities;

    public CityAdapter(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textViewCity = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(textViewCity);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(cities.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView mTextView;
        ViewHolder(TextView v) {
            super(v);
            mTextView = v;
            mTextView.setOnClickListener(this);
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
        void onItemClick(City city);
    }
}
