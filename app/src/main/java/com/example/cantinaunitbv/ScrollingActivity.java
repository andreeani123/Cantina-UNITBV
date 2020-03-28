package com.example.cantinaunitbv;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ScrollingActivity extends AppCompatActivity {

    double [] pret = new double[28];
    double total = 0;
    TextView numeMancare[] = new TextView[28];
    TextView text [] = new TextView[28];
    Button bmin [] = new Button[28];
    Button bplus [] = new Button[28];
    int cantitate [] = new int [28];
    ImageButton next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        total = 0;


        numeMancare[0] = findViewById(R.id.manc0);
        text[0] = findViewById(R.id.text0);
        bmin[0] = findViewById(R.id.bmin0);
        bplus[0] = findViewById(R.id.bplus0);
        pret[0] = 3.15;

        numeMancare[1] = findViewById(R.id.manc1);
        text[1] = findViewById(R.id.text1);
        bmin[1] = findViewById(R.id.bmin1);
        bplus[1] = findViewById(R.id.bplus1);
        pret[1] = 4.8;

        numeMancare[2] = findViewById(R.id.manc2);
        text[2] = findViewById(R.id.text2);
        bmin[2] = findViewById(R.id.bmin2);
        bplus[2] = findViewById(R.id.bplus2);
        pret[2] = 3.3;

        numeMancare[3] = findViewById(R.id.manc3);
        text[3] = findViewById(R.id.text3);
        bmin[3] = findViewById(R.id.bmin3);
        bplus[3] = findViewById(R.id.bplus3);
        pret[3] = 1.1;

        numeMancare[4] = findViewById(R.id.manc4);
        text[4] = findViewById(R.id.text4);
        bmin[4] = findViewById(R.id.bmin4);
        bplus[4] = findViewById(R.id.bplus4);
        pret[4] = 2.0;

        for(int i = 0; i < 5; i++) {
            cantitate[i] = 0;

            final int j = i;

            bplus[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cantitate[j]++;
                    String s = Integer.toString(cantitate[j]);
                    text[j].setText(s);

                }
            });

            bmin[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(cantitate[j]!= 0)
                   {cantitate[j]--;

                       String s = Integer.toString(cantitate[j]);
                       text[j].setText(s);

                   }
                }
            });

        }

       next1 = findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), pas2.class);
                for(int i= 0; i < 5; i++)
                {
                    total = total + cantitate[i] * pret[i];
                    String aux = "mancare" + i;
                    String aux1 = "cantitate" + i;
                    intent.putExtra(aux, numeMancare[i].getText().toString());
                    intent.putExtra(aux1, Integer.toString(cantitate[i]));
                }
                String s = Double.toString(total);
                intent.putExtra("total", s);
                total = 0;
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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
}
