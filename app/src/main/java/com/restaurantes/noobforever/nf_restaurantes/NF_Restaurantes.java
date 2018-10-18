package com.restaurantes.noobforever.nf_restaurantes;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.restaurantes.noobforever.nf_restaurantes.Adapter.RestaurantAdapter;
import com.restaurantes.noobforever.nf_restaurantes.Model.Restaurant;

import java.util.ArrayList;

public class NF_Restaurantes extends AppCompatActivity {
    private ArrayList<Restaurant> items=new ArrayList<>();
    private RecyclerView reciclador;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nf__restaurantes);

        hideNavigationBar();

        ListarRestaurantes();

        reciclador =(RecyclerView)findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);

        //Usar un administrador para LinearLayout
        lManayer= new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManayer);


        adapter=new RestaurantAdapter(items);
        reciclador.setAdapter(adapter);
    }

    private void ListarRestaurantes() {
        items.add(new Restaurant("Trattoria Italia","Colonial 303, Cercado de Lima, Lima","Comida italiana","https://igx.4sqi.net/img/general/300x300/7629019_85CEqMMZaqlCU_ZsQTQ5wKg5r8T47pbQ1YAF1SQ8tvY.jpg", 5,-12.046791,-77.045555));
        items.add(new Restaurant("El Chinito","Jr. Chancay 894, Cercado de Lima","Local de sándwiches","https://igx.4sqi.net/img/general/300x300/9445473_cAfKhw7U-oidemSIUjt2jEXTK40ExZONL3kRVNLmB50.jpg", 3,-12.0492099,-77.0407784));
        items.add(new Restaurant("Anticucheria La Norteña","Av. Mariano Cornejo 1006, Lima, Lima","Comida peruana","https://igx.4sqi.net/img/general/600x600/sVQNXbYl3rQDAbqC4ZIl7OK7M8BA-DIUoe46penaJEA.jpg", 4,-12.074805,-77.089643));
        items.add(new Restaurant("El Colonial","Av. Colonial 721 (Carcamo), Lima","Restaurante","https://igx.4sqi.net/img/general/300x300/61948179_7BJ1qV97ZHiKMT5WkzXm-T3_R8S-SBIkOMD-LFI9eFg.jpg", 2,-12.0473619,-77.0509183));
        System.out.print("Restaurants Listados");
        items.add(new Restaurant("Sangucheria Don Dante","Jr Iquique 370, Breña","Local de sándwiches","https://igx.4sqi.net/img/general/300x300/7754919_-GhcWFsbhzxJQWgE5f5pyBT9hostndD-1sTBNZnkQ9U.jpg", 3,-12.0541515,-77.0439427));
        items.add(new Restaurant("Norky's","Av. Los Constructores 174, La Molina","Polleria","https://igx.4sqi.net/img/general/300x300/54035078_2rMexxCJ00Ep_1F9oIBM7Z2C_Kc7R2hC0AfFA8xyyWQ.jpg", 4,-12.0675295,-76.9574399));
        items.add(new Restaurant("Rústica","Av. Venezuela 930, Breña","Comida italiana","https://igx.4sqi.net/img/general/300x300/39888269_jqVKBZ3TsWRV65tfmJ0aXA3NmRR0cHQbJm2IT8MbznA.jpg", 5,-12.1216067,-77.0309237));
        items.add(new Restaurant("El Campollo","Óvalo de Av. Venezuela, Breña, Lima","Pollos y Frituras","https://igx.4sqi.net/img/general/300x300/49793978_QkzoHVpt0_Dv2G2Jc9CCV10GKlI1MjGPBozPG3W32yg.jpg", 1,-12.0546584,-77.046182));
        System.out.print("Restaurants Listados");
        items.add(new Restaurant("Rinconcito Ferreñafano","Jr. Jorge Chávez 400, Lima","Comida peruana","https://igx.4sqi.net/img/general/300x300/5350954_QXOCcfGF2PVzk4ME7MEk0MoXnqDlP43GTXeS9ttc4ME.jpg", 3,-12.0539259,-77.0478128));
        items.add(new Restaurant("De Mares","Av. Venezuela, Breña","Ceviches y Mariscos","https://igx.4sqi.net/img/general/300x300/56844426_NAuxBmf6oBFdjcBxZGowp2SESb7W_I3dfAieGe30T4s.jpg", 2,-12.055069,-77.048013));
        items.add(new Restaurant("KFC","Av. Alfonso Ugarte, Breña","Comida rápida","https://igx.4sqi.net/img/general/300x300/107559709_KUHoC8siFckb1nHH1y9idP0exV45JvEpUlOCwrTizTI.jpg", 3,-12.076127,-76.9636756));
        items.add(new Restaurant("La Vasca","Jr. Carhuaz 384, Breña","Panadería","https://igx.4sqi.net/img/general/300x300/23859139_HZOSIxwueetns4wVSkVLTUpT8JIQtUXjLc3-3Ryvmag.jpg", 2,-12.1121979,-77.03859));
        System.out.print("Restaurants Listados");
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }

    private void hideNavigationBar() {
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN|
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }



}
