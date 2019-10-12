package com.example.simpleclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class FirstMenuActivity extends AppCompatActivity {

    private TextView textViewUpgrade01;
    private TextView textViewUpgrade02;
    private TextView textViewUpgrade03;
    private TextView textViewUpgrade04;


    private Button btnUpgrade01;
    private Button btnUpgrade02;
    private Button btnUpgrade03;
    private Button btnUpgrade04;

    public int playerUpgradeLvl01;  // Weapon
    public int playerUpgradeLvl02;   //Armor
    public int playerUpgradeLvl03;   //Speed
    public int playerUpgradeLvl04;   //Ammo
    private int playerUpgradeCost01;
    private int playerUpgradeCost02;
    private int playerUpgradeCost03;
    private int playerUpgradeCost04;

    MainActivity mainActivity = new MainActivity();

    public void getUpgraded01() {
        playerUpgradeCost01 = (playerUpgradeLvl01 * 1) * playerUpgradeLvl01;
        String message = "";
        if (playerUpgradeCost01 > mainActivity.playerMoney) {
            message = " Not enogth money for buy! ";
            textViewUpgrade01.setText(message);
        } else {
            mainActivity.playerMoney -= playerUpgradeCost01;
            playerUpgradeLvl01++;
        }
        message = "Upgrade weapon: lvl:" + playerUpgradeLvl01 + " -- next lvl:" + (playerUpgradeLvl01 + 1);
        textViewUpgrade01.setText(message);
    }
    public void getUpgraded02() {
        playerUpgradeCost02 = (playerUpgradeLvl02 * 1) * playerUpgradeLvl02;
        String message = "";
        if (playerUpgradeCost02 > mainActivity.playerMoney) {
            message = " Not enogth money for buy! ";
            textViewUpgrade02.setText(message);
        } else {
            mainActivity.playerMoney -= playerUpgradeCost02;
            playerUpgradeLvl02++;
        }
        message = "Upgrade armor: lvl:" + playerUpgradeLvl02 + " -- next lvl:" + (playerUpgradeLvl02 + 1);
        textViewUpgrade02.setText(message);
    }
    public void getUpgraded03() {
        playerUpgradeCost03 = (playerUpgradeLvl03 * 1) * playerUpgradeLvl03;
        String message = "";
        if (playerUpgradeCost03 > mainActivity.playerMoney) {
            message = " Not enogth money for buy! ";
            textViewUpgrade03.setText(message);
        } else {
            mainActivity.playerMoney -= playerUpgradeCost03;
            playerUpgradeLvl03++;
        }
        message = "Upgrade speed: lvl:" + playerUpgradeLvl03 + " -- next lvl:" + (playerUpgradeLvl03 + 1);
        textViewUpgrade03.setText(message);
    }
    public void getUpgraded04() {
        playerUpgradeCost04 = (playerUpgradeLvl04 * 1) * playerUpgradeLvl04;
        String message = "";
        if (playerUpgradeCost04 > mainActivity.playerMoney) {
            message = " Not enogth money for buy! ";
            textViewUpgrade04.setText(message);
        } else {
            mainActivity.playerMoney -= playerUpgradeCost04;
            playerUpgradeLvl04++;
        }
        message = "Upgrade ammo: lvl:" + playerUpgradeLvl04 + " -- next lvl:" + (playerUpgradeLvl04 + 1);
        textViewUpgrade04.setText(message);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmenu);

        textViewUpgrade01 = (TextView) findViewById(R.id.textViewUpgrade01);
        textViewUpgrade02 = (TextView) findViewById(R.id.textViewUpgrade02);
        textViewUpgrade03 = (TextView) findViewById(R.id.textViewUpgrade03);
        textViewUpgrade04 = (TextView) findViewById(R.id.textViewUpgrade04);

        btnUpgrade01 = (Button) findViewById(R.id.btnMenu01);
        btnUpgrade02 = (Button) findViewById(R.id.btnMenu02);
        btnUpgrade03 = (Button) findViewById(R.id.btnMenu03);
        btnUpgrade04 = (Button) findViewById(R.id.btnMenu04);


        btnUpgrade01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUpgraded01();
            }
        });
        btnUpgrade02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUpgraded02();
            }
        });
        btnUpgrade03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUpgraded03();
            }
        });
        btnUpgrade04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUpgraded04();
            }
        });

    }



}
