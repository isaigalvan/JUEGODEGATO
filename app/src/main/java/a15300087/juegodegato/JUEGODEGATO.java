package a15300087.juegodegato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JUEGODEGATO extends AppCompatActivity implements View.OnClickListener{

    public Button b1, b2, b3, b4 ,b5, b6, b7, b8, b9;
    public Button[] matriz;
    Object[][] lamatriz;
    boolean turno;

    public void init(){
        lamatriz = new Object[3][3];
        for(int cont = 0 ; cont < 3 ; cont ++){
            for(int cont1 = 0 ; cont1 < 3 ; cont1 ++){
                lamatriz[cont][cont1]= R.drawable.p;
            }
        }
        turno=true;
    }
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
        this.init();
        matriz = new Button[]{b1, b2, b3, b4 ,b5, b6, b7, b8, b9};
        for(Button b : matriz){
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v){
        Button b = (Button)v;
        this.click(b);
    }﻿

    public void click(Button b){

        int x = 0;
        if(turno){
            x = R.drawable.x;
            b.setBackgroundResource(x);
        }else
            {
            x = R.drawable.o;
            b.setBackgroundResource(x);
        }

        switch (b.getId()){
            case R.id.b1:
                lamatriz[0][0]= x;
                break;
            case R.id.b2:
                lamatriz[0][1]= x;
                break;
            case R.id.b3:
                lamatriz[0][2]= x;
                break;
            case R.id.b4:
                lamatriz[1][0]= x;
                break;
            case R.id.b5:
                lamatriz[1][1]= x;
                break;
            case R.id.b6:
                lamatriz[1][2]= x;
                break;
            case R.id.b7:
                lamatriz[2][0]= x;
                break;
            case R.id.b8:
                lamatriz[2][1]= x;
                break;
            case R.id.b9:
                lamatriz[2][2]= x;
                break;
        }

        turno =! turno;
        b.setClickable(true);
    }
}
