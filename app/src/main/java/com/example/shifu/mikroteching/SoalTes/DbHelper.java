package com.example.shifu.mikroteching.SoalTes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shifu on 04/05/2018.
 */

public class DbHelper extends SQLiteOpenHelper{
    //DB version, table and database name
    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "quizdb";
    private static final String DB_TABLE = "quiztable";

    //table column names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "optA";
    private static final String KEY_OPTB = "optB";
    private static final String KEY_OPTC = "optC";
    private static final String KEY_OPTD = "optD";
    private static final String KEY_OPTE = "optE";

    private SQLiteDatabase dbase;
    private int rowCount = 0;

    public DbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT )", DB_TABLE, KEY_ID, KEY_QUES, KEY_ANSWER, KEY_OPTA, KEY_OPTB, KEY_OPTC, KEY_OPTD, KEY_OPTE);
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);
        db.execSQL(sqlQuery);
        addQuestions();
    }

    private void addQuestions() {
        Question q1 = new Question("kegiatan guru/pendidik dalam mempersiapkan peserta didik untuk mengikuti pembelajaran merupakan keterampilan dasar mengajar, yaitu …", "Membuka pelajaran", "Menutup pelajaran", "Memberi Penguatan", "Mengelola Kelas", "Memberi penjelasan", "Membuka pelajaran");
        this.addQuestionToDB(q1);
        Question q2 = new Question("Berikut ini yang tidak merupakan kegiatan membuka pelajaran yaitu …", "menciptakan suasana siap mental peserta", "menciptakan suasana komunikatif antara guru/pendidik dengan peserta didik", "menimbulkan perhatian peserta didik kepada apa yang akan dipelajari", "mengawali dari situasi keseharian peserta didik sampai pada materi yang akan dipelajari", "Memberi respon verbal atas pertanyaan peserta didik", "Memberi respon verbal atas pertanyaan peserta didik");
        this.addQuestionToDB(q2);
        Question q3 = new Question("kegiatan guru/pendidik mengakhiri kegiatan inti pembelajaran merupakan keterampilan dasar mengajar berupa…", "Membuka pelajaran", "Menutup pelajaran", "Memberi Penguatan", "Mengelola Kelas", "Memberi penjelasan", "Menutup pelajaran");
        this.addQuestionToDB(q3);
        Question q4 = new Question("Berikut ini yang tidak merupakan kegiatan menutup pelajaran yaitu …", "memberikan gambaran menyeluruh tentang semua materi yang telah dipelajari", "mengetahui tingkat penyerapan siswa terhadap materi", "mengetahui tingkat keberhasilan guru/pendidik dalam proses belajar mengajar", "memberikan penyampaian topik/materi pada pertemuan selanjutnya", "mengatasi kebosanan peserta didik melalui perubahan gaya mengajar", "mengatasi kebosanan peserta didik melalui perubahan gaya mengajar");
        this.addQuestionToDB(q4);
        Question q5 = new Question("keterampilan guru/pendidik menyajikan informasi lisan yang diorganisasikan secara sistematis dengan tujuan dapat menunjukkan hubungan antar materi yang telah dikumpulkan dan dikuasai serta disiapkan untuk disajikan adalah keterampilan …", "Membuka pelajaran", "Menutup pelajaran", "Memberi Penguatan", "Mengelola Kelas", "Memberi penjelasan", "Memberi penjelasan");
        this.addQuestionToDB(q5);
        Question q6 = new Question("Yang perlu diperhatikan dalam keterampilan menjelaskan adalah …", "pemberian indoktrinasi materi pembelajaran kepada peserta didik", "proses penalaran peserta didik dari materi pembelajaran", "proses pemberian stimulus efektif untuk mendorong kemampuan berpikir peserta didik", "proses mengatasi kejenuhan peserta didik dalam pembelajaran", "proses penumbuhan motivasi belajar peserta didik", "proses penalaran peserta didik dari materi pembelajaran");
        this.addQuestionToDB(q6);
        Question q7 = new Question("merupakan keterampilan dasar mengajar berupa….", "Menggunakan variasi", "Bertanya", "Memberi Penguatan", "Mengelola Kelas", "Membimbing diskusi", "Bertanya");
        this.addQuestionToDB(q7);
        Question q8 = new Question("perbuatan guru/pendidik dalam konteks proses belajar mengajar yang bertujuan mengatasi kebosanan peserta didik merupakan keterampilan dasar mengajar yaitu …", "Menggunakan variasi", "Bertanya", "Memberi Penguatan", "Mengelola Kelas", "Membimbing diskusi", "Menggunakan variasi");
        this.addQuestionToDB(q8);
        Question q9 = new Question("Tujuan dari penguasaan keterampilan menggunakan variasi adalah …", "peserta didik tekun belajar", "peserta didik memiliki antusiasme belajar", "peserta didik mampu menunjukkan tingkah laku positif kembali", "peserta didik berperan aktif dalam pembelajaran", "peserta didik tidak mengalami kejenuhan dalam pembelajaran", "peserta didik mampu menunjukkan tingkah laku positif kembali");
        this.addQuestionToDB(q9);
        Question q10 = new Question("tingkah laku guru/pendidik dalam merespon secara positif suatu tingkah laku tertentu peserta didik yang memungkinkan tingkah laku tersebut terulang kembali merupakan keterampilan dasar mengajar, yaitu …", "Menggunakan variasi", "Bertanya", "Memberi Penguatan", "Mengelola Kelas", "Membimbing diskusi", "Memberi Penguatan");
        this.addQuestionToDB(q10);
        Question q11 = new Question("tindakan guru/pendidik dalam konteks proses belajar mengajar yang hanya melayani 3 – 8 orang peserta merupakan KDM yaitu …", "mengajar kelompok kecil dan perorangan", "Bertanya", "Memberi Penguatan", "Mengelola Kelas", "Membimbing diskusi", "mengajar kelompok kecil dan perorangan");
        this.addQuestionToDB(q11);
        Question q12 = new Question("mengelola kelas menciptakan dan memelihara kondisi belajar yang  optimal dan mengembalikannya ke kondisi optimal jika terjadi yang dimungkinkan dapat mengganggu kegiatan merupakan KDM, yaitu …", "mengajar kelompok kecil dan perorangan", "Bertanya", "Memberi Penguatan", "Mengelola Kelas", "Membimbing diskusi", "Mengelola Kelas");
        this.addQuestionToDB(q12);
        Question q13 = new Question("proses yang teratur dengan melibatkan sekelompok peserta didik dalam interaksi tatap muka kooperatif yang optimal merupakan KDM yaitu …", "mengajar kelompok kecil dan perorangan", "Bertanya", "Memberi Penguatan", "Mengelola Kelas", "Membimbing diskusi kelompok kecil", "Membimbing diskusi kelompok kecil");
        this.addQuestionToDB(q13);
        Question q14 = new Question("Tujuan keterampilan membimbing diskusi kelompok kecil adalah, kecuali …", "berbagi informasi", "berbagi pengalaman mengambil keputusan", "berbagi solusi pemecahan masalah", "memastikan tujuan diskusi tercapai", "memastikan proses indoktrinasi tercapai", "memastikan proses indoktrinasi tercapai");
        this.addQuestionToDB(q14);
        Question q15 = new Question("yang tidak termasuk unsur-unsur perencanaan pembelajaran yaitu …", "tujuan pembelajaran", "materi pembelajaran", "metode pembelajaran", "observer pembelajaran", "evaluasi pembelajaran", "observer pembelajaran");
        this.addQuestionToDB(q15);

    }

    public void addQuestionToDB(Question q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, q.getQuestion());
        values.put(KEY_ANSWER,q.getAnswer());
        values.put(KEY_OPTA,q.getOptA());
        values.put(KEY_OPTB,q.getOptB());
        values.put(KEY_OPTC,q.getOptC());
        values.put(KEY_OPTD, q.getOptD());
        values.put(KEY_OPTE, q.getOptE());
        dbase.insert(DB_TABLE, null, values);
    }

    public List<Question> getAllQuestions(){
        List <Question> questionList = new ArrayList<Question>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE;
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptA(cursor.getString(3));
                q.setOptB(cursor.getString(4));
                q.setOptC(cursor.getString(5));
                q.setOptD(cursor.getString(6));
                q.setOptE(cursor.getString(7));

                questionList.add(q);

            }while (cursor.moveToNext());
        }
        return questionList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
        onCreate(db);
    }

    public int getRowCount(){
        return rowCount;
    }

}
