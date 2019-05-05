package io.mns.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.mns.myapplication.bindview.BindProcessor;
import io.mns.myapplication.bindview.BindWithId;

public class MainActivity extends AppCompatActivity {

    @BindWithId(R.id.tv1)
    TextView tv1;

    @BindWithId(R.id.tv2)
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long t = System.currentTimeMillis();

        t = System.currentTimeMillis();
        for (int i = 0 ; i< 1000 ; i++){
            tv1 = findViewById(R.id.tv1);
            tv2 = findViewById(R.id.tv2);
        }
        Log.d("ASDASD" , "ASDASD " + (System.currentTimeMillis()-t));

        t = System.currentTimeMillis();
        for (int i = 0 ; i< 1000 ; i++){
            BindProcessor.bind(this);
        }
        Log.d("ASDASD" , "ASDASD " + (System.currentTimeMillis()-t));

        t = System.currentTimeMillis();
        for (int i = 0 ; i< 1000 ; i++){
            BindProcessor.bindDeclared(this);
        }
        Log.d("ASDASD" , "ASDASD " + (System.currentTimeMillis()-t));


        tv1.setText("t1 check");
        tv2.setText("t2 check");
    }
}
