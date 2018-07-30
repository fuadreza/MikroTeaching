package com.example.shifu.mikroteching.BankMateri;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shifu.mikroteching.PrefManager;
import com.example.shifu.mikroteching.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Shifu on 31/03/2018.
 */

public class DetailKDM extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {
    //    Youtube
    private static final int RECOVERY_REQUEST = 1;
    TextView tvJudul;
    TextView tvDeskripsi;
    Intent pindah;
    CoordinatorLayout clMain;
    int konten;
    private PrefManager prefManager;
    private YouTubePlayerView youTubeView, youTubeView2;
    private YouTubePlayerSupportFragment frag, frag2;


    private MyPlayerStateChangeListener playerStateChangeListener;
    private MyPlaybackEventListener playbackEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.detail_pendahuluan);

//        clMain = (CoordinatorLayout) findViewById(R.id.main_content);
        clMain = getWindow().getDecorView().findViewById(R.id.main_content);

        pindah = getIntent();

        konten = pindah.getIntExtra("layout", 0);

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

        /*Progress KDM*/

        prefManager = new PrefManager(this);
        prefManager.setKDM(pindah.getStringExtra("judul"), true);

        /*End Progress KDM*/

        try {
            Glide.with(this).load(pindah.getIntExtra("backdrop", 0)).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*YoutubePlayer*/

        frag = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);
        frag.initialize(ConfigYoutube.YOUTUBE_API_KEY, this);

        if (pindah.getStringExtra("judul").equalsIgnoreCase("Keterampilan Membuka dan Menutup Pelajaran")) {
            frag2 = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment2);
            frag2.initialize(ConfigYoutube.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.cueVideo("1wzIiZmhM_I");
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    if (youTubeInitializationResult.isUserRecoverableError()) {
                        youTubeInitializationResult.getErrorDialog(DetailKDM.this, RECOVERY_REQUEST).show();
                    } else {
                        String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
                        Toast.makeText(DetailKDM.this, error, Toast.LENGTH_LONG).show();
                    }
                }
            });

        }

//        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
//        youTubeView2 = (YouTubePlayerView) findViewById(R.id.youtube_view2);
//        youTubeView.initialize(ConfigYoutube.YOUTUBE_API_KEY, this);

        playerStateChangeListener = new MyPlayerStateChangeListener();
        playbackEventListener = new MyPlaybackEventListener();

        /*End YoutubePlayer*/

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

    //    Youtube

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        Log.d("somplak", player.toString());
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
        if (!wasRestored) {
            switch (pindah.getStringExtra("judul")) {
                case "Keterampilan Membuka dan Menutup Pelajaran":
                    player.cueVideo("dcZdxRd2V-s"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                    break;
                case "Keterampilan Menjelaskan Pelajaran":
                    player.cueVideo("xcD5HFdvwbE"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                    break;
                case "Keterampilan Bertanya":
                    player.cueVideo("q9eNVWwoMVI"); // Plays https://www.youtube.com/watch?v=q9eNVWwoMVI
                    break;
                case "Keterampilan Mengadakan Variasi":
                    player.cueVideo("Jb2gNHUVQkQ"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                    break;
                case "Keterampilan Memberikan Penguatan":
                    player.cueVideo("B-SZJvEw_qs"); // Plays https://www.youtube.com/watch?v=B-SZJvEw_qs
                    break;
                case "Keterampilan Mengelola Kelas":
                    player.cueVideo("tRfUbtD1Je8"); // Plays https://www.youtube.com/watch?v=tRfUbtD1Je8
                    break;
                case "Keterampilan Mengajar Kelompok Kecil dan Perseorangan":
                    player.cueVideo("rciRFSg_ol4"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                    break;
                case "Keterampilan Memimpin Diskusi Kelompok Kecil":
                    player.cueVideo("L4mwtjxJEeA"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                    break;
                default:
                    player.cueVideo("fhWaJi1Hsfo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(ConfigYoutube.YOUTUBE_API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
//        return youTubeView;
        return frag;
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    private void showMessage(String message) {
        //Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

        @Override
        public void onPlaying() {
            // Called when playback starts, either due to user action or call to play().
            showMessage("Playing");
        }

        @Override
        public void onPaused() {
            // Called when playback is paused, either due to user action or call to pause().
            showMessage("Paused");
        }

        @Override
        public void onStopped() {
            // Called when playback stops for a reason other than being paused.
            showMessage("Stopped");
        }

        @Override
        public void onBuffering(boolean b) {
            // Called when buffering starts or ends.
        }

        @Override
        public void onSeekTo(int i) {
            // Called when a jump in playback position occurs, either
            // due to user scrubbing or call to seekRelativeMillis() or seekToMillis()
        }
    }

    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

        @Override
        public void onLoading() {
            // Called when the player is loading a video
            // At this point, it's not ready to accept commands affecting playback such as play() or pause()
        }

        @Override
        public void onLoaded(String s) {
            // Called when a video is done loading.
            // Playback methods such as play(), pause() or seekToMillis(int) may be called after this callback.
        }

        @Override
        public void onAdStarted() {
            // Called when playback of an advertisement starts.
        }

        @Override
        public void onVideoStarted() {
            // Called when playback of the video starts.
        }

        @Override
        public void onVideoEnded() {
            // Called when the video reaches its end.
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            // Called when an error occurs.
        }
    }
//    End Youtube
}
