//Alicia Windsor - 1803667

package com.example.user;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UserLocationMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationDatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_user_location_map);

        myDb = new LocationDatabaseHelper(this); //code calls constructor & executes that code which creates database + table

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button cntBtn = findViewById(R.id.cntBtn);

        cntBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);
                finish();

            }
        });

        addData();
        updateData();

    }

    public void updateData (){ //Below is the updated database values

        myDb.updateData("2", "Macmillian Cancer Support", 51.507567, -0.123737);
        myDb.updateData("3", "Royal British Legion", 51.532155, -0.450592);
        myDb.updateData("4", "Cancer Research UK", 51.507567, -0.417572);
        //myDb.updateData("5", "British Red Cross", 51.533306, -0.474019);

    }

    public void addData(){

        //The below are Temporary charities I just got from google, ill update the database once I get the actual list of charities.

        myDb.insertData("1", "British Heart Foundation", 51.545166, -0.477649);
        myDb.insertData("2", "Oxfam", 51.54734, -0.479673);
        myDb.insertData("3", "Trinity Homeless Projects", 51.547807, -0.47984);
        myDb.insertData("4", "Hillingdon Foodbank", 51.54481, -0.482442);
        myDb.insertData("5", "British Red Cross", 51.533306, -0.474019);

    }

    public void noneNearby(){

        Toast toast = Toast.makeText(getApplicationContext(), "Sorry, No Charities Nearby", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double varLat, varLong;
        String charName;
        int count = 0;

        double userLat = 51.546151;
        double userLong = -0.479296;

        Cursor res = myDb.getAllData();

        //Add a Marker for each charity in the database

        while  (res.moveToNext()){

            charName = res.getString(1);
            varLat = res.getDouble(2);
            varLong = res.getDouble(3);

            // if statement to only show markers for charities near blue marker (user), if none nearby display message to inform the user.

          if (varLat > (userLat - 0.03) && varLat < (userLat + 0.1)||varLong > (userLong - 0.1) && varLong < (userLong + 0.01)) {

                  LatLng charities = new LatLng(varLat, varLong);

                  mMap.addMarker(new MarkerOptions()
                          .position(charities)
                          .title(charName)
                          .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                  count ++;

            }else{

                    if (count == 0){
                        noneNearby();}
                    }
        }

        //TODO: Get user's current location

        //Marker for user's current location. Currently hard coded to Uxbridge.

        LatLng user = new LatLng(userLat, userLong);

        mMap.addMarker(new MarkerOptions()
                .position(user)
                .title("Your location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        googleMap.animateCamera(CameraUpdateFactory.newLatLng(user));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(user,14));
    }
}
