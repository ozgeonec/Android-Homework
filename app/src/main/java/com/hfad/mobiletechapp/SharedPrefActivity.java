package com.hfad.mobiletechapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author ozgeonec
 */
public class SharedPrefActivity extends AppCompatActivity {


    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button b1,b2,b3;
    RadioGroup radioGenderGroup;
    RadioButton gndr1, gndr2;
    Switch mode;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Password = "passwordKey";
    public static final String Email = "emailKey";
    public static final String Age = "ageKey";
    public static final String Height = "heightKey";
    public static final String Weight = "weightKey";
    public static final String Gender1 = "gender1Key";
    public static final String Gender2 = "gender2Key";
    public static final String Mode = "modeKey";


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpref_page);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed4=(EditText)findViewById(R.id.editText4);
        gndr1 = (RadioButton)findViewById(R.id.gender1);
        gndr2 = (RadioButton)findViewById(R.id.gender2);
        radioGenderGroup = (RadioGroup)findViewById(R.id.radioGender);
        mode = (Switch)findViewById(R.id.mode);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.clear);
        b3=(Button)findViewById(R.id.btnretrieve);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed1.getText().toString();
                String password = ed2.getText().toString();
                String email = ed3.getText().toString();
                String age = ed4.getText().toString();
                String height = ed5.getText().toString();
                String weight = ed6.getText().toString();



                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, name);
                editor.putString(Password, password);
                editor.putString(Email, email);
                editor.putInt(Age, Integer.parseInt(age));
                editor.putInt(Height, Integer.parseInt(height));
                editor.putInt(Weight, Integer.parseInt(weight));
                editor.putBoolean(Gender1, gndr1.isChecked());
                editor.putBoolean(Gender2, gndr2.isChecked());
                editor.putBoolean(Mode, mode.isChecked());
                editor.apply();
                Toast.makeText(SharedPrefActivity.this, "Thanks", Toast.LENGTH_LONG).show();
            }
        });

       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ed1 = (EditText) findViewById(R.id.editText);
               ed2 = (EditText) findViewById(R.id.editText2);
               ed3=(EditText)findViewById(R.id.editText3);
               ed4=(EditText)findViewById(R.id.editText4);
               ed5=(EditText)findViewById(R.id.height);
               ed6=(EditText)findViewById(R.id.weight);
               gndr1 = (RadioButton)findViewById(R.id.gender1);
               gndr2 = (RadioButton)findViewById(R.id.gender2);
               mode = (Switch)findViewById(R.id.mode);
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
       b3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ed1 = (EditText) findViewById(R.id.editText);
               ed2 = (EditText) findViewById(R.id.editText2);
               ed3=(EditText)findViewById(R.id.editText3);
               ed4=(EditText)findViewById(R.id.editText4);
               ed5=(EditText)findViewById(R.id.height);
               ed6=(EditText)findViewById(R.id.weight);
               gndr1 = (RadioButton)findViewById(R.id.gender1);
               gndr2 = (RadioButton)findViewById(R.id.gender2);
               mode = (Switch)findViewById(R.id.mode);

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
       });
    }
}
