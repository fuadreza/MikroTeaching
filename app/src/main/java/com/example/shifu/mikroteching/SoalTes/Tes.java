package com.example.shifu.mikroteching.SoalTes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import com.example.shifu.mikroteching.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Shifu on 04/05/2018.
 */

public class Tes extends AppCompatActivity {
    List<Question> questionList;
    int score = 0;
    int quid = 0;
    Question currentQuestion;
    String nomor;

    TextView txtQuestion, txtNumber;
    RadioButton rda, rdb, rdc, rdd, rde;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Soal Tes");
        setSupportActionBar(toolbar);

        DbHelper dbHelper = new DbHelper(this);
        questionList = dbHelper.getAllQuestions();
        Collections.shuffle(questionList);
        currentQuestion = questionList.get(quid);

        txtQuestion = findViewById(R.id.question);
        txtNumber = findViewById(R.id.number);
        rda = findViewById(R.id.radio0);
        rdb = findViewById(R.id.radio1);
        rdc = findViewById(R.id.radio2);
        rdd = findViewById(R.id.radio3);
        rde = findViewById(R.id.radio4);
        butNext = findViewById(R.id.button1);
        setQuestionView();

    }

    private void setQuestionView() {
        txtQuestion.setText(currentQuestion.getQuestion());
        nomor = String.valueOf(quid + 1);
        txtNumber.setText(nomor);
        rda.setText(currentQuestion.getOptA());
        rdb.setText(currentQuestion.getOptB());
        rdc.setText(currentQuestion.getOptC());
        rdd.setText(currentQuestion.getOptD());
        rde.setText(currentQuestion.getOptE());
        quid++;
    }

    public void btClick(View view) {
        final RadioGroup grp = findViewById(R.id.radioGroup1);

        if (!isAnswered()) {
            Toast.makeText(this, "Silahkan isi jawaban terlebih dahulu", Toast.LENGTH_SHORT).show();
        } else {
            final RadioButton answer = findViewById(grp.getCheckedRadioButtonId());
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            if (currentQuestion.getAnswer().equals(answer.getText())) {
                                score++;
                                Log.d("Skor", "Skor anda: " + score);
                            }

                            if (quid < 15) {
                                currentQuestion = questionList.get(quid);
                                grp.clearCheck();
                                setQuestionView();
                            } else {
                                Intent intent = new Intent(Tes.this, HasilTes.class);
                                Bundle b = new Bundle();
                                b.putInt("score", score);
                                intent.putExtras(b);
                                startActivity(intent);
                                finish();
                            }
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setMessage("Apakah yakin dengan jawaban anda?").setPositiveButton("Ya", dialogClickListener)
                    .setNegativeButton("Tidak", dialogClickListener).show();
        }
    }

    private boolean isAnswered() {
        RadioGroup grp = findViewById(R.id.radioGroup1);
        return grp.getCheckedRadioButtonId() != -1;
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
