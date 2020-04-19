package com.hfad.mobiletechapp;
/**
 * @author ozgeonec
 */

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class LoginPageActivity extends AppCompatActivity {

    Button button1,button2;
    EditText username,password;

    final UserListData[] userlist = new UserListData[]{
            new UserListData("Ozge", "Ozge", android.R.drawable.star_on),
            new UserListData("Amac", "Amac", android.R.drawable.star_on),
            new UserListData("Emre", "Emre", android.R.drawable.star_on),
            new UserListData("Busra", "Busra", android.R.drawable.star_on),
            new UserListData("Kubra", "Kubra", android.R.drawable.star_on),
            new UserListData("Elcim", "Elcim", android.R.drawable.star_on),
            new UserListData("Akif", "Akif", android.R.drawable.star_on),
            new UserListData("Yekta", "Yekta", android.R.drawable.star_on),
            new UserListData("Mina", "Mina", android.R.drawable.star_on),
            new UserListData("Fatma", "Fatma", android.R.drawable.star_on),
            new UserListData("Esra", "Esra", android.R.drawable.star_on),
            new UserListData("Feyza","Feyza", android.R.drawable.star_on),
            new UserListData("Meryem","Meryem", android.R.drawable.star_on),
            new UserListData("Ahmet", "Ahmet", android.R.drawable.star_on),
            new UserListData("Buket", "Buket",android.R.drawable.star_on),
            new UserListData("Selim","Selim", android.R.drawable.star_on),
            new UserListData("Hande","Hande", android.R.drawable.star_on),
            new UserListData("Ayse","Ayse", android.R.drawable.star_on),
            new UserListData("Selin", "Selin", android.R.drawable.star_on),
            new UserListData("Osman","Osman", android.R.drawable.star_on),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        button1 = (Button)findViewById(R.id.login);
        button2 = (Button)findViewById(R.id.clear);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        //Login işlemi
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int controlVar = 0;

                for(int i =0; i< userlist.length; i++) {
                    if ((userlist[i].getUsername().trim().equals(username.getText().toString().trim())) &&
                            (userlist[i].getPassword().trim().equals(password.getText().toString().trim()))) {
                        controlVar = 1;
                    }
                }
                if(controlVar == 1){
                    Toast.makeText(getApplicationContext(),
                                "Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginPageActivity.this, MenuPageActivity.class);
                    LoginPageActivity.this.startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Clear işlemi
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                password.setText("");
            }
        });
    }

}
