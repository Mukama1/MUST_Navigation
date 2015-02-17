package com.example.mukama.must_navigation;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {
    // GPS Location
    GPSTracker gps;
    Boolean isConnection;
    ConnectionDetector connection;
    AlertManager alert=new AlertManager();
    GoogleMapOptions options = new GoogleMapOptions();
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    //private MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //mapView=(MapView) findViewById(R.id.map);
        //mapView.setBuiltInZoomControls(true);

        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {

                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        connection=new ConnectionDetector(this);
        gps=new GPSTracker(this);
        isConnection=connection.isConnectingToInternet();
        if(!isConnection){
            alert.showAlertDialog(this,"Internet Setting","Check Internet Connection. Proceed to Settings", false);
            return;
        }
        else {
            if(gps.canGetLocation()) {
                // the methods which are being applied getLatitude and getLongitude are being used to get the current location of the user
               // mMap.getCameraPosition().zoom(13);
                // the initial zoom size will be  18.0f
                //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(gps.getLatitude(),gps.getLongitude()),13.9f));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(gps.getLatitude(),gps.getLongitude()),18.0f));
                mMap.addMarker(new MarkerOptions().position(new LatLng(gps.getLatitude(), gps.getLongitude())).title("You"));
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                mMap.getUiSettings().isZoomControlsEnabled();

               // CameraPosition cameraPosition=new CameraPosition.Builder().target(new LatLng(gps.getLatitude(), gps.getLongitude())).zoom(100).build();
            }else{
                alert.showAlertDialog(this,"GPS Setting","Please Enable Your GPS from Setting Such That We Locate Where You Are",false);
                return;
            }
        }
    }
}
