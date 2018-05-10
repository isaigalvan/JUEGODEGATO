package a15300087.juegodegato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JUEGODEGATO extends AppCompatActivity implements View.OnClickListener{

    public Button b1, b2, b3, b4 ,b5, b6, b7, b8, b9;
    public Button[] matriz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegodegato);

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);

        matriz = new Button[]{b1, b2, b3, b4 ,b5, b6, b7, b8, b9};
        for(Button b : matriz){
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v){
    }﻿
}
