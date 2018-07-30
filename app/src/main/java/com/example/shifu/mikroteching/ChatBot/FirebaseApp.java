package com.example.shifu.mikroteching.ChatBot;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 10/06/2018.
 */

public class FirebaseApp extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}
