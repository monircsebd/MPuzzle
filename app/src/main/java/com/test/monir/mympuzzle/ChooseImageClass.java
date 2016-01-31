package com.test.monir.mympuzzle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class ChooseImageClass extends Activity  implements  View.OnClickListener{

    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image_class);

        ImageView princess = (ImageView) findViewById(R.id.princess);
        ImageView bird = (ImageView) findViewById(R.id.bird);
        ImageView doel = (ImageView) findViewById(R.id.doel);
        ImageView shapla = (ImageView) findViewById(R.id.shapla);


        princess.setOnClickListener(this);
        bird.setOnClickListener(this);
        doel.setOnClickListener(this);
        shapla.setOnClickListener(this);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_image_class, menu);
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

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.princess)
        {
            Intent intent = new Intent(ChooseImageClass.this,MainActivity.class);
            intent.putExtra("new_variable_p","princess");
            //intent.putExtra("Signal", value);

            startActivity(intent);
        }

        else if(v.getId()==R.id.bird)
        {
            Intent intent = new Intent(ChooseImageClass.this,MainActivity.class);
            intent.putExtra("new_variable_p","bird");
            //intent.putExtra("Signal", value);
            startActivity(intent);

        }
        else if(v.getId()==R.id.doel)
        {
            Intent intent = new Intent(ChooseImageClass.this,MainActivity.class);
            intent.putExtra("new_variable_p","doel");
            //intent.putExtra("Signal", value);
            startActivity(intent);

        }
        else if(v.getId()==R.id.shapla)
        {
            Intent intent = new Intent(ChooseImageClass.this,MainActivity.class);
            intent.putExtra("new_variable_p","shapla");
            //intent.putExtra("Signal", value);
            startActivity(intent);


        }


    }
}
