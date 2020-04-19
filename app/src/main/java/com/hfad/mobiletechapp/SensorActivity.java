package com.hfad.mobiletechapp;
/**
 * @author ozgeonec
 */

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class SensorActivity extends AppCompatActivity {
    TextView tv1=null;
    TextView tv;
    RelativeLayout bg;
    private SensorManager mSensorManager;
    SensorEventListener listener;
    Sensor light;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_page);

        tv=(TextView)findViewById(R.id.textView);
        tv1 = (TextView) findViewById(R.id.textView2);
        bg=(RelativeLayout)findViewById(R.id.bg);
        tv1.setVisibility(View.GONE);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mList= mSensorManager.getSensorList(Sensor.TYPE_ALL);
        light = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        for (int i = 1; i < mList.size(); i++) {
            tv1.setVisibility(View.VISIBLE);
            tv1.append("\n" + mList.get(i).getName() + "\n" + mList.get(i).getVendor() + "\n" + mList.get(i).getVersion());
        }
        listener = new SensorEventListener() {

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                Toast.makeText(SensorActivity.this, "changed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSensorChanged(SensorEvent event) {
                int grayShade = (int) event.values[0];
                if (grayShade > 255) grayShade = 255;


                tv.setTextColor(Color.rgb(255 - grayShade, 255 - grayShade, 255 - grayShade));
                tv.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
                tv1.setTextColor(Color.rgb(255 - grayShade, 255 - grayShade, 255 - grayShade));
                tv1.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
                bg.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
            }
        };

        mSensorManager.registerListener(listener, light, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(listener, light);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
