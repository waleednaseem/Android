
package com.example.application.masscalculator;

import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calcMass extends AppCompatActivity {

    TextView wieghtRes ,result;
    EditText weightField , HeightField ;
    Button calculate;
    double height=0;
    double wieght=0;
    double answer=0;
    String msgs="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_mass);
    }
    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            wieghtRes.setText(String.valueOf(answer));
            result.setText(msgs);
        }
    };

    public void calcbut(View view)
    {
        Runnable r=new Runnable() {
            @Override
            public void run() {

                synchronized(this){
                    try{
                        weightField=(EditText) findViewById(R.id.weightField);
                        HeightField=(EditText) findViewById(R.id.HeightField);

                        calculate=(Button) findViewById(R.id.calc);

                        wieghtRes=(TextView) findViewById(R.id.wieghtRes);
                        result=(TextView) findViewById(R.id.result);

                        height =Double.parseDouble(HeightField.getText().toString());
                        wieght =Double.parseDouble(weightField.getText().toString());

                        answer= height * height;
                        answer= wieght / answer;


                        if (answer<18.5)
                        {
                            msgs="under Wieght";
                        }
                        else if(answer>18.5 && answer<25)
                        {
                            msgs="Normal";
                        }
                        else if(answer<25)
                        {
                            msgs="Overweight";
                        }
                        handler.sendEmptyMessage(0);

                    }catch (Exception e)
                    {

                    }
                }

            }

        };
        Thread thread=new Thread(r);
        thread.start();




    }

}
