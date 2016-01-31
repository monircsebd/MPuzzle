package com.test.monir.mympuzzle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class FrontPage extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);


        Button NewGame = (Button) findViewById(R.id.newGame);
        Button BestScore = (Button) findViewById(R.id.bestScore);
        Button AboutUs = (Button) findViewById(R.id.aboutUs);
        Button Settings = (Button) findViewById(R.id.settings);

        Button help = (Button) findViewById(R.id.help);


        NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FrontPage.this,ChooseImageClass.class);

                startActivity(intent);
            }
        });


        help.setOnClickListener(new  View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(FrontPage.this,Help.class);
                startActivity(intent);
            }

        });

        AboutUs.setOnClickListener(new  View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(FrontPage.this,AboutUs.class);
                startActivity(intent);
            }

        });

        Settings.setOnClickListener(new  View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(FrontPage.this,Settings.class);
                startActivity(intent);
            }

        });

        BestScore.setOnClickListener(new  View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(FrontPage.this,BestScore.class);
                startActivity(intent);
            }

        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_front_page, menu);
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
