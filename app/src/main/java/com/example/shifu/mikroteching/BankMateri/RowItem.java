package com.example.shifu.mikroteching.BankMateri;

/**
 * Created by Shifu on 31/03/2018.
 */

public class RowItem {

    private String nama_judul;
    private int gambar_id;
    private String deskripsi;

    public RowItem(String nama_judul, int gambar_id, String deskripsi) {

        this.nama_judul = nama_judul;
        this.gambar_id = gambar_id;
        this.deskripsi = deskripsi;

    }

    public String getNama_judul() {
        return nama_judul;
    }

    public void setNama_judul(String nama_judul) {
        this.nama_judul = nama_judul;
    }

    public int getGambar_id() {
        return gambar_id;
    }

    public void setGambar_id(int gambar_id) {
        this.gambar_id = gambar_id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}