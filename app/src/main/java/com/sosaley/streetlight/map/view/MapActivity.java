package com.sosaley.streetlight.map.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sosaley.streetlight.R;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    View mapView;
    private GoogleMap mGoogleMap;
    private FusedLocationProviderClient fusedLocationProviderClient;

    Double guindyLat=13.0067;
    Double guindyLon=80.2206;

    Double velcherryLat=12.9815;
    Double velcherryLon=80.2180;

    LatLng latLng1=new LatLng(guindyLat,guindyLon);
    LatLng latLng2=new LatLng(velcherryLat,velcherryLon);

    List<LatLng>  coordinatesList=new ArrayList<>();


    MarkerOptions markerOptions;
    Marker marker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mapfragment);

        coordinatesList.add(latLng1);
        coordinatesList.add(latLng2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.streetLightMap);
        mapFragment.getMapAsync(this);
        mapView = mapFragment.getView();





        //fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MapActivity.this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap=googleMap;

        moveCamera(guindyLat, guindyLon);

        for (int i = 0; i <coordinatesList.size() ; i++) {

            addMarker(coordinatesList.get(i).latitude, coordinatesList.get(i).longitude);

        }



        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                moveCamera(guindyLat, guindyLon);
            }
        },1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addMarker(guindyLat, guindyLon);
            }
        },1000);*/




    }

    private void moveCamera(Double guindyLat, Double guindyLon) {

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(guindyLat, guindyLon), 12));

    }

    private void addMarker(Double guindyLat, Double guindyLon) {

        markerOptions = new MarkerOptions().position(new LatLng(guindyLat, guindyLon)).title("Murali");
        marker = mGoogleMap.addMarker(markerOptions);
        marker.showInfoWindow();



    }



}
