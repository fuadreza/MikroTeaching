package com.example.shifu.mikroteching.SoalTes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.shifu.mikroteching.R;

/**
 * Created by Shifu on 04/05/2018.
 */

public class HasilTes extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        TextView scoreTxtView = (TextView) findViewById(R.id.score);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar1);
        ImageView img = (ImageView)findViewById(R.id.img1);

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        ratingBar.setRating(score);
        scoreTxtView.setText(String.valueOf(score));

        if(score == 0){
            img.setImageResource(R.drawable.score_0);
        }else if(score == 1){
            img.setImageResource(R.drawable.score_1);
        }else if(score == 2){
            img.setImageResource(R.drawable.score_2);
        }else if(score == 3){
            img.setImageResource(R.drawable.score_3);
        }else if(score == 4){
            img.setImageResource(R.drawable.score_4);
        }else if(score == 5){
            img.setImageResource(R.drawable.score_5);
        }
    }

}
