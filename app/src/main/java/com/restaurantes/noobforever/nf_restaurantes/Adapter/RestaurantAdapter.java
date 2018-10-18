package com.restaurantes.noobforever.nf_restaurantes.Adapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.restaurantes.noobforever.nf_restaurantes.MapsActivity;
import com.restaurantes.noobforever.nf_restaurantes.Model.Restaurant;
import com.restaurantes.noobforever.nf_restaurantes.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestaurantAdapter
        extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private ArrayList<Restaurant> items;

    public RestaurantAdapter(ArrayList<Restaurant> items) { //Se inicializa
        this.items = items;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.restaurant_card, viewGroup,false);  //Se trabaja con variable viewGroup
        return new RestaurantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, final int i) {
        //personViewHolder.imgFoto.setImageResource(items.get(i).getIdfoto());
        Picasso.with(restaurantViewHolder.imgFoto.getContext())
                .load(items.get(i).getUrlFoto())
                .into(restaurantViewHolder.imgFoto);

        restaurantViewHolder.lblNombre.setText(items.get(i).getNombre());
        restaurantViewHolder.lblDireccion.setText(items.get(i).getDireccion());
        restaurantViewHolder.lblCategoria.setText(items.get(i).getCategoria());
        restaurantViewHolder.lblRating.setText(String.valueOf(items.get(i).getRating())+".0");
        restaurantViewHolder.restaurantCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle datos = new Bundle();
                datos.putDouble("Lat", items.get(i).getLat());
                datos.putDouble("Lon",items.get(i).getLon());
                datos.putString("Nombre",items.get(i).getNombre());
                datos.putString("Direccion",items.get(i).getDireccion());
                datos.putString("Imagen",items.get(i).getUrlFoto());
                datos.putString("Categ",items.get(i).getCategoria());
                datos.putInt("Stars",items.get(i).getRating());
                Intent newActivity = new Intent(v.getContext(), MapsActivity.class);
                newActivity.putExtras(datos);
                v.getContext().startActivity(newActivity);

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static  class RestaurantViewHolder extends RecyclerView.ViewHolder{
        public CardView restaurantCard;
        public ImageView imgFoto;
        public TextView lblNombre;
        public TextView lblDireccion;
        public TextView lblCategoria;
        public TextView lblRating;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantCard=(CardView)itemView.findViewById(R.id.restaurantCard);
            imgFoto= (ImageView) itemView.findViewById(R.id.imgFoto);
            lblNombre=(TextView)itemView.findViewById(R.id.lblNombre);
            lblDireccion=(TextView)itemView.findViewById(R.id.lbldireccion);
            lblCategoria=(TextView)itemView.findViewById(R.id.lblcategoria);
            lblRating=(TextView) itemView.findViewById(R.id.lblrating);
        }



    }
}
