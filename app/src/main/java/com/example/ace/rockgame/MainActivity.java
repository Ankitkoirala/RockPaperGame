package com.example.ace.rockgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
        Button b_rock, b_paper, b_sessior;
    TextView textView3;
    ImageView iv_cpu, iv_me;

    String myChoise, cpuChoise, result;
    int yourscore, cpu_score = 0;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_sessior = (Button) findViewById(R.id.b_sessior);

        textView3 = (TextView) findViewById(R.id.textView3);

        r = new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise = "rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();

            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise = "paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();

            }
        });
        b_sessior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise = "sessior";
                iv_me.setImageResource(R.drawable.sessior);
                calculate();

            }
        });

    }
    public void calculate() {
        int cpu = r.nextInt(3);
        if (cpu == 0) {
            cpuChoise = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if (cpu == 1) {
            cpuChoise = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        } else if (cpu == 2) {
            cpuChoise = "sessior";
            iv_cpu.setImageResource(R.drawable.sessior);
        }

        if(myChoise.equals("rock") && cpuChoise.equals("paper")){
            cpu_score++;
            result = "YOU LOSE!!";

        }else
        if(myChoise.equals("rock") && cpuChoise.equals("sessior")){
            yourscore++;
            result = "YOU WIN!!";

        }else
        if(myChoise.equals("paper") && cpuChoise.equals("rock")){
            yourscore++;
            result = "YOU WIN!!";

        }else
        if(myChoise.equals("paper") && cpuChoise.equals("sessior")){
            cpu_score++;
            result = "YOU LOSE!!";

        }else
        if(myChoise.equals("sessior") && cpuChoise.equals("paper")){
            yourscore++;
            result = "YOU WIN!!";

        }else
        if(myChoise.equals("sessior") && cpuChoise.equals("rock")){
            cpu_score++;
            result = "YOU LOSE!!";

        }else
        if(myChoise.equals("rock") && cpuChoise.equals("rock")){
            result = " No score Its a Draw!!";

        }else
        if(myChoise.equals("sessior") && cpuChoise.equals("sessior")){
            result = "No score Its a draw!!";

        }else
        if(myChoise.equals("paper") && cpuChoise.equals("paper")){
            result = " No score  Its a Draw!!";

        }

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        textView3.setText("Score:Player = " + Integer.toString(yourscore) + " CPU = " + Integer.toString(cpu_score));
    }
}
