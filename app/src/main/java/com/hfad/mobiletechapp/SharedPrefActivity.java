package com.hfad.mobiletechapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author ozgeonec
 */
public class SharedPrefActivity extends AppCompatActivity {


    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button b1,b2;
    //RadioGroup radioGenderGroup;
    RadioButton gndr1, gndr2;
    Switch mode;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String NameKey = "nameKey";
    public static final String PasswordKEy  = "passwordKey";
    public static final String EmailKey = "emailKey";
    public static final String AgeKey = "ageKey";
    public static final String HeightKey = "heightKey";
    public static final String WeightKey = "weightKey";
    public static final String Gender1Key = "gender1Key";
    public static final String Gender2Key = "gender2Key";
    public static final String ModeKey = "modeKey";


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpref_page);

        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);
        ed5 = (EditText) findViewById(R.id.height);
        ed6 = (EditText) findViewById(R.id.weight);
        gndr1 = (RadioButton) findViewById(R.id.gender1);
        gndr2 = (RadioButton) findViewById(R.id.gender2);
        //radioGenderGroup = (RadioGroup) findViewById(R.id.radioGender);
        mode = (Switch) findViewById(R.id.mode);
        b1 = (Button)findViewById(R.id.button);
        b2 =(Button)findViewById(R.id.clear);


        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                String name = ed1.getText().toString();
                String password = ed2.getText().toString();
                String email = ed3.getText().toString();
                String age = ed4.getText().toString();
                String height = ed5.getText().toString();
                String weight = ed6.getText().toString();

                editor.putString(NameKey, name);
                editor.putString(PasswordKEy, password);
                editor.putString(EmailKey, email);
                editor.putString(AgeKey, age);
                editor.putInt(HeightKey, Integer.parseInt(height));
                editor.putInt(WeightKey, Integer.parseInt(weight));
                editor.putBoolean(Gender1Key, gndr1.isChecked());
                editor.putBoolean(Gender2Key, gndr2.isChecked());
                editor.putBoolean(ModeKey, mode.isChecked());
                boolean savedOrNot =editor.commit();
                if(savedOrNot==true){
                    Toast.makeText(SharedPrefActivity.this, "Data Saved", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SharedPrefActivity.this, "failed", Toast.LENGTH_LONG).show();
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed5.setText("");
                ed6.setText("");
                gndr1.setChecked(false);
                gndr2.setChecked(false);
                mode.setChecked(false);

            }
        });

        /*b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedpreferences.contains(Name)) {
                    ed1.setText(sharedpreferences.getString(Name, ""));
                }
                if (sharedpreferences.contains(Password)) {
                    ed2.setText(sharedpreferences.getString(Password, ""));
                }
                if (sharedpreferences.contains(Email)) {
                    ed3.setText(sharedpreferences.getString(Email, ""));
                }
                if (sharedpreferences.contains(Age)) {
                    ed4.setText(sharedpreferences.getString(Age, ""));
                }
                if (sharedpreferences.contains(Height)) {
                    ed5.setText(sharedpreferences.getString(Height, ""));
                }
                if (sharedpreferences.contains(Weight)) {
                    ed6.setText(sharedpreferences.getString(Weight, ""));
                }
                if (sharedpreferences.contains(Gender1)) {
                    gndr1.setText(sharedpreferences.getString(Gender1, ""));
                }
                if (sharedpreferences.contains(Gender2)) {
                    gndr2.setText(sharedpreferences.getString(Gender2, ""));
                }
                if (sharedpreferences.contains(Mode)) {
                    mode.setText(sharedpreferences.getString(Mode, ""));
                }

            }
        });*/
    }


    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
