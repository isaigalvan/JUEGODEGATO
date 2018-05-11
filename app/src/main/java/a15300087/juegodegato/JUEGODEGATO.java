package a15300087.juegodegato;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("ByteOrderMark")
public class JUEGODEGATO extends AppCompatActivity implements View.OnClickListener{

    public Button b1, b2, b3, b4 ,b5, b6, b7, b8, b9;
    public Button[] matriz;
    int[][] lamatriz;
    boolean turno;
    int conti;
    TextView eti;

    public void init(){
        lamatriz = new int[3][3];
        for(int cont = 0 ; cont < 3 ; cont ++){
            for(int cont1 = 0 ; cont1 < 3 ; cont1 ++){
                lamatriz[cont][cont1]= R.drawable.p;
            }
        }
        turno=true;
        conti = 0;
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
        eti = (TextView)findViewById(R.id.eti);
        this.init();
        matriz = new Button[]{b1, b2, b3, b4 ,b5, b6, b7, b8, b9};
        for(Button b : matriz){
            b.setOnClickListener(this);
        }
    }

    public void onClick(View v) {
        Button b = (Button)v;
        this.click(b);
    }       ﻿

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
        conti ++;
        this.verificador();
    }

    public void verificador(){
        int CXF=0, COF=0, CXC=0, COC=0, CXDP=0, CODP=0, CXDI=0, CODI=0, TERGATO=3;
        boolean sigano = false;

        for(int cont = 0 ; cont < lamatriz.length ; cont ++){
            for(int cont1 = 0 ; cont1 < lamatriz.length ; cont1 ++){
                if(lamatriz[cont][cont1]== R.drawable.x){
                    CXF++;
                    if(CXF==3){
                        sigano=true;
                    }
                }

                if(lamatriz[cont][cont1]== R.drawable.o){
                    COF++;
                    if(COF==3){
                        sigano=true;
                    }
                }

                if(lamatriz[cont1][cont]== R.drawable.x){
                    CXC++;
                    if(CXC==3){
                        sigano=true;
                    }
                }

                if(lamatriz[cont1][cont]== R.drawable.o){
                    COC++;
                    if(COC==3){
                        sigano=true;
                    }
                }

                if(cont==cont1){
                    if(lamatriz[cont][cont1]== R.drawable.x){
                        CXDP++;
                        if(CXDP==3){
                            sigano=true;
                        }
                    }

                    if(lamatriz[cont][cont1]== R.drawable.o){
                        CODP++;
                        if(CODP==3){
                            sigano=true;
                        }
                    }
                }

                if((cont+cont1)==TERGATO-1){
                    if(lamatriz[cont][cont1]== R.drawable.x){
                        CXDI++;
                        if(CXDI==3){
                            sigano=true;
                        }
                    }

                    if(lamatriz[cont][cont1]== R.drawable.o){
                        CODI++;
                        if(CODI==3){
                            sigano=true;
                        }
                    }
                }
            }
            CXC=0;COC=0;COF=0;CXF=0;
        }
        if(sigano){
            String v="";
            if(!turno){
                v = "GANO JUGADOR X";
            }
            if(turno){
                v = "GANO JUGADOR O";
            }
            eti.setText(v);
            conti=0;
        }
        if(conti == 9){
            eti.setText("EMPATE");
        }
    }
}
