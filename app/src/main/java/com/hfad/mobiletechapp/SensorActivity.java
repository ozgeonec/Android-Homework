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
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;



public class SensorActivity extends AppCompatActivity {

    private TextView tv1=null;
    private TextView tv;
    private RelativeLayout bg;
    private SensorManager mSensorManager;
    private SensorEventListener listener;
    private SensorEventListener listener2;
    private Sensor light;
    private Sensor accelor;
    //private int counter=0;
    private CountDownTimer timer;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_page);

        //Sensör Listesi İşlemi
        tv=(TextView)findViewById(R.id.textView);
        tv1 = (TextView) findViewById(R.id.textView2);
        bg=(RelativeLayout)findViewById(R.id.bg);


        tv1.setVisibility(View.GONE);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mList= mSensorManager.getSensorList(Sensor.TYPE_ALL);
        light = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        accelor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        for (int i = 1; i < mList.size(); i++) {
            tv1.setVisibility(View.VISIBLE);
            tv1.append("\n" + mList.get(i).getName() + "\n" + mList.get(i).getVendor() + "\n" + mList.get(i).getVersion());
        }
        if(accelor==null){
            Toast.makeText(this, "No accelerometer", Toast.LENGTH_LONG).show();
            finish();
        }
        if(light==null){
            Toast.makeText(this, "No light sensor", Toast.LENGTH_LONG).show();
            finish();
        }

        //İvme Sensörü İşlemi
        listener2 = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                    float[] vectors = new float[3];
                    vectors = event.values.clone();

                    double normalOfVectors = Math.sqrt(vectors[0] * vectors[0] + vectors[1] * vectors[1] + vectors[2] * vectors[2] );
                    //Normalize
                    vectors[0] = (float) (vectors[0] / normalOfVectors);
                    vectors[1] = (float) (vectors[1] / normalOfVectors);
                    vectors[2] = (float) (vectors[2]/ normalOfVectors);

                    int inclination = (int) Math.round(Math.toDegrees(Math.acos(vectors[2])));

                    if(inclination < 25 || inclination > 155){
                        //telefon duruyor,countdown başlıyor
                        final TextView counttime = findViewById(R.id.counttime);
                        timer = new CountDownTimer(5000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                int seconds = (int) (millisUntilFinished / 1000) %60;
                                    counttime.setText("seconds remaining: " +seconds);
                            }
                            @Override
                            public void onFinish() {
                                counttime.setText("Finished");
                                finishAffinity();
                                System.exit(0);
                            }
                        }.start();
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        mSensorManager.registerListener(listener2, accelor, SensorManager.SENSOR_DELAY_FASTEST);

        //Işık sensörü İşlemi
        listener = new SensorEventListener() {

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }

            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.sensor.getType() == Sensor.TYPE_LIGHT){
                    int grayShade = (int) event.values[0];
                    if (grayShade > 255) grayShade = 255;


                    tv.setTextColor(Color.rgb(255 - grayShade, 255 - grayShade, 255 - grayShade));
                    tv.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
                    tv1.setTextColor(Color.rgb(255 - grayShade, 255 - grayShade, 255 - grayShade));
                    tv1.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
                    bg.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
                }

            }
        };
        mSensorManager.registerListener(listener, light, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onResume(){
        super.onResume();
        mSensorManager.registerListener(listener2, accelor,SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(listener, light, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(listener, light);
        mSensorManager.unregisterListener(listener2, accelor);
    }

}
