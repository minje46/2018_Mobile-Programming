package com.example.forlecture_lbs;

import android.Manifest;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

// Notification example.

public class MainActivity extends AppCompatActivity {
   int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.displaynotif);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
    }

    protected void displayNotification(){
        Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID",notificationID);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("My Notification").setContentText("Reminder : Meeting starts in 5 minutes");

        builder.setContentIntent(pendingIntent);
        builder.setVibrate(new long[]{100, 250, 100, 500});
        notificationManager.notify(notificationID, builder.build());
    }
}

// Gravity sensor example 2.
/*
public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private SensorManager sensorManager;
    private Sensor Gravitysensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor>arSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String result = "갯수 : "+arSensor.size() + "\n\n";

        for(Sensor s : arSensor){
            result += (" 이름 = "+s.getName()+ ",\n 형식 = "+s.getType()+",\n 제조사 = "+s.getVendor()+",\n 전원 = "+s.getPower()+",/n 해상도 = "+s.getResolution()+",\n 범위 = "+s.getMaximumRange()+"\n\n");
        }

        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(result);
    }
}
*/

// Gravity sensor example 1.
/*
public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private SensorManager sensorManager;
    private Sensor Gravitysensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView1);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Gravitysensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensorManager.registerListener(mySensorListener, Gravitysensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sensorManager.registerListener(mySensorListener, Gravitysensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(mySensorListener);
    }

    public SensorEventListener mySensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_GRAVITY){
                textView1.setText(Float.toString(event.values[0]));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
}
*/

// Google map Example.
/*
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        LatLng Seoul = new LatLng(37.56, 126.97);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(Seoul);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");

        Marker seoul = googleMap.addMarker(markerOptions);
        seoul.showInfoWindow();

        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Seoul));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
*/


// Location example.
/*
public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
            }
        });
    }

    private void startLocationService(){
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        GPSListener gpsListener = new GPSListener();
        long minTime = 10000;
        float minDistance = 0;

        try{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);

            // 위치 학인이 안되는 경우에도 최근에 확인된 위치 정보 먼저 확인.
            Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(lastLocation != null){
                Double latitude = lastLocation.getLatitude();
                Double longitude = lastLocation.getLongitude();

                textView.setText("내 위치 : "+latitude + "\n" +longitude);
                Toast.makeText(getApplicationContext(), "Last Known Location : "+"Latitude : "+latitude + "\nLongitude : "+longitude,Toast.LENGTH_SHORT).show();
            }
        } catch (SecurityException e){
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(),"위치 확인이 시작되었습니다. 로그를 확인하세요",Toast.LENGTH_SHORT).show();
    }

    private class GPSListener implements LocationListener{
        public void onLocationChanged(Location location){
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();
            String msg = "Latitude : " + latitude + "\nLongitude : "+longitude;
            Log.e("GPSListener",msg);

            textView.setText("내 위치 : "+latitude +"   "+longitude);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
*/