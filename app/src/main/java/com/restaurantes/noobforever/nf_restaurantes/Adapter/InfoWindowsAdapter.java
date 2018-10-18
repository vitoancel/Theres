package com.restaurantes.noobforever.nf_restaurantes.Adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.restaurantes.noobforever.nf_restaurantes.MapsActivity;
import com.restaurantes.noobforever.nf_restaurantes.R;
import com.squareup.picasso.Picasso;


public class InfoWindowsAdapter implements GoogleMap.InfoWindowAdapter {

    private Context context ;

    public InfoWindowsAdapter(Context ctx) {
        this.context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater().inflate(R.layout.infowindows_restaurants,null);

        ImageView ImgInfo = (ImageView)view.findViewById(R.id.imgInfo);
        ImageView StarsInfo = (ImageView)view.findViewById(R.id.imgratingInfo);
        TextView NombreInfo = (TextView) view.findViewById(R.id.lblNombreInfo);
        TextView CategoriaInfo = (TextView) view.findViewById(R.id.lblcategoriaInfo);
        TextView DireccionInfo = (TextView) view.findViewById(R.id.lbldireccionInfo);

        MapsActivity.InfoWindowData infoWindowData = (MapsActivity.InfoWindowData) marker.getTag();
        int imageId = context.getResources().getIdentifier(String.valueOf(infoWindowData.getStar()),
                "drawable", context.getPackageName());
        StarsInfo.setImageResource(imageId);

        Picasso.with(context)
                .load(infoWindowData.getImage())
                .into(ImgInfo);


        NombreInfo.setText(infoWindowData.getNomb());
        CategoriaInfo.setText(infoWindowData.getCat());
        DireccionInfo.setText(infoWindowData.getDir());

        return view;
    }
}
