package com.example.simpleclicker;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

    PlayerStatistic playerStats = new PlayerStatistic();
    PlayerMoney playerMoney = new PlayerMoney();
    Player player = new Player();
    MonsterCharacter monster = new MonsterCharacter();




    public void checkLocation (){
        String locName = "";
        String mobName = "";
        PlayerStatistic playerStatistic = new PlayerStatistic();
        if (playerStatistic.getMonsterKills() <= 5) {
            locName = "Тропа Гоблинов";
        } else if (playerStatistic.getMonsterKills() >5) {
            locName = "Пещера Гоблинов";
        }
        if (playerStatistic.getMonsterKills() <= 5) {
            mobName = "Гоблин";
            imgBtnMonster.setImageResource(R.drawable.dpsman001);
        } else if (playerStatistic.getMonsterKills() > 5) {
            mobName = "Легендарный гоблин";
            imgBtnMonster.setImageResource(R.drawable.dpsman002);
    }
        textMonsterName.setText(mobName);
        textLocationName.setText(locName);

    }

    public void clickerBattle(){
        String message = "";
        String stats = "";
        playerStats.setClickCountOveral(playerStats.getClickCountOveral()+ 1);
        if (monster.getMonsterHealthNow() > 0){
            monster.setMonsterHealthNow(monster.getMonsterHealthNow() - player.clickDamage);
            message = monster.getMonsterHealthNow() + " HP" + " / " + monster.getMonsterHealth() + " HP";

        } else if (monster.getMonsterHealthNow() <= 0){
            playerStats.setMonsterKills(playerStats.getMonsterKills() + 1);
            playerStats.setMonsterKillsOveral(playerStats.getMonsterKillsOveral() + 1);
            playerStats.setLvlFinished(playerStats.getLvlFinished() + 1);

            player.setPlayerExp(player.getPlayerExp() + (playerStats.getMonsterKills() * 10));

            playerMoney.getMoneyFromKill(playerStats.getMonsterKills());

            monster.setMonsterLvl(monster.getMonsterLvl() + 1);
            monster.newMonster();
            monster.setMonsterHealthNow(monster.getMonsterHealth());
            message = monster.getMonsterHealthNow() + " HP" + " / " + monster.getMonsterHealth() + " HP";
        }
        stats = playerStats.getMonsterKills() + " сбито ДПСов/" + "  " + playerStats.getClickCountOveral() +
                " кликов/" + "  " + playerStats.getLvlFinished() + " уровень/  " +  playerMoney.getMoney() + "  money/";
        textMonsterHealth.setText(message);
        textLocationProgress.setText(stats);
    }
    /*private void postProgress(int monsterHealth) {
        String strProgress = String.valueOf(monsterHealth) + " %";
        progressBarHP.setProgress(monsterHealth);

        if (monsterHealth == 0) {
            progressBarHP.setSecondaryProgress(0);
        } else {
            progressBarHP.setSecondaryProgress(monsterHealth);
        }
        textMonsterHealth.setText(strProgress);

    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //imageViewBackgroundMain = (ImageView) findViewById(R.id.imageViewBackgroundMain);
        imgBtnMonster = (ImageButton) findViewById(R.id.imgBtnMonster);

        textLocationName = (TextView) findViewById(R.id.textLocationName);
        textLocationProgress = (TextView) findViewById(R.id.textLocationProgress);
        textMonsterName = (TextView) findViewById(R.id.textMonsterName);
        textMonsterHealth = (TextView) findViewById(R.id.textMonsterHealth);

        btnMenu01 = (Button) findViewById(R.id.btnMenu01);
        btnMenu02 = (Button) findViewById(R.id.btnMenu02);
        btnMenu03 = (Button) findViewById(R.id.btnMenu03);
        btnMenu04 = (Button) findViewById(R.id.btnMenu04);


        ImageView imageView = findViewById(R.id.imageViewBackgroundMain);
        imageView.setImageResource(R.drawable.imgpiskar);

        imgBtnMonster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLocation ();
                clickerBattle();
            }
        });


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
class PlayerMoney {
    protected static int money;


    /*public PlayerMoney(int money) {
        this.money = money;
    }*/
    public void getMoneyFromKill(int kills){
        money  += (45 * kills);
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "PlayerMoney{" +
                "money=" + money +
                '}';
    }
}
class PlayerStatistic {
    private int monsterKills;
    private int monsterKillsOveral;
    private int clickCountOveral;
    private int lvlFinished;


    /*public PlayerStatistic(int monsterKills, int monsterKillsOveral, int clickCountOveral, int lvlFinished) {
        this.monsterKills = monsterKills;
        this.monsterKillsOveral = monsterKillsOveral;
        this.clickCountOveral = clickCountOveral;
        this.lvlFinished = lvlFinished;
    }*/

    public int getMonsterKills() {
        return monsterKills;
    }

    public void setMonsterKills(int monsterKills) {
        this.monsterKills = monsterKills;
    }

    public int getMonsterKillsOveral() {
        return monsterKillsOveral;
    }

    public void setMonsterKillsOveral(int monsterKillsOveral) {
        this.monsterKillsOveral = monsterKillsOveral;
    }

    public int getClickCountOveral() {
        return clickCountOveral;
    }

    public void setClickCountOveral(int clickCountOveral) {
        this.clickCountOveral = clickCountOveral;
    }

    public int getLvlFinished() {
        return lvlFinished;
    }

    public void setLvlFinished(int lvlFinished) {
        this.lvlFinished = lvlFinished;
    }
}
class Player {
    public int playerLvl;
    public int playerExp;

    public int clickDamage = 1 ;

    public int getPlayerLvl() {
        return playerLvl;
    }

    public void setPlayerLvl(int playerLvl) {
        this.playerLvl = playerLvl;
    }

    public int getPlayerExp() {
        return playerExp;
    }

    public void setPlayerExp(int playerExp) {
        this.playerExp = playerExp;
    }

    public int getClickDamage() {
        return clickDamage;
    }

    public void setClickDamage(int clickDamage) {
        this.clickDamage = clickDamage;
    }
}
class MonsterCharacter {
    public int monsterHealth = 10;
    public int monsterHealthNow = 10;
    private int id;
    private String monsterName;

    public int getMonsterHealthNow() {
        return monsterHealthNow;
    }

    public void setMonsterHealthNow(int monsterHealthNow) {
        this.monsterHealthNow = monsterHealthNow;
    }

    public int getMonsterLvl() {
        return monsterLvl;
    }

    public void setMonsterLvl(int monsterLvl) {
        this.monsterLvl = monsterLvl;
    }

    private  int monsterLvl = 1;

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
    public int newMonster () {
        monsterHealth = monsterLvl * 10;
        return monsterHealth;
    }
    public int newMonsterHealthNow () {
        monsterHealthNow = monsterHealth;
        return monsterHealthNow;
    }
}
