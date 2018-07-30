package com.example.shifu.mikroteching.Verbal;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shifu.mikroteching.R;

import java.util.ArrayList;
import java.util.List;

public class DetailVerbal extends AppCompatActivity {

    private final int REQ_CODE_SPEECH_INPUT = 100;
    TextToSpeech tts;
    private TextView txtSpeechInput, txtSoalVerbal, txtHasil;
    private ImageButton btnSpeak;
    private ImageView ivHasil;
    private String soal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verbal1);

        txtSoalVerbal = findViewById(R.id.txtSoalVerbal);
        txtSpeechInput = findViewById(R.id.txtSpeechInput);
        txtHasil = findViewById(R.id.txtHasil);
        ivHasil = findViewById(R.id.ivHasil);
        btnSpeak = findViewById(R.id.btnSpeak);

        //Get Data
        Intent pindah = getIntent();

        soal = pindah.getStringExtra("soal");

        txtSoalVerbal.setText(soal);

        // hide the action bar
        //getActionBar().hide();

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

    }

    /**
     * Showing google speech input dialog
     */
    private void promptSpeechInput() {
//        Intent intent = new Intent(RecognizerIntent.ACTION_GET_LANGUAGE_DETAILS);
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

//        sendOrderedBroadcast(intent, null, new LanguageDetailsChecker(), null,Activity.RESULT_OK, null, null );
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//                "id");
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "id-ID");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    Log.e("avalable Language", String.valueOf(data.getStringExtra(RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES)));

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));

                    if (result.get(0).equalsIgnoreCase(soal)) {
                        txtHasil.setText("Benar");
                        ivHasil.setImageResource(R.drawable.benar);
                    } else {
                        txtHasil.setText("Salah");
                        ivHasil.setImageResource(R.drawable.salah);
                    }
                }
                break;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public class LanguageDetailsChecker extends BroadcastReceiver {
        private List<String> supportedLanguages;

        private String languagePreference;

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle results = getResultExtras(true);
            if (results.containsKey(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE)) {
                languagePreference =
                        results.getString(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE);

                Log.e("coba", languagePreference);
            }
            if (results.containsKey(RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES)) {
                supportedLanguages =
                        results.getStringArrayList(
                                RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES);
                for (String langAvalable : supportedLanguages) {
                    Log.e("lang", langAvalable);
                }
            }
        }

    }

}