package com.sosaley.streetlight.map.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.sosaley.streetlight.R;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    View mapView;
    private GoogleMap mGoogleMap;
    private FusedLocationProviderClient fusedLocationProviderClient;

    Double guindyLat=13.0067;
    Double guindyLon=80.2206;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mapfragment);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.streetLightMap);
        mapFragment.getMapAsync(this);
        mapView = mapFragment.getView();

        addMarker(guindyLat, guindyLon);

        //fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MapActivity.this);

    }

    private void addMarker(Double guindyLat, Double guindyLon) {



    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

         mGoogleMap=googleMap;


    }
}
