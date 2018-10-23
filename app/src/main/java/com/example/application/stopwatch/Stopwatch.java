package com.example.application.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Stopwatch extends AppCompatActivity {

    private int seconds=0;
    private boolean running;
    TextView timeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
//        if(savedInstanceState !=null)
//        {
//            seconds=savedInstanceState.getInt("seconds");
//            running=savedInstanceState.getBoolean("running");
//        }

        runtime();

    }
//    public void onSavedInstanceState(Bundle savedInstanceState)
//    {
//        savedInstanceState.putInt("seconds",seconds);
//        savedInstanceState.putBoolean("running",running);
//    }

    public void oNstart(View view)
    {
        running=true;
    }
    public void oNstop(View view)
    {
        running=false;
    }
    public void oNreset(View view)
    {
        running=false;
        seconds=0;
    }

    public void runtime()
    {
        timeView=(TextView) findViewById(R.id.timeView);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour =seconds/3600;
                int minutes=(seconds%3600)/60;
                int sec=seconds%60;

                String time=String.format("%d:%02d:%02d",hour,minutes,sec);
                timeView.setText(time);

                if(running)
                {
                    seconds ++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }
}
