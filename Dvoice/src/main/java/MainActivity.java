package com.example.android.dvoice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    CardView cardViewopen;
    CardView cardViewClose;
    CardView cardViewAccueil;
    CardView cardViewCabine;
    CardView cardViewRayon;
    CardView cardViewEvcuation;

    int number = 0;
    int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        change();
        then();

        if (number == 150 || number > 150 || clicks == 300 || clicks > 300) {
            Intent loginintent = new Intent(MainActivity.this,login_activity.class);
            getIntent().putExtra("value", number);
            startActivity(loginintent);
            finish();
        }

        cardViewopen = (CardView)findViewById(R.id.openCard);
        cardViewopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openIntent = new Intent(MainActivity.this,OpenActivity.class);
                startActivity(openIntent);
            }
        });

        cardViewClose = (CardView)findViewById(R.id.closeCard);
        cardViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number += 1;

                //Save clicks
                SharedPreferences sharedPreferences = getSharedPreferences("clicks", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("score",number);
                editor.commit();

                if (number < 150){

                    Intent closeIntent = new Intent(MainActivity.this,CloseActivity.class);
                    startActivity(closeIntent);

                }else if (number == 150 || number >= 150) {
                    Intent loginintent = new Intent(MainActivity.this,login_activity.class);
                    startActivity(loginintent);
                    number = 0;
                    finish();
                }
            }
        });

        cardViewAccueil = (CardView)findViewById(R.id.accueilCard);
        cardViewAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicks += 1;

                //Save clicks
                SharedPreferences sharedPreferencese = getSharedPreferences("cliques", Context.MODE_PRIVATE);
                SharedPreferences.Editor editore = sharedPreferencese.edit();
                editore.putInt("item",clicks);
                editore.commit();

                if (clicks < 300){

                    Intent accueilIntent = new Intent(MainActivity.this,AccueilActivity.class);
                    startActivity(accueilIntent);

                }else if (clicks == 300 || clicks >= 300) {
                    Intent loginintent = new Intent(MainActivity.this,login_activity.class);
                    startActivity(loginintent);
                    clicks = 0;
                    finish();
                }
            }
        });

        cardViewCabine = (CardView)findViewById(R.id.cabineCard);
        cardViewCabine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cabineIntent = new Intent(MainActivity.this,CabineActivity.class);
                startActivity(cabineIntent);
            }
        });


        cardViewRayon = (CardView)findViewById(R.id.rayonCard);
        cardViewRayon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number += 1;

                //Save clicks
                //SharedPreferences sharedPreferences = getSharedPreferences("clicks", Context.MODE_PRIVATE);
               // SharedPreferences.Editor editor = sharedPreferences.edit();
                //editor.putInt("score",number);
                //editor.commit();

                //if (number < 31){

                Intent rayonIntent = new Intent(MainActivity.this,RayonActivity.class);
                startActivity(rayonIntent);

                //}else if (number == 31 || number >= 31) {
                    //Intent loginintent = new Intent(MainActivity.this,login_activity.class);
                    //startActivity(loginintent);
                  //  number = 0;
                   //finish();
                }
            });

        cardViewEvcuation = (CardView)findViewById(R.id.evacuationCard);
        cardViewEvcuation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent evacuationIntent = new Intent(MainActivity.this,EvacuationActivity.class);
                startActivity(evacuationIntent);
            }
        });
    }

    public void change() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("clicks",Context.MODE_PRIVATE);
        number = sharedPreferences.getInt("score",0);
        //SharedPreferences.Editor peditor = sharedPreferences.edit();
        //peditor.putInt("score",0).apply();
    }

    public void then() {
        SharedPreferences sharedPreferencese = this.getSharedPreferences("cliques",Context.MODE_PRIVATE);
        clicks = sharedPreferencese.getInt("item",0);
        //SharedPreferences.Editor peditor = sharedPreferences.edit();
        //peditor.putInt("score",0).apply();
    }
}