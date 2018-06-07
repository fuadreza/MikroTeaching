package com.example.shifu.mikroteching;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shifu on 17/03/2018.
 */

public class PrefManager {
    // Shared preferences file name
    private static final String PREF_NAME = "mikroteaching-welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String KDM = "IsFirstTimeLaunch";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    // shared pref mode
    int PRIVATE_MODE = 0;

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setPendahuluan(String judul, boolean isPenDone) {
        switch (judul) {
            case "Konsep Pembelajaran":
                editor.putBoolean("pd1", isPenDone);
                break;
            case "Tujuan Pembelajaran":
                editor.putBoolean("pd2", isPenDone);
                break;
            case "Materi Pembelajaran":
                editor.putBoolean("pd3", isPenDone);
                break;
            case "Metode dan Strategi Pembelajaran":
                editor.putBoolean("pd4", isPenDone);
                break;
            case "Perlengkapan dan Fasilitas Pembelajaran":
                editor.putBoolean("pd5", isPenDone);
                break;
            case "Penilaian Hasil Pembelajaran":
                editor.putBoolean("pd6", isPenDone);
                break;
            default:
                editor.putBoolean("pd7", isPenDone);
                break;
        }
        editor.commit();
    }

    public void setKDM(String judul, boolean isKDMDone) {
        switch (judul) {
            case "Keterampilan Membuka dan Menutup Pelajaran":
                editor.putBoolean("kdm1", isKDMDone);
                break;
            case "Keterampilan Menjelaskan Pelajaran":
                editor.putBoolean("kdm2", isKDMDone);
                break;
            case "Keterampilan Bertanya":
                editor.putBoolean("kdm3", isKDMDone);
                break;
            case "Keterampilan Mengadakan Variasi":
                editor.putBoolean("kdm4", isKDMDone);
                break;
            case "Keterampilan Memberikan Penguatan":
                editor.putBoolean("kdm5", isKDMDone);
                break;
            case "Keterampilan Mengelola Kelas":
                editor.putBoolean("kdm6", isKDMDone);
                break;
            case "Keterampilan Mengajar Kelompok Kecil dan Perseorangan":
                editor.putBoolean("kdm7", isKDMDone);
                break;
            case "Keterampilan Memimpin Diskusi Kelompok Kecil":
                editor.putBoolean("kdm8", isKDMDone);
                break;
            default:
                editor.putBoolean("kdm0", isKDMDone);
                break;
        }
        editor.commit();
    }

    public void setSkor(int skor) {
        editor.putInt("Skor", skor);
        editor.commit();
    }

    public void setMateri(int materi) {
        editor.putInt("Materi", materi);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isKDMDone(String kdm) {
        return pref.getBoolean(kdm, false);
    }

    public boolean isPenDone(String pen) {
        return pref.getBoolean(pen, false);
    }

    public int berapaSkor() {
        return pref.getInt("Skor", 0);
    }

    public int berapaMateri() {
        int materi = 0;
        for (int i = 1; i <= 8; i++) {
            if (isKDMDone("kdm" + i) == true) {
                materi++;
            }
        }
        for (int i = 1; i <= 6; i++) {
            if (isPenDone("pd" + i) == true) {
                materi++;
            }
        }
        return materi;
    }

}
