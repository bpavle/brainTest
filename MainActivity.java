package com.example.braintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public void start(View view){
        ImageView startBtn = findViewById(R.id.startButton);
        TextView quest = findViewById(R.id.quest);
        Button ans1 = findViewById(R.id.ans1);
        Button ans2 = findViewById(R.id.ans2);
        Button ans3 = findViewById(R.id.ans3);
        Button ans4 = findViewById(R.id.ans4);
        final Button[] ans = new Button[]{ans1,ans2,ans3,ans4};

        for (Button i:ans) {
            i.setVisibility(View.VISIBLE);
        }
        startBtn.setVisibility(View.INVISIBLE);
        quest.setVisibility(View.VISIBLE);

        int random1 = (int )(Math.random() * 50 + 1);
        int random2 = (int )(Math.random() * 50 + 1);
        quest.setText(Integer.toString(random1)+" "+"+"+" "+Integer.toString(random2));
        int sol = random1+random2;
        //biramo na kom dugmetu ce biti tacan odgovor
        final int randSol = (int)(Math.random()*4 + 1);



        for (Button i:ans) {
            int num = (int)(Math.random()*100+1);;
            //while obezbedjuje da se ne pojavi jos negde tacno resenje osim na dugmetu koje mi zelimo
            while (num == sol){
                num  = (int)(Math.random()*100+1);
            }
            i.setText(Integer.toString(num));


            i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    incorrect();
                }
            });
        }
        ans[randSol].setText(Integer.toString(sol));

        ans[randSol].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct(ans[randSol]);
            }
        });


    }
    public void end(){

    }
    public void correct(Button b){
        Log.i("test","KLIKNUO SI "+b.getText());
    }
    public void incorrect(){
        //ovde ide kod kada se stisne pogresan odgovor
        Log.i("test","Stisnuo si neko pogresno dugme");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView startBtn = findViewById(R.id.startButton);
        startBtn.setVisibility(View.VISIBLE);

    }


}
