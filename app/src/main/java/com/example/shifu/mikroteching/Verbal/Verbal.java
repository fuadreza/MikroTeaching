package com.example.shifu.mikroteching.Verbal;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.shifu.mikroteching.BankMateri.RowItem;
import com.example.shifu.mikroteching.R;

import java.util.ArrayList;
import java.util.List;

public class Verbal extends AppCompatActivity {

    String[] namaJudul;
    String[] deskripsi;
    String kategori;
    TypedArray gambar;
    List<RowItem> rowItems;
    ListView lvVerbal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initCollapsingToolbar();

        rowItems = new ArrayList<RowItem>();

        lvVerbal = (ListView) findViewById(R.id.lvVerbal);

        namaJudul = getResources().getStringArray(R.array.tesVerbal);
        gambar = getResources().obtainTypedArray(R.array.verbalGambar);
        deskripsi = getResources().getStringArray(R.array.soalVerbal);
        kategori = "Verbal";

        for (int i = 0; i < namaJudul.length; i++) {
            RowItem item = new RowItem(namaJudul[i],
                    gambar.getResourceId(i, -1),
                    deskripsi[i]);
            rowItems.add(item);
        }

        MenuVerbalAdapter adapter = new MenuVerbalAdapter(this, rowItems, namaJudul, deskripsi, null);
        lvVerbal.setAdapter(adapter);
        gambar.recycle();

        try {
            Glide.with(this).load(R.drawable.teacher).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        collapsingToolbar.setTitle(getString(R.string.menu_verbal));
        collapsingToolbar.setTitle(" ");

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.menu_verbal));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


}