package com.test.monir.mympuzzle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class BestScore extends Activity {

    int value1;
    int value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_score);

        final SharedPreferences prefs = getSharedPreferences("Three", MODE_PRIVATE);
        value1 = prefs.getInt("ThreeHighScore", 999);

        final SharedPreferences pref = getSharedPreferences("Four", MODE_PRIVATE);
        value2 = pref.getInt("FourHighScore", 999);

        //Log.e(getClass().getName()+" 26", "score: "+value1);
        TextView EasyLevel = (TextView) findViewById(R.id.easyLevel);
        TextView HardLevel = (TextView) findViewById(R.id.hardLevel);

       EasyLevel.setText(""+value1);
       HardLevel.setText(""+value2);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_best_score, menu);
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
