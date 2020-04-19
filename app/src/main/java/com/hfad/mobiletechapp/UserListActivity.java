package com.hfad.mobiletechapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author ozgeonec
 */
public class UserListActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);

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

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        UserListAdapter adapter = new UserListAdapter(userlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}