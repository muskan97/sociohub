package com.example.hp.sociohub;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawer_layout);

    }


    public void next_page(View view) {

    }


    public void open_drawer(View view) {

        drawerLayout.openDrawer(Gravity.START);
    }

    public void open_facebook(View view) {

        Intent i = new Intent(MainActivity.this , Home_page.class);

        startActivity(i);
    }

    public void open_twitter(View view) {

        Intent i = new Intent(MainActivity.this , TwitterHome.class);

        startActivity(i);
    }

      public void  open_instagram(View view){

        Intent i = new Intent(MainActivity.this , SubscribeLayout.class);

        startActivity(i);

    }

    public void open_linkedin(View view) {

          Intent i = new Intent(MainActivity.this , UserProfile5.class);

          startActivity(i);
      }
}

