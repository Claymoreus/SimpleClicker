package com.example.simpleclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FirstMenuActivity extends AppCompatActivity {

    private TextView textViewUpgrade01;
    private TextView textViewUpgrade02;
    private TextView textViewUpgrade03;
    private TextView textViewUpgrade04;
    private TextView textMoneyNow;

    private Button btnUpgrade01;
    private Button btnUpgrade02;
    private Button btnUpgrade03;
    private Button btnUpgrade04;


    PlayerUpgrade playerUpgrade = new PlayerUpgrade();

    public void getUpgraded01() {
        String message = "";
        if (playerUpgrade.getPlayerUpgrade01Cost() > PlayerMoney.money) {
            message = " Not money for buy! ";
            textViewUpgrade01.setText(message);
        } else {
            PlayerMoney.money -= playerUpgrade.getPlayerUpgrade01Cost();
            playerUpgrade.setPlayerUpgrade01Lvl(playerUpgrade.getPlayerUpgrade01Lvl() + 1);
            playerUpgrade.setUpgrade01Multiply(playerUpgrade.getPlayerUpgrade01Lvl()*3);
        }
        message = "Upgrade weapon: lvl:" + playerUpgrade.getPlayerUpgrade01Lvl() + " -- next lvl:" + (playerUpgrade.getPlayerUpgrade01Lvl() + 1)
                + " /Next Upgrade " + playerUpgrade.getPlayerUpgrade01Cost() + "Rub" ;
        textViewUpgrade01.setText(message);
    }

    /*public void getUpgraded02() {
        playerUpgradeCost02 = (playerUpgradeLvl02 * 1) * playerUpgradeLvl02;
        String message = "";
        if (playerUpgradeCost02 > mainActivity.playerMoney) {
            message = " Not money for buy! ";
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
            message = " Not money for buy! ";
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
            message = " Not  money for buy! ";
            textViewUpgrade04.setText(message);
        } else {
            mainActivity.playerMoney -= playerUpgradeCost04;
            playerUpgradeLvl04++;
        }
        message = "Upgrade ammo: lvl:" + playerUpgradeLvl04 + " -- next lvl:" + (playerUpgradeLvl04 + 1);
        textViewUpgrade04.setText(message);
    }*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmenu);

        textViewUpgrade01 = (TextView) findViewById(R.id.textViewUpgrade01);
        textViewUpgrade02 = (TextView) findViewById(R.id.textViewUpgrade02);
        textViewUpgrade03 = (TextView) findViewById(R.id.textViewUpgrade03);
        textViewUpgrade04 = (TextView) findViewById(R.id.textViewUpgrade04);
        textMoneyNow = (TextView) findViewById(R.id.textMoneyNow);

        btnUpgrade01 = (Button) findViewById(R.id.btnUpgrade01);
        btnUpgrade02 = (Button) findViewById(R.id.btnUpgrade02);
        btnUpgrade03 = (Button) findViewById(R.id.btnUpgrade03);
        btnUpgrade04 = (Button) findViewById(R.id.btnUpgrade04);


        String MoneyNow = "Money now : " + PlayerMoney.money;
        textMoneyNow.setText(MoneyNow);

        btnUpgrade01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUpgraded01();
                String message = "";
                message = "Upgrade weapon: lvl:" + playerUpgrade.getPlayerUpgrade01Lvl() + " -- next lvl:" + (playerUpgrade.getPlayerUpgrade01Lvl() + 1)
                        + " /Next Upgrade " + playerUpgrade.getPlayerUpgrade01Cost() + "Rub" ;
                textViewUpgrade01.setText(message);
            }
        });
        /*btnUpgrade02.setOnClickListener(new View.OnClickListener() {
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
        });*/

    }
}
class PlayerUpgrade  {
    private int playerUpgrade01Lvl =1;
    private int playerUpgrade01Cost = playerUpgrade01Lvl * 75;
    private int upgrade01Multiply;

    public int getUpgrade01Multiply() {
        return upgrade01Multiply;
    }

    public void setUpgrade01Multiply(int upgrade01Multiply) {
        this.upgrade01Multiply = upgrade01Multiply;
    }





    public int getPlayerUpgrade01Lvl() {
        return playerUpgrade01Lvl;
    }

    public void setPlayerUpgrade01Lvl(int playerUpgrade01Lvl) {
        this.playerUpgrade01Lvl = playerUpgrade01Lvl;
    }

    public int getPlayerUpgrade01Cost() {
        return playerUpgrade01Cost;
    }

    public void setPlayerUpgrade01Cost(int playerUpgrade01Cost) {
        this.playerUpgrade01Cost = playerUpgrade01Cost;
    }

}