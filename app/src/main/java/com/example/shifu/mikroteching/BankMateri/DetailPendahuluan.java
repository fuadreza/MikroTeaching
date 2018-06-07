package com.example.shifu.mikroteching.BankMateri;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.shifu.mikroteching.PrefManager;
import com.example.shifu.mikroteching.R;

/**
 * Created by Shifu on 31/03/2018.
 */

public class DetailPendahuluan extends AppCompatActivity {
    TextView tvJudul;
    TextView tvDeskripsi;

    Intent pindah;
    CoordinatorLayout clMain;
    int konten;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.detail_pendahuluan);

//        clMain = (CoordinatorLayout) findViewById(R.id.main_content);
        clMain = getWindow().getDecorView().findViewById(R.id.main_content);

        pindah = getIntent();

        konten = pindah.getIntExtra("layout",0);

        setContentView(konten);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("  ");

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

//        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        clMain.addView(1, layoutInflater.inflate(konten, this,false));

//        setContentView(pindah.getIntExtra("layout",0));

        tvJudul = findViewById(R.id.tvJudul);
        tvDeskripsi = findViewById(R.id.tvDeskripsidetail);

        tvJudul.setText(pindah.getStringExtra("judul"));

        /*Progress Pendahuluan*/

        prefManager = new PrefManager(this);
        prefManager.setPendahuluan(pindah.getStringExtra("judul"), true);

        /*End Progress Pendahuluan*/

    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                findViewById(R.id.collapsing_toolbar);

//        collapsingToolbar.setTitle(pindah.getStringExtra("judul"));

        AppBarLayout appBarLayout = findViewById(R.id.appbar);
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
                    collapsingToolbar.setTitle(pindah.getStringExtra("judul"));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("  ");
                    isShow = false;
                }
            }
        });
    }
}
