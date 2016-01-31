package com.test.monir.mympuzzle;



        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.SystemClock;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Random;


public class ShaplaThree extends Activity implements View.OnClickListener {

    int vx, vy, bTemp, cnt = 0, buttonNo = 0, click = 0, highScore = 9999;

    int[] x = new int[]{-1, 0, 1, 0};
    int[] y = new int[]{0, 1, 0, -1};
    int[][] b = new int[3][3];

    private long startTime = 0L;
    private Handler customHandler = new Handler();

    long timeInMilliSeconds = 0L;

    private TextView time;

    int sec;
    int min;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;


    TextView tv1;

    String value;
    int a;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapla_three);



        final SharedPreferences prefs = getSharedPreferences("monir", ShaplaThree.this.MODE_PRIVATE);
        a = prefs.getInt("gemeSound", 999);
        value=""+a;
        //Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();


        mp = MediaPlayer.create(this, R.raw.shapla);

        if(value.equals("1")) {
            mp.start();
            mp.setLooping(true);
        }



        //LinearLayout layout = (LinearLayout) findViewById(R.id.setbackground);
        //layout.setBackgroundResource(R.drawable.background);


        imageView1 = (ImageView) findViewById(R.id.one);


        imageView2 = (ImageView) findViewById(R.id.two);


        imageView3 = (ImageView) findViewById(R.id.three);


        imageView4 = (ImageView) findViewById(R.id.four);


        imageView5 = (ImageView) findViewById(R.id.five);


        imageView6 = (ImageView) findViewById(R.id.six);


        imageView7 = (ImageView) findViewById(R.id.seven);


        imageView8 = (ImageView) findViewById(R.id.eight);


        imageView9 = (ImageView) findViewById(R.id.nine);


        tv1 = (TextView) findViewById(R.id.Score);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);
        imageView8.setOnClickListener(this);
        imageView9.setOnClickListener(this);

        time = (TextView) findViewById(R.id.textView2);
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimeThread, 0);

        Random r = new Random();
        int round = r.nextInt(4 - 0) + 0;

        if (round == 0) {
            b[0][0] = 2;
            imageView1.setBackgroundResource(R.drawable.shapla_02);
            b[0][1] = 1;
            imageView2.setBackgroundResource(R.drawable.shapla_01);
            b[0][2] = 0;
            imageView3.setBackgroundResource(R.drawable.blank);
            b[1][0] = 7;
            imageView4.setBackgroundResource(R.drawable.shapla_07);
            b[1][1] = 6;
            imageView5.setBackgroundResource(R.drawable.shapla_06);
            b[1][2] = 5;
            imageView6.setBackgroundResource(R.drawable.shapla_05);
            b[2][0] = 8;
            imageView7.setBackgroundResource(R.drawable.shapla_08);
            b[2][1] = 3;
            imageView8.setBackgroundResource(R.drawable.shapla_03);
            b[2][2] = 4;
            imageView9.setBackgroundResource(R.drawable.shapla_04);
        } else if (round == 1) {
            b[0][0] = 2;
            imageView1.setBackgroundResource(R.drawable.shapla_02);
            b[0][1] = 5;
            imageView2.setBackgroundResource(R.drawable.shapla_05);
            b[0][2] = 8;
            imageView3.setBackgroundResource(R.drawable.shapla_08);
            b[1][0] = 1;
            imageView4.setBackgroundResource(R.drawable.shapla_01);
            b[1][1] = 3;
            imageView5.setBackgroundResource(R.drawable.shapla_03);
            b[1][2] = 6;
            imageView6.setBackgroundResource(R.drawable.shapla_06);
            b[2][0] = 0;
            imageView7.setBackgroundResource(R.drawable.blank);
            b[2][1] = 4;
            imageView8.setBackgroundResource(R.drawable.shapla_04);
            b[2][2] = 7;
            imageView9.setBackgroundResource(R.drawable.shapla_07);
        } else if (round == 2) {
            b[0][0] = 0;
            imageView1.setBackgroundResource(R.drawable.blank);
            b[0][1] = 8;
            imageView2.setBackgroundResource(R.drawable.shapla_08);
            b[0][2] = 1;
            imageView3.setBackgroundResource(R.drawable.shapla_01);
            b[1][0] = 4;
            imageView4.setBackgroundResource(R.drawable.shapla_04);
            b[1][1] = 6;
            imageView5.setBackgroundResource(R.drawable.shapla_06);
            b[1][2] = 3;
            imageView6.setBackgroundResource(R.drawable.shapla_03);
            b[2][0] = 2;
            imageView7.setBackgroundResource(R.drawable.shapla_02);
            b[2][1] = 7;
            imageView8.setBackgroundResource(R.drawable.shapla_07);
            b[2][2] = 5;
            imageView9.setBackgroundResource(R.drawable.shapla_05);
        } else if (round == 3) {
            b[0][0] = 5;
            imageView1.setBackgroundResource(R.drawable.shapla_05);
            b[0][1] = 4;
            imageView2.setBackgroundResource(R.drawable.shapla_04);
            b[0][2] = 6;
            imageView3.setBackgroundResource(R.drawable.shapla_06);
            b[1][0] = 8;
            imageView4.setBackgroundResource(R.drawable.shapla_08);
            b[1][1] = 0;
            imageView5.setBackgroundResource(R.drawable.blank);
            b[1][2] = 7;
            imageView6.setBackgroundResource(R.drawable.shapla_07);
            b[2][0] = 3;
            imageView7.setBackgroundResource(R.drawable.shapla_03);
            b[2][1] = 2;
            imageView8.setBackgroundResource(R.drawable.shapla_02);
            b[2][2] = 1;
            imageView9.setBackgroundResource(R.drawable.shapla_01);
        } else if (round == 4) {
            b[0][0] = 7;
            imageView1.setBackgroundResource(R.drawable.shapla_07);
            b[0][1] = 2;
            imageView2.setBackgroundResource(R.drawable.shapla_02);
            b[0][2] = 5;
            imageView3.setBackgroundResource(R.drawable.shapla_05);
            b[1][0] = 6;
            imageView4.setBackgroundResource(R.drawable.shapla_06);
            b[1][1] = 8;
            imageView5.setBackgroundResource(R.drawable.shapla_08);
            b[1][2] = 4;
            imageView6.setBackgroundResource(R.drawable.shapla_04);
            b[2][0] = 0;
            imageView7.setBackgroundResource(R.drawable.blank);
            b[2][1] = 1;
            imageView8.setBackgroundResource(R.drawable.shapla_01);
            b[2][2] = 3;
            imageView9.setBackgroundResource(R.drawable.shapla_03);
        }
    }

    public void onPause() {
        super.onPause();
        if(value.equals("1")) {
            mp.stop();
        }
        else
        {
            mp.stop();
        }

    }



    private Runnable updateTimeThread = new Runnable() {
        @Override
        public void run() {
            timeInMilliSeconds = SystemClock.uptimeMillis() - startTime;
            sec = (int) (timeInMilliSeconds / 1000);
            min = sec / 60;
            sec = sec % 60;
            time.setText(String.format("%02d", min) + ":" + String.format("%02d", sec));
            customHandler.postDelayed(this, 0);
        }
    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shapla_three, menu);
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

        if (v.getId() == R.id.one) {
            for (int i = 0; i < 4; i++) {
                vx = 0 + x[i];
                vy = 0 + y[i];
                if ((vx >= 0 && vx <= 2) && (vy >= 0 && vy <= 2)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[0][0];
                        b[0][0] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();
                        imageView1.setBackgroundResource(R.drawable.blank);


                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        } else if (v.getId() == R.id.two) {
            for (int i = 0; i < 4; i++) {
                vx = 0 + x[i];
                vy = 1 + y[i];
                if ((vx >= 0 && vx <= 2) && (vy >= 0 && vy <= 2)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[0][1];
                        b[0][1] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();

                        imageView2.setBackgroundResource(R.drawable.blank);

                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        } else if (v.getId() == R.id.three) {
            for (int i = 0; i < 4; i++) {
                vx = 0 + x[i];
                vy = 2 + y[i];
                if ((vx >= 0 && vx <= 2) && (vy >= 0 && vy <= 2)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[0][2];
                        b[0][2] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();

                        imageView3.setBackgroundResource(R.drawable.blank);

                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        } else if (v.getId() == R.id.four) {
            for (int i = 0; i < 4; i++) {
                vx = 1 + x[i];
                vy = 0 + y[i];
                if ((vx >= 0 && vx <= 2) && (vy >= 0 && vy <= 2)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[1][0];
                        b[1][0] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();

                        imageView4.setBackgroundResource(R.drawable.blank);

                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        } else if (v.getId() == R.id.five) {
            for (int i = 0; i < 4; i++) {
                vx = 1 + x[i];
                vy = 1 + y[i];
                if ((vx >= 0 && vx <= 2) && (vy >= 0 && vy <= 2)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[1][1];
                        b[1][1] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();
                        imageView5.setBackgroundResource(R.drawable.blank);

                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        } else if (v.getId() == R.id.six) {
            for (int i = 0; i < 4; i++) {
                vx = 1 + x[i];
                vy = 2 + y[i];
                if ((vx >= 0 && vx <= 2) && (vy >= 0 && vy <= 2)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[1][2];
                        b[1][2] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();

                        imageView6.setBackgroundResource(R.drawable.blank);

                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        } else if (v.getId() == R.id.seven) {
            for (int i = 0; i < 4; i++) {
                vx = 2 + x[i];
                vy = 0 + y[i];
                if ((vx >= 0 && vx <= 2) && (vy >= 0 && vy <= 2)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[2][0];
                        b[2][0] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();

                        imageView7.setBackgroundResource(R.drawable.blank);

                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        } else if (v.getId() == R.id.eight) {
            for (int i = 0; i < 4; i++) {
                vx = 2 + x[i];
                vy = 1 + y[i];
                if ((vx >= 0 && vx <= 2) && (vy >= 0 && vy <= 2)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[2][1];
                        b[2][1] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();

                        imageView8.setBackgroundResource(R.drawable.blank);


                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        } else if (v.getId() == R.id.nine) {
            for (int i = 0; i < 4; i++) {
                vx = 2 + x[i];
                vy = 2 + y[i];
                if ((vx >= 0 && vx <= 2) && (vy >= 0 && vy <= 2)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[2][2];
                        b[2][2] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();

                        imageView9.setBackgroundResource(R.drawable.blank);
                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);


                        check();
                        break;
                    }
                }
            }
        }


    }

    private void check() {

        cnt = 0;

        if (b[0][0] == 1)
            cnt++;
        if (b[0][1] == 2)
            cnt++;
        if (b[0][2] == 3)
            cnt++;

        if (b[1][0] == 4)
            cnt++;
        if (b[1][1] == 5)
            cnt++;
        if (b[1][2] == 6)
            cnt++;
        if (b[2][0] == 7)
            cnt++;
        if (b[2][1] == 8)
            cnt++;


        if (cnt == 8) {


            if(value.equals("1")) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
            }
            else
            {
                mp.stop();
            }


            int score = min * 60 + sec + click;
            final SharedPreferences prefs = getSharedPreferences("Three", ShaplaThree.this.MODE_PRIVATE);
            try {
                highScore = prefs.getInt("ThreeHighScore", 9999);
            } catch (NumberFormatException e) {
                highScore = 9999;
            }

            if (score < highScore) {
                highScore = score;

                String str = String.valueOf(highScore);
                Intent intent = new Intent(ShaplaThree.this,BestScore.class);
                intent.putExtra("ThreeBestScore",str);

                Toast.makeText(getApplicationContext(), "WoW You made Best Score: " + highScore, Toast.LENGTH_LONG).show();
                SharedPreferences.Editor edit = prefs.edit();
                edit.putInt("ThreeHighScore", highScore);
                edit.commit();
            } else {
                int value = prefs.getInt("ThreeHighScore", -1);

                String s = String.valueOf(score);

                Toast.makeText(getApplicationContext(), "Your Score is: " + s, Toast.LENGTH_LONG).show();
            }
            click = 0;

            TextView tv = (TextView) findViewById(R.id.congrats);
            ImageView im = (ImageView) findViewById(R.id.congratsImage);

            LayoutInflater layoutInflater = LayoutInflater.from(this);

            View promptView = layoutInflater.inflate(R.layout.prompts, null);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            alertDialogBuilder.setView(promptView);

            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();

                                    finish();
                                }
                            });
            AlertDialog alertD = alertDialogBuilder.create();
            alertD.show();
        }
    }


    private void set() {

        if (buttonNo == 1) {

            if (bTemp == 1) {
                imageView1.setBackgroundResource(R.drawable.shapla_01);
            } else if (bTemp == 2) {
                imageView1.setBackgroundResource(R.drawable.shapla_02);
            } else if (bTemp == 3) {
                imageView1.setBackgroundResource(R.drawable.shapla_03);
            } else if (bTemp == 4) {
                imageView1.setBackgroundResource(R.drawable.shapla_04);
            } else if (bTemp == 5) {
                imageView1.setBackgroundResource(R.drawable.shapla_05);
            } else if (bTemp == 6) {
                imageView1.setBackgroundResource(R.drawable.shapla_06);
            } else if (bTemp == 7) {
                imageView1.setBackgroundResource(R.drawable.shapla_07);

            } else if (bTemp == 8) {
                imageView1.setBackgroundResource(R.drawable.shapla_08);
            } else if (bTemp == 9) {
                imageView1.setBackgroundResource(R.drawable.blank);
            }

        } else if (buttonNo == 2) {
            if (bTemp == 1) {
                imageView2.setBackgroundResource(R.drawable.shapla_01);
            } else if (bTemp == 2)

            {
                imageView2.setBackgroundResource(R.drawable.shapla_02);
            } else if (bTemp == 3) {
                imageView2.setBackgroundResource(R.drawable.shapla_03);
            } else if (bTemp == 4) {
                imageView2.setBackgroundResource(R.drawable.shapla_04);
            } else if (bTemp == 5) {
                imageView2.setBackgroundResource(R.drawable.shapla_05);
            } else if (bTemp == 6) {
                imageView2.setBackgroundResource(R.drawable.shapla_06);
            } else if (bTemp == 7) {
                imageView2.setBackgroundResource(R.drawable.shapla_07);
            } else if (bTemp == 8) {
                imageView2.setBackgroundResource(R.drawable.shapla_08);
            } else if (bTemp == 9) {
                imageView2.setBackgroundResource(R.drawable.blank);
            }
        } else if (buttonNo == 3) {
            if (bTemp == 1) {
                imageView3.setBackgroundResource(R.drawable.shapla_01);
            } else if (bTemp == 2)

            {
                imageView3.setBackgroundResource(R.drawable.shapla_02);
            } else if (bTemp == 3) {
                imageView3.setBackgroundResource(R.drawable.shapla_03);
            } else if (bTemp == 4) {
                imageView3.setBackgroundResource(R.drawable.shapla_04);
            } else if (bTemp == 5) {
                imageView3.setBackgroundResource(R.drawable.shapla_05);
            } else if (bTemp == 6) {
                imageView3.setBackgroundResource(R.drawable.shapla_06);
            } else if (bTemp == 7) {
                imageView3.setBackgroundResource(R.drawable.shapla_07);
            } else if (bTemp == 8) {
                imageView3.setBackgroundResource(R.drawable.shapla_08);
            } else if (bTemp == 9) {
                imageView3.setBackgroundResource(R.drawable.blank);
            }

        } else if (buttonNo == 4) {
            if (bTemp == 1) {
                imageView4.setBackgroundResource(R.drawable.shapla_01);
            } else if (bTemp == 2)

            {
                imageView4.setBackgroundResource(R.drawable.shapla_02);
            } else if (bTemp == 3) {
                imageView4.setBackgroundResource(R.drawable.shapla_03);
            } else if (bTemp == 4) {
                imageView4.setBackgroundResource(R.drawable.shapla_04);
            } else if (bTemp == 5) {
                imageView4.setBackgroundResource(R.drawable.shapla_05);
            } else if (bTemp == 6) {
                imageView4.setBackgroundResource(R.drawable.shapla_06);
            } else if (bTemp == 7) {
                imageView4.setBackgroundResource(R.drawable.shapla_07);
            } else if (bTemp == 8) {
                imageView4.setBackgroundResource(R.drawable.shapla_08);
            } else if (bTemp == 9) {
                imageView4.setBackgroundResource(R.drawable.blank);
            }

        } else if (buttonNo == 5) {
            if (bTemp == 1) {
                imageView5.setBackgroundResource(R.drawable.shapla_01);
            } else if (bTemp == 2) {
                imageView5.setBackgroundResource(R.drawable.shapla_02);
            } else if (bTemp == 3) {
                imageView5.setBackgroundResource(R.drawable.shapla_03);
            } else if (bTemp == 4) {
                imageView5.setBackgroundResource(R.drawable.shapla_04);
            } else if (bTemp == 5) {
                imageView5.setBackgroundResource(R.drawable.shapla_05);
            } else if (bTemp == 6) {
                imageView5.setBackgroundResource(R.drawable.shapla_06);
            } else if (bTemp == 7) {
                imageView5.setBackgroundResource(R.drawable.shapla_07);
            } else if (bTemp == 8) {
                imageView5.setBackgroundResource(R.drawable.shapla_08);
            } else if (bTemp == 9) {
                imageView5.setBackgroundResource(R.drawable.blank);
            }

        } else if (buttonNo == 6) {

            if (bTemp == 1) {
                imageView6.setBackgroundResource(R.drawable.shapla_01);
            } else if (bTemp == 2) {
                imageView6.setBackgroundResource(R.drawable.shapla_02);
            } else if (bTemp == 3) {
                imageView6.setBackgroundResource(R.drawable.shapla_03);
            } else if (bTemp == 4) {
                imageView6.setBackgroundResource(R.drawable.shapla_04);
            } else if (bTemp == 5) {
                imageView6.setBackgroundResource(R.drawable.shapla_05);
            } else if (bTemp == 6) {
                imageView6.setBackgroundResource(R.drawable.shapla_06);
            } else if (bTemp == 7) {
                imageView6.setBackgroundResource(R.drawable.shapla_07);
            } else if (bTemp == 8) {
                imageView6.setBackgroundResource(R.drawable.shapla_08);
            } else if (bTemp == 9) {
                imageView6.setBackgroundResource(R.drawable.blank);
            }

        } else if (buttonNo == 7) {
            if (bTemp == 1) {
                imageView7.setBackgroundResource(R.drawable.shapla_01);
            } else if (bTemp == 2)

            {
                imageView7.setBackgroundResource(R.drawable.shapla_02);
            } else if (bTemp == 3) {
                imageView7.setBackgroundResource(R.drawable.shapla_03);
            } else if (bTemp == 4) {
                imageView7.setBackgroundResource(R.drawable.shapla_04);
            } else if (bTemp == 5) {
                imageView7.setBackgroundResource(R.drawable.shapla_05);
            } else if (bTemp == 6) {
                imageView7.setBackgroundResource(R.drawable.shapla_06);
            } else if (bTemp == 7) {
                imageView7.setBackgroundResource(R.drawable.shapla_07);
            } else if (bTemp == 8) {
                imageView7.setBackgroundResource(R.drawable.shapla_08);
            } else if (bTemp == 9) {
                imageView7.setBackgroundResource(R.drawable.blank);
            }

        } else if (buttonNo == 8) {

            if (bTemp == 1) {
                imageView8.setBackgroundResource(R.drawable.shapla_01);
            } else if (bTemp == 2)

            {
                imageView8.setBackgroundResource(R.drawable.shapla_02);
            } else if (bTemp == 3) {
                imageView8.setBackgroundResource(R.drawable.shapla_03);
            } else if (bTemp == 4) {
                imageView8.setBackgroundResource(R.drawable.shapla_04);
            } else if (bTemp == 5) {
                imageView8.setBackgroundResource(R.drawable.shapla_05);
            } else if (bTemp == 6) {
                imageView8.setBackgroundResource(R.drawable.shapla_06);
            } else if (bTemp == 7) {
                imageView8.setBackgroundResource(R.drawable.shapla_07);
            } else if (bTemp == 8) {
                imageView8.setBackgroundResource(R.drawable.shapla_08);
            } else if (bTemp == 9) {
                imageView8.setBackgroundResource(R.drawable.blank);
            }

        } else if (buttonNo == 9) {

            if (bTemp == 1) {
                imageView9.setBackgroundResource(R.drawable.shapla_01);
            } else if (bTemp == 2)

            {
                imageView9.setBackgroundResource(R.drawable.shapla_02);
            } else if (bTemp == 3) {
                imageView9.setBackgroundResource(R.drawable.shapla_03);
            } else if (bTemp == 4) {
                imageView9.setBackgroundResource(R.drawable.shapla_04);
            } else if (bTemp == 5) {
                imageView9.setBackgroundResource(R.drawable.shapla_05);
            } else if (bTemp == 6) {
                imageView9.setBackgroundResource(R.drawable.shapla_06);
            } else if (bTemp == 7) {
                imageView9.setBackgroundResource(R.drawable.shapla_07);
            } else if (bTemp == 8) {
                imageView9.setBackgroundResource(R.drawable.shapla_08);
            } else if (bTemp == 9) {
                imageView9.setBackgroundResource(R.drawable.blank);
            }

        }
    }

    private void imageCheck() {
        if (vx == 0 && vy == 0)
            buttonNo = 1;
        else if (vx == 0 && vy == 1)
            buttonNo = 2;
        else if (vx == 0 && vy == 2)
            buttonNo = 3;
        else if (vx == 1 && vy == 0)
            buttonNo = 4;
        else if (vx == 1 && vy == 1)
            buttonNo = 5;
        else if (vx == 1 && vy == 2)
            buttonNo = 6;
        else if (vx == 2 && vy == 0)
            buttonNo = 7;
        else if (vx == 2 && vy == 1)
            buttonNo = 8;
        else if (vx == 2 && vy == 2)
            buttonNo = 9;
    }


}


