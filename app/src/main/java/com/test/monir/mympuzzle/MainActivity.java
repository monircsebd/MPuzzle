package com.test.monir.mympuzzle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {


    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        Bundle extras1 = getIntent().getExtras();
        if (extras1 != null) {
            value = extras1.getString("new_variable_p");
        }




        Log.e(value, "nazran");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (value.equals("princess")) {

                    Intent intent = new Intent(MainActivity.this, PrincessThree.class);

                    startActivity(intent);
                } else if (value.equals("bird")) {

                    Intent intent = new Intent(MainActivity.this, BirdThree.class);

                    startActivity(intent);
                } else if (value.equals("doel")) {

                    Intent intent = new Intent(MainActivity.this, DoelThree.class);

                    startActivity(intent);
                } else if (value.equals("shapla")) {

                    Intent intent = new Intent(MainActivity.this, ShaplaThree.class);

                    startActivity(intent);
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (value.equals("princess")) {
                    Intent intent = new Intent(MainActivity.this, ImageViewFour.class);

                    startActivity(intent);
                } else if (value.equals("bird")) {

                    Intent intent = new Intent(MainActivity.this, BirdFour.class);

                    startActivity(intent);
                } else if (value.equals("doel")) {

                    Intent intent = new Intent(MainActivity.this, DoelFour.class);
                    startActivity(intent);
                } else if (value.equals("shapla")) {

                    Intent intent = new Intent(MainActivity.this, ShaplaFour.class);

                    startActivity(intent);
                }

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
            Toast.makeText(getApplicationContext(), "Setings ", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
