package com.example.shifu.mikroteching.BankMateri;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shifu.mikroteching.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shifu on 31/03/2018.
 */

public class PendahuluanFragment extends ListFragment {

    String[] namaJudul;
    String[] deskripsi;
    String kategori;
    TypedArray gambar;
    List<RowItem> rowItems;

    public PendahuluanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pendahuluan, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rowItems = new ArrayList<RowItem>();

        namaJudul = getResources().getStringArray(R.array.pendahuluanJudul);
        gambar = getResources().obtainTypedArray(R.array.pendahuluanGambar);
        deskripsi = getResources().getStringArray(R.array.pendahuluanDeskripsi);
        kategori = "Pendahuluan";

        for (int i = 0; i < namaJudul.length; i++) {
            RowItem item = new RowItem(namaJudul[i],
                    gambar.getResourceId(i, -1),
                    deskripsi[i]);
            rowItems.add(item);
        }

        CustomAdapter adapter = new CustomAdapter(getActivity(), rowItems, namaJudul, deskripsi, null, kategori);
        setListAdapter(adapter);
        gambar.recycle();
    }
}
