package com.example.uas_1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.uas_1.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private LatLng location; //*--> utk dynamically store chosen location

    private final LatLng binus = new LatLng(-6.9153653, 107.5886954);
    private final LatLng braga = new LatLng(-6.9178283, 107.6045685);
    private final LatLng alun = new LatLng(-6.9218295, 107.6021967);
    private final LatLng gazibu = new LatLng(-6.9002779, 107.6161296);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //* Button setup
        Button buttonBinus = findViewById(R.id.binus);
        buttonBinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = binus;
                moveCameraToLocation();
            }
        });
        Button buttonBraga = findViewById(R.id.braga);
        buttonBraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = braga;
                moveCameraToLocation();
            }
        });
        Button buttonAlun = findViewById(R.id.alun);
        buttonAlun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = alun;
                moveCameraToLocation();
            }
        });
        Button buttonGazibu = findViewById(R.id.gazibu);
        buttonGazibu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = gazibu;
                moveCameraToLocation();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Markers
        mMap.addMarker(new MarkerOptions().position(binus).title("BINUS Bandung"));
        mMap.addMarker(new MarkerOptions().position(braga).title("Braga"));
        mMap.addMarker(new MarkerOptions().position(alun).title("Alun-Alun Kota Bandung"));
        mMap.addMarker(new MarkerOptions().position(gazibu).title("Lapangan Gazibu"));

        // Default camera location
        location = binus;
        moveCameraToLocation();
    }

    // untuk make sure location + map nya not null sebelum move camera
    private void moveCameraToLocation() {
        if (location != null && mMap != null) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 17f));
        }
    }
}