package com.example.simpleclicker;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //main parametrs


    private ImageView imageViewBackgroundMain;
    private ImageButton imgBtnMonster;


    //TextView ***************************
    private TextView textLocationProgress;
    private TextView textLocationName;
    private TextView textMonsterName;
    private TextView textMonsterHealth;



    private ProgressBar progressBarHP;

    //Buttons *****************************
    private Button btnMenu01;
    private Button btnMenu02;
    private Button btnMenu03;
    private Button btnMenu04;
    //*************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewBackgroundMain = (ImageView) findViewById(R.id.imageViewBackgroundMain);
        imgBtnMonster = (ImageButton) findViewById(R.id.imgBtnMonster);

        textLocationName = (TextView) findViewById(R.id.textLocationName);
        textLocationProgress = (TextView) findViewById(R.id.textLocationProgress);
        textMonsterName = (TextView) findViewById(R.id.textMonsterName);
        textMonsterHealth = (TextView) findViewById(R.id.textMonsterHealth);

        btnMenu01 = (Button) findViewById(R.id.btnMenu01);
        btnMenu02 = (Button) findViewById(R.id.btnMenu02);
        btnMenu03 = (Button) findViewById(R.id.btnMenu03);
        btnMenu04 = (Button) findViewById(R.id.btnMenu04);



        // Menu block ************************************************************************
        btnMenu01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstMenuActivity.class);
                startActivity(intent);
            }
        });
        btnMenu02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondMenuActivity.class);
                startActivity(intent);
            }
        });
        btnMenu03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, ThirdMenuActivity.class);
                startActivity(intent);
            }
        });
        btnMenu04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourthMenuActivity.class);
                startActivity(intent);
            }
        });


        //Menu block end************************************************************************


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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