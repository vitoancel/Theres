package com.restaurantes.noobforever.nf_restaurantes;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.restaurantes.noobforever.nf_restaurantes.Adapter.InfoWindowsAdapter;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    Double Lat, Lon;
    String Nombre,Categ, Direccion,UrlImg;
    int Stars;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = this.getIntent();
        Lat=intent.getExtras().getDouble("Lat");
        Lon=intent.getExtras().getDouble("Lon");
        Nombre=intent.getExtras().getString("Nombre");
        Categ = intent.getExtras().getString("Categ");
        Direccion=intent.getExtras().getString("Direccion");
        Stars = intent.getExtras().getInt("Stars");
        UrlImg=intent.getExtras().getString("Imagen");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng rest = new LatLng(Lat, Lon);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(rest)
                    .title(Nombre)
                    .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.restaurant_marker)));


        InfoWindowData info = new InfoWindowData();
        info.setNomb(Nombre);
        info.setCat(Categ);
        info.setDir(Direccion);
        info.setStar(Stars);
        info.setImage(UrlImg);

        CameraPosition camPos = new CameraPosition.Builder()
                .target(rest)   //Centramos el mapa
                .zoom(16)         //Establecemos el zoom en 16
                .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
                .bearing(0)
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);



        mMap.animateCamera(camUpd3);

        Marker m =mMap.addMarker(markerOptions);

        InfoWindowsAdapter infoWindows = new InfoWindowsAdapter(this);
        mMap.setInfoWindowAdapter(infoWindows);
        m.setTag(info);
        m.showInfoWindow();

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rest,15.0f));
    }

    public class InfoWindowData {
        private String image;
        private String nomb;
        private String cat;
        private String dir;
        private int star;

        public String getImage() {
            return image;
        }
        public void setImage(String image) {
            this.image = image;
        }
        public String getCat() {
            return cat;
        }
        public void setCat(String cat) {
            this.cat = cat;
        }
        public String getDir() {
            return dir;
        }
        public void setDir(String dir) {
            this.dir = dir;
        }
        public String getNomb() {
            return nomb;
        }
        public void setNomb(String nomb) {
            this.nomb = nomb;
        }

        public int getStar() {
            return star;
        }

        public void setStar(int star) {
            this.star = star;
        }
    }
}
