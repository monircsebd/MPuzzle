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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ImageViewFour extends Activity implements View.OnClickListener {

    int vx, vy, bTemp, cnt = 0, buttonNo = 0, click = 0, highScore = 9999;

    int[] x = new int[]{-1, 0, 1, 0};
    int[] y = new int[]{0, 1, 0, -1};
    int[][] b = new int[4][4];

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
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;

    TextView tv1;
    String value;
    int a;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_four);



        final SharedPreferences prefs = getSharedPreferences("monir", ImageViewFour.this.MODE_PRIVATE);
        a = prefs.getInt("gemeSound", 999);
        value=""+a;
       // Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();


        mp = MediaPlayer.create(this, R.raw.prince);

        if(value.equals("1")) {
            mp.start();
            mp.setLooping(true);
        }




        LinearLayout layout = (LinearLayout) findViewById(R.id.background);
        layout.setBackgroundResource(R.drawable.background);

        imageView1 = (ImageView) findViewById(R.id.one);
        imageView2 = (ImageView) findViewById(R.id.two);
        imageView3 = (ImageView) findViewById(R.id.three);
        imageView4 = (ImageView) findViewById(R.id.four);
        imageView5 = (ImageView) findViewById(R.id.five);
        imageView6 = (ImageView) findViewById(R.id.six);
        imageView7 = (ImageView) findViewById(R.id.seven);
        imageView8 = (ImageView) findViewById(R.id.eight);
        imageView9 = (ImageView) findViewById(R.id.nine);
        imageView10 = (ImageView) findViewById(R.id.ten);
        imageView11 = (ImageView) findViewById(R.id.eleven);
        imageView12 = (ImageView) findViewById(R.id.twelve);
        imageView13 = (ImageView) findViewById(R.id.thirteen);
        imageView14 = (ImageView) findViewById(R.id.fourteen);
        imageView15 = (ImageView) findViewById(R.id.fifteen);
        imageView16 = (ImageView) findViewById(R.id.sixteen);


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
        imageView10.setOnClickListener(this);
        imageView11.setOnClickListener(this);
        imageView12.setOnClickListener(this);
        imageView13.setOnClickListener(this);
        imageView14.setOnClickListener(this);
        imageView15.setOnClickListener(this);
        imageView16.setOnClickListener(this);


        time = (TextView) findViewById(R.id.textView2);
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimeThread, 0);


        b[0][0] = 0;
        imageView1.setBackgroundResource(R.drawable.blank);
        b[0][1] = 6;
        imageView2.setBackgroundResource(R.drawable.f_six);
        b[0][2] = 2;
        imageView3.setBackgroundResource(R.drawable.f_two);
        b[0][3] = 8;
        imageView4.setBackgroundResource(R.drawable.f_eight);


        b[1][0] = 1;
        imageView5.setBackgroundResource(R.drawable.f_one);
        b[1][1] = 10;
        imageView6.setBackgroundResource(R.drawable.f_ten);
        b[1][2] = 3;
        imageView7.setBackgroundResource(R.drawable.f_three);
        b[1][3] = 12;
        imageView8.setBackgroundResource(R.drawable.f_twelve);


        b[2][0] = 5;
        imageView9.setBackgroundResource(R.drawable.f_five);
        b[2][1] = 14;
        imageView10.setBackgroundResource(R.drawable.f_fourteen);
        b[2][2] = 7;
        imageView11.setBackgroundResource(R.drawable.f_seven);
        b[2][3] = 16;
        imageView12.setBackgroundResource(R.drawable.f_sixteen);


        b[3][0] = 9;
        imageView13.setBackgroundResource(R.drawable.f_nine);
        b[3][1] = 13;
        imageView14.setBackgroundResource(R.drawable.f_thirteen);
        b[3][2] = 11;
        imageView15.setBackgroundResource(R.drawable.f_eleven);
        b[3][3] = 15;
        imageView16.setBackgroundResource(R.drawable.f_fifteen);


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
        getMenuInflater().inflate(R.menu.menu_image_view_four, menu);
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
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
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
        }

        if (v.getId() == R.id.two) {
            for (int i = 0; i < 4; i++) {
                vx = 0 + x[i];
                vy = 1 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
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
        }

        if (v.getId() == R.id.three) {
            for (int i = 0; i < 4; i++) {
                vx = 0 + x[i];
                vy = 2 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
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
        }

        if (v.getId() == R.id.four) {
            for (int i = 0; i < 4; i++) {
                vx = 0 + x[i];
                vy = 3 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[0][3];
                        b[0][3] = 0;
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
        }

        if (v.getId() == R.id.five) {
            for (int i = 0; i < 4; i++) {
                vx = 1 + x[i];
                vy = 0 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[1][0];
                        b[1][0] = 0;
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
        }

        if (v.getId() == R.id.six) {
            for (int i = 0; i < 4; i++) {
                vx = 1 + x[i];
                vy = 1 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[1][1];
                        b[1][1] = 0;
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
        }

        if (v.getId() == R.id.seven) {
            for (int i = 0; i < 4; i++) {
                vx = 1 + x[i];
                vy = 2 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[1][2];
                        b[1][2] = 0;
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
        }

        if (v.getId() == R.id.eight) {
            for (int i = 0; i < 4; i++) {
                vx = 1 + x[i];
                vy = 3 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[1][3];
                        b[1][3] = 0;
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
        }

        if (v.getId() == R.id.nine) {
            for (int i = 0; i < 4; i++) {
                vx = 2 + x[i];
                vy = 0 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[2][0];
                        b[2][0] = 0;
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

        if (v.getId() == R.id.ten) {
            for (int i = 0; i < 4; i++) {
                vx = 2 + x[i];
                vy = 1 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[2][1];
                        b[2][1] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();
                        imageView10.setBackgroundResource(R.drawable.blank);


                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        }

        if (v.getId() == R.id.eleven) {
            for (int i = 0; i < 4; i++) {
                vx = 2 + x[i];
                vy = 2 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[2][2];
                        b[2][2] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();
                        imageView11.setBackgroundResource(R.drawable.blank);


                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        }

        if (v.getId() == R.id.twelve) {
            for (int i = 0; i < 4; i++) {
                vx = 2 + x[i];
                vy = 3 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[2][3];
                        b[2][3] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();
                        imageView12.setBackgroundResource(R.drawable.blank);


                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        }

        if (v.getId() == R.id.thirteen) {
            for (int i = 0; i < 4; i++) {
                vx = 3 + x[i];
                vy = 0 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[3][0];
                        b[3][0] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();
                        imageView13.setBackgroundResource(R.drawable.blank);


                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        }

        if (v.getId() == R.id.fourteen) {
            for (int i = 0; i < 4; i++) {
                vx = 3 + x[i];
                vy = 1 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[3][1];
                        b[3][1] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();
                        imageView14.setBackgroundResource(R.drawable.blank);


                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        }

        if (v.getId() == R.id.fifteen) {
            for (int i = 0; i < 4; i++) {
                vx = 3 + x[i];
                vy = 2 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[3][2];
                        b[3][2] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();
                        imageView15.setBackgroundResource(R.drawable.blank);


                        click++;

                        String s = String.valueOf(click);
                        tv1.setText(s);

                        check();
                        break;
                    }
                }
            }
        }

        if (v.getId() == R.id.sixteen) {
            for (int i = 0; i < 4; i++) {
                vx = 3 + x[i];
                vy = 3 + y[i];
                if ((vx >= 0 && vx <= 3) && (vy >= 0 && vy <= 3)) {
                    if (b[vx][vy] == 0) {
                        b[vx][vy] = b[3][3];
                        b[3][3] = 0;
                        bTemp = b[vx][vy];
                        imageCheck();
                        set();
                        imageView16.setBackgroundResource(R.drawable.blank);


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

    private void imageCheck() {
        if (vx == 0 && vy == 0)
            buttonNo = 1;
        else if (vx == 0 && vy == 1)
            buttonNo = 2;
        else if (vx == 0 && vy == 2)
            buttonNo = 3;
        else if (vx == 0 && vy == 3)
            buttonNo = 4;


        else if (vx == 1 && vy == 0)
            buttonNo = 5;
        else if (vx == 1 && vy == 1)
            buttonNo = 6;
        else if (vx == 1 && vy == 2)
            buttonNo = 7;
        else if (vx == 1 && vy == 3)
            buttonNo = 8;


        else if (vx == 2 && vy == 0)
            buttonNo = 9;
        else if (vx == 2 && vy == 1)
            buttonNo = 10;
        else if (vx == 2 && vy == 2)
            buttonNo = 11;
        else if (vx == 2 && vy == 3)
            buttonNo = 12;


        else if (vx == 3 && vy == 0)
            buttonNo = 13;
        else if (vx == 3 && vy == 1)
            buttonNo = 14;
        else if (vx == 3 && vy == 2)
            buttonNo = 15;
        else if (vx == 3 && vy == 3)
            buttonNo = 16;
    }

    private void set() {

        if (buttonNo == 1) {
            if (bTemp == 1) {
                imageView1.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2)

            {
                imageView1.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView1.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView1.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView1.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView1.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView1.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView1.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView1.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView1.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView1.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView1.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView1.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView1.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView1.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView1.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 2) {
            if (bTemp == 1) {
                imageView2.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2) {
                imageView2.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView2.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView2.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView2.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView2.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView2.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView2.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView2.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView2.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView2.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView2.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView2.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView2.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView2.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView2.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 3) {
            if (bTemp == 1) {
                imageView3.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2)

            {
                imageView3.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView3.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView3.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView3.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView3.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView3.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView3.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView3.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView3.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView3.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView3.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView3.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView3.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView3.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView3.setBackgroundResource(R.drawable.f_sixteen);
            }
        } else if (buttonNo == 4) {
            if (bTemp == 1) {
                imageView4.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2)

            {
                imageView4.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView4.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView4.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView4.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView4.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView4.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView4.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView4.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView4.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView4.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView4.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView4.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView4.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView4.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView4.setBackgroundResource(R.drawable.f_sixteen);
            }
        } else if (buttonNo == 5) {
            if (bTemp == 1) {
                imageView5.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2)

            {
                imageView5.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView5.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView5.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView5.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView5.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView5.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView5.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView5.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView5.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView5.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView5.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView5.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView5.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView5.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView5.setBackgroundResource(R.drawable.f_sixteen);
            }
        } else if (buttonNo == 6) {
            if (bTemp == 1) {
                imageView6.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2)

            {
                imageView6.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView6.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView6.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView6.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView6.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView6.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView6.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView6.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView6.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView6.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView6.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView6.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView6.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView6.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView6.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 7) {
            if (bTemp == 1) {
                imageView7.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2)

            {
                imageView7.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView7.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView7.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView7.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView7.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView7.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView7.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView7.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView7.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView7.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView7.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView7.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView7.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView7.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView7.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 8) {
            if (bTemp == 1) {
                imageView8.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2) {
                imageView8.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView8.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView8.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView8.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView8.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView8.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView8.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView8.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView8.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView8.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView8.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView8.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView8.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView8.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView8.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 9) {
            if (bTemp == 1) {
                imageView9.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2) {
                imageView9.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView9.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView9.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView9.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView9.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView9.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView9.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView9.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView9.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView9.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView9.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView9.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView9.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView9.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView9.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 10) {
            if (bTemp == 1) {
                imageView10.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2) {
                imageView10.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView10.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView10.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView10.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView10.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView10.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView10.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView10.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView10.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView10.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView10.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView10.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView10.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView10.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView10.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 11) {
            if (bTemp == 1) {
                imageView11.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2) {
                imageView11.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView11.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView11.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView11.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView11.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView11.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView11.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView11.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView11.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView11.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView11.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView11.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView11.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView11.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView11.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 12) {
            if (bTemp == 1) {
                imageView12.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2) {
                imageView12.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView12.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView12.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView12.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView12.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView12.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView12.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView12.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView12.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView12.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView12.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView12.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView12.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView12.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView12.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 13) {
            if (bTemp == 1) {
                imageView13.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2)

            {
                imageView13.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView13.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView13.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView13.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView13.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView13.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView13.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView13.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView13.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView13.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView13.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView13.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView13.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView13.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView13.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 14) {
            if (bTemp == 1) {
                imageView14.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2) {
                imageView14.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView14.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView14.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView14.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView14.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView14.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView14.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView14.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView14.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView14.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView14.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView14.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView14.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView14.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView14.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 15) {
            if (bTemp == 1) {
                imageView15.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2) {
                imageView15.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView15.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView15.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView15.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView15.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView15.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView15.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView15.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView15.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView15.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView15.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView15.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView15.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView15.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView15.setBackgroundResource(R.drawable.f_sixteen);
            }

        } else if (buttonNo == 16) {
            if (bTemp == 1) {
                imageView16.setBackgroundResource(R.drawable.f_one);
            } else if (bTemp == 2) {
                imageView16.setBackgroundResource(R.drawable.f_two);
            } else if (bTemp == 3) {
                imageView16.setBackgroundResource(R.drawable.f_three);
            } else if (bTemp == 4) {
                imageView16.setBackgroundResource(R.drawable.blank);
            } else if (bTemp == 5) {
                imageView16.setBackgroundResource(R.drawable.f_five);
            } else if (bTemp == 6) {
                imageView16.setBackgroundResource(R.drawable.f_six);
            } else if (bTemp == 7) {
                imageView16.setBackgroundResource(R.drawable.f_seven);
            } else if (bTemp == 8) {
                imageView16.setBackgroundResource(R.drawable.f_eight);
            } else if (bTemp == 9) {
                imageView16.setBackgroundResource(R.drawable.f_nine);
            } else if (bTemp == 10) {
                imageView16.setBackgroundResource(R.drawable.f_ten);
            } else if (bTemp == 11) {
                imageView16.setBackgroundResource(R.drawable.f_eleven);
            } else if (bTemp == 12) {
                imageView16.setBackgroundResource(R.drawable.f_twelve);
            } else if (bTemp == 13) {
                imageView16.setBackgroundResource(R.drawable.f_thirteen);
            } else if (bTemp == 14) {
                imageView16.setBackgroundResource(R.drawable.f_fourteen);
            } else if (bTemp == 15) {
                imageView16.setBackgroundResource(R.drawable.f_fifteen);
            } else if (bTemp == 16) {
                imageView16.setBackgroundResource(R.drawable.f_sixteen);
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


        if (b[1][0] == 5)
            cnt++;
        if (b[1][1] == 6)
            cnt++;
        if (b[1][2] == 7)
            cnt++;
        if (b[1][3] == 8)
            cnt++;

        if (b[2][0] == 9)
            cnt++;
        if (b[2][1] == 10)
            cnt++;
        if (b[2][2] == 11)
            cnt++;
        if (b[2][3] == 12)
            cnt++;


        if (b[3][0] == 13)
            cnt++;
        if (b[3][1] == 14)
            cnt++;
        if (b[3][2] == 15)
            cnt++;
        if (b[3][3] == 16)
            cnt++;

        if (cnt == 15) {

            if(value.equals("1")) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
            }
            else
            {
                mp.stop();
            }


            int score= min*60 + sec + click;
            final SharedPreferences prefs = getSharedPreferences("Four", ImageViewFour.this.MODE_PRIVATE);
            try {
                highScore = prefs.getInt("FourHighScore", 9999);
            } catch (NumberFormatException e) {
                highScore = 9999;
            }

            if (score < highScore) {
                highScore = score;

                String str = String.valueOf(highScore);
                Intent intent = new Intent(ImageViewFour.this,BestScore.class);
                intent.putExtra("FourHighScore",str);

                Toast.makeText(getApplicationContext(), "WoW You made Best Score: " + highScore, Toast.LENGTH_LONG).show();
                SharedPreferences.Editor edit = prefs.edit();
                edit.putInt("FourHighScore", highScore);
                edit.commit();
            }
            else{
                int value = prefs.getInt("FourHighScore", -1);

                String s=String.valueOf(score);

                Toast.makeText(getApplicationContext(), "Your Score is: " + s, Toast.LENGTH_LONG).show();
            }
            click = 0;


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
                                public void onClick(DialogInterface dialog,	int id) {
                                    dialog.cancel();

                                    finish();
                                }
                            });


            AlertDialog alertD = alertDialogBuilder.create();

            alertD.show();



        }


    }
}
