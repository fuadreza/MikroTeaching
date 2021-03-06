package com.example.shifu.mikroteching.BankMateri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shifu.mikroteching.R;

import java.util.List;

/**
 * Created by Shifu on 31/03/2018.
 */

public class CustomAdapter extends BaseAdapter{
    private String[] judul;
    private String kategori;
    private String[] deskripsi;
    private int[] gambar;
    private int layoute, backdrop;
    private String video1, video2;

    private Context context;
    private List<RowItem> rowItems;

    CustomAdapter(Context context, List<RowItem> rowItems, String[] judul, String[] deskripsi, int[] gambar, String kategori) {
        this.context = context;
        this.rowItems = rowItems;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.kategori = kategori;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        ViewHolder holder;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            try {
                convertView = mInflater.inflate(R.layout.item_simplevh, null);
            } catch (Exception e) {
                Log.e("ViewError", "Error on " + e.getMessage());
            }

            holder = new ViewHolder();

            holder.namaJudul = convertView
                    .findViewById(R.id.tv_pendahuluan_judul);
            holder.gambar = convertView
                    .findViewById(R.id.iv_pendahuluan_gambar);
            holder.deskripsi = convertView.findViewById(R.id.tv_pendahuluan_deskripsi);
            holder.view = convertView.findViewById(R.id.clPendahuluan);

            RowItem row_pos = rowItems.get(position);

            holder.gambar.setImageResource(row_pos.getGambar_id());
            holder.namaJudul.setText(row_pos.getNama_judul());
            holder.deskripsi.setText(row_pos.getDeskripsi());

            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pindah;

                    if (kategori.equalsIgnoreCase("Pendahuluan")){
                        pindah = new Intent(parent.getContext(), DetailPendahuluan.class);
                        switch (judul[position]) {
                            case "Konsep Pembelajaran":
                                layoute = R.layout.detail_pendahuluan_1;
                                break;
                            case "Tujuan Pembelajaran":
                                layoute = R.layout.detail_pendahuluan_2;
                                break;
                            case "Materi Pembelajaran":
                                layoute = R.layout.detail_pendahuluan_3;
                                break;
                            case "Metode dan Strategi Pembelajaran":
                                layoute = R.layout.detail_pendahuluan_4;
                                break;
                            case "Perlengkapan dan Fasilitas Pembelajaran":
                                layoute = R.layout.detail_pendahuluan_5;
                                break;
                            case "Penilaian Hasil Pembelajaran":
                                layoute = R.layout.detail_pendahuluan_6;
                                break;
                            default:
                                layoute = R.layout.detail_pendahuluan;
                                break;
                        }
                        backdrop = R.drawable.study;
                    }else {
                        pindah = new Intent(parent.getContext(), DetailKDM.class);
                        switch (judul[position]) {
                            case "Keterampilan Membuka dan Menutup Pelajaran":
                                layoute = R.layout.detail_kdm_1;
                                break;
                            case "Keterampilan Menjelaskan Pelajaran":
                                layoute = R.layout.detail_kdm_2;
                                break;
                            case "Keterampilan Bertanya":
                                layoute = R.layout.detail_kdm_3;
                                break;
                            case "Keterampilan Mengadakan Variasi":
                                layoute = R.layout.detail_kdm_4;
                                break;
                            case "Keterampilan Memberikan Penguatan":
                                layoute = R.layout.detail_kdm_5;
                                break;
                            case "Keterampilan Mengelola Kelas":
                                layoute = R.layout.detail_kdm_6;
                                break;
                            case "Keterampilan Mengajar Kelompok Kecil dan Perseorangan":
                                layoute = R.layout.detail_kdm_7;
                                break;
                            case "Keterampilan Memimpin Diskusi Kelompok Kecil":
                                layoute = R.layout.detail_kdm_8;
                                break;
                            default:
                                layoute = R.layout.detail_pendahuluan;
                                break;
                        }
                        backdrop = R.drawable.header_kdm;
                    }

                    pindah.putExtra("judul", judul[position]);
                    pindah.putExtra("deskripsi", deskripsi[position]);
                    pindah.putExtra("kategori", kategori);

                    pindah.putExtra("layout", layoute);
                    pindah.putExtra("backdrop", backdrop);
//                    pindah.putExtra("video1", video1);

                    parent.getContext().startActivity(pindah);
                }
            });

            convertView.setTag(holder);
        } else {
            //Value never use
            //holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    /* private view holder class */
    private class ViewHolder {
        ImageView gambar;
        TextView namaJudul;
        TextView deskripsi;
        ConstraintLayout view;
    }
}
