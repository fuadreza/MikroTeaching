package com.example.shifu.mikroteching.SoalTes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.shifu.mikroteching.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Shifu on 04/05/2018.
 */

public class Tes extends AppCompatActivity{
    List<Question> questionList;
    int score = 0;
    int quid = 0;
    Question currentQuestion;

    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd, rde;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DbHelper dbHelper = new DbHelper(this);
        questionList = dbHelper.getAllQuestions();
        Collections.shuffle(questionList);
        currentQuestion = questionList.get(quid);

        txtQuestion = (TextView)findViewById(R.id.question);
        rda = (RadioButton)findViewById(R.id.radio0);
        rdb = (RadioButton)findViewById(R.id.radio1);
        rdc = (RadioButton)findViewById(R.id.radio2);
        rdd = (RadioButton) findViewById(R.id.radio3);
        rde = (RadioButton) findViewById(R.id.radio4);
        butNext = (Button)findViewById(R.id.button1);
        setQuestionView();

    }

    private void setQuestionView(){
        txtQuestion.setText(currentQuestion.getQuestion());
        rda.setText(currentQuestion.getOptA());
        rdb.setText(currentQuestion.getOptB());
        rdc.setText(currentQuestion.getOptC());
        rdd.setText(currentQuestion.getOptD());
        rde.setText(currentQuestion.getOptE());
        quid++;
    }

    public void btClick(View view){
        RadioGroup grp = (RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton answer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
        if(currentQuestion.getAnswer().equals(answer.getText())){
            score++;
            Log.d("Skor", "Skor anda: " + score);
        }

        if(quid<15){
            currentQuestion = questionList.get(quid);
            setQuestionView();
        }else{
            Intent intent = new Intent(Tes.this, HasilTes.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
