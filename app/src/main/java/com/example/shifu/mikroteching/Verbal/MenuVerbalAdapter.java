package com.example.shifu.mikroteching.Verbal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shifu.mikroteching.BankMateri.RowItem;
import com.example.shifu.mikroteching.R;

import java.util.List;

/**
 * Created by Shifu on 31/03/2018.
 */

public class MenuVerbalAdapter extends BaseAdapter {
    String[] judul = {};
    String kategori = "";
    String[] deskripsi = {};
    int[] gambar = {};
    int layoute;

    Context context;
    List<RowItem> rowItems;

    MenuVerbalAdapter(Context context, List<RowItem> rowItems, String[] judul, String[] deskripsi, int[] gambar) {
        this.context = context;
        this.rowItems = rowItems;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
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

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_verbal, null);
            holder = new ViewHolder();

            holder.namaJudul = convertView
                    .findViewById(R.id.tv_verbal_judul);
            holder.gambar = convertView
                    .findViewById(R.id.iv_verbal_gambar);
            holder.deskripsi = convertView.findViewById(R.id.tv_verbal_deskripsi);
            holder.view = convertView.findViewById(R.id.clVerbal);

            RowItem row_pos = rowItems.get(position);

            holder.gambar.setImageResource(row_pos.getGambar_id());
            holder.namaJudul.setText(row_pos.getNama_judul());
            holder.deskripsi.setText(row_pos.getDeskripsi());

            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pindah = new Intent(parent.getContext(), DetailVerbal.class);
                    pindah.putExtra("judul", judul[position]);
                    pindah.putExtra("soal", deskripsi[position]);

                    parent.getContext().startActivity(pindah);
                }
            });

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
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
