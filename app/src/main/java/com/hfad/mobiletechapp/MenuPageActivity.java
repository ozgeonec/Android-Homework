package com.hfad.mobiletechapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author ozgeonec
 */
public class MenuPageActivity extends AppCompatActivity {

    Button button3,button4,button5,button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

        button3 = (Button)findViewById(R.id.recyclerViewList);
        button4 = (Button)findViewById(R.id.emailapp);
        button5 = (Button)findViewById(R.id.sharedprefapp);
        button6 = (Button)findViewById(R.id.sensorapp);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(), UserListActivity.class);
                MenuPageActivity.this.startActivity(intent1);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MenuPageActivity.this, EmailActivity.class);
                MenuPageActivity.this.startActivity(intent2);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MenuPageActivity.this, SharedPrefActivity.class);
                MenuPageActivity.this.startActivity(intent3);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MenuPageActivity.this, SensorActivity.class);
                MenuPageActivity.this.startActivity(intent4);
            }
        });
    }

}
