package com.idnp.samplemovement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensor1=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        AccelerationEventListener accelerationEventListener=new AccelerationEventListener();
        sensorManager.registerListener(
                accelerationEventListener,
                sensor1,
                SensorManager.SENSOR_DELAY_NORMAL);

    }

    public boolean isSensorSupported(int SENSOR_TYPE)
    {
        SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(SENSOR_TYPE);
        return sensors.size() > 0;
    }
}