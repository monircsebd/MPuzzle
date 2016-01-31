package com.test.monir.mympuzzle;


        import android.app.Activity;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.media.MediaPlayer;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CompoundButton;
        import android.widget.Switch;
        import android.widget.TextView;
        import android.widget.Toast;


public class Settings extends Activity {


    private Switch mySwitch;
    private int flag,a;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        mySwitch = (Switch) findViewById(R.id.mySwitch);



        final SharedPreferences prefs = getSharedPreferences("monir", Settings.this.MODE_PRIVATE);
        flag = prefs.getInt("gemeSound", 999);

        if(flag==0)
        {
            mySwitch.setChecked(false);
        }

        else if(flag==1)
        {
            mySwitch.setChecked(true);
        }
        else
        {
            mySwitch.setChecked(false);
        }




        //attach a listener to check for changes in state
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){

                        flag = 1;



                    SharedPreferences.Editor edit = prefs.edit();
                    edit.putInt("gemeSound", flag);
                    edit.commit();


                   // Toast.makeText(getApplicationContext(), "ONNN 111", Toast.LENGTH_LONG).show();


                }else{

                    flag =0;

                    SharedPreferences.Editor edits = prefs.edit();
                    edits.putInt("gemeSound", flag);
                    edits.commit();

                  //  Toast.makeText(getApplicationContext(),"OFF 111",Toast.LENGTH_LONG).show();



                }



            }
        });



}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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

    public void Start(View view) {
    }
}

