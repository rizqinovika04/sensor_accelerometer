package dev accelerometer_3axis;
 
import android.app.Activity;
import android.os.Bundle;
import android.hardware.Sensor; // memanggil funsi API sensor di android
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
 
public class accelerometer_3axis extends Activity implements SensorEventListener {
private SensorManager sensorManager;
TextView xCoor; // deklarasikan X axis object
TextView yCoor; // deklarasikan Y axis object
TextView zCoor; // deklarasikan Z axis object
/** Called when the activity is first created. */
 
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
 
xCoor=(TextView)findViewById(R.id.xcoor); // buat X axis object
yCoor=(TextView)findViewById(R.id.ycoor); // buat Y axis object
zCoor=(TextView)findViewById(R.id.zcoor); // buat Z axis object
 
sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
// menambahkan listener. Listener untuk class ini adalah accelerometer_3axis
sensorManager.registerListener(this,
sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
SensorManager.SENSOR_DELAY_NORMAL); // fungsi api yang dipakai untuk perubahan screen orientation
}
 
public void onAccuracyChanged(Sensor sensor,int accuracy){
 
}
 
public void onSensorChanged(SensorEvent event){
 
// cek jenis sensor
if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
 
// tetapkan directions
float x=event.values[0];
float y=event.values[1];
float z=event.values[2];
 
xCoor.setText("X: "+x);
yCoor.setText("Y: "+y);
zCoor.setText("Z: "+z);
}
}
}
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="dev.andykamt.com"
        android:versionCode="1"
        android:versionName="1.0">
<uses-sdk android:minSdkVersion="8" />
<uses-permission android:name="android.permission.INTERNET" />

<application android:icon="@drawable/icon" android:label="@string/app_name" android:debuggable="false">
<activity android:name=".accelerometer_3axis"
        android:label="@string/app_name">
<intent-filter>
<action android:name="android.intent.action.MAIN" />
<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
</activity>

</application>
</manifest>
