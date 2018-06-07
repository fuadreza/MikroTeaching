package com.example.shifu.mikroteching;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.example.shifu.mikroteching.BottomNavigation.BottomBarAdapter;
import com.example.shifu.mikroteching.BottomNavigation.HomeFragment;
import com.example.shifu.mikroteching.BottomNavigation.NoSwipePager;
import com.example.shifu.mikroteching.BottomNavigation.NotificationFragment;
import com.example.shifu.mikroteching.BottomNavigation.ProgressFragment;

public class MainActivity extends AppCompatActivity {

    private final int[] colors = {R.color.bottomtab_0, R.color.bottomtab_1, R.color.bottomtab_2};
    ImageView ivKDM1, ivKDM2, ivKDM3, ivKDM4, ivKDM5, ivKDM6, ivKDM7, ivKDM8;
    private Toolbar toolbar;
    private NoSwipePager viewPager;
    private AHBottomNavigation bottomNavigation;
    private BottomBarAdapter pagerAdapter;
    private View.OnClickListener imListener;
    private boolean notificationVisible = false;
    private PrefManager prefManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_AUTO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
//        getSupportActionBar().setTitle("Home");


        setupViewPager();


//        final DummyFragment fragment = new DummyFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("color", ContextCompat.getColor(this, colors[0]));
//        fragment.setArguments(bundle);

//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.frame, fragment, DummyFragment.TAG)
//                .commit();

        bottomNavigation = findViewById(R.id.bottom_navigation);
        setupBottomNavBehaviors();
        setupBottomNavStyle();

        createFakeNotification();

        addBottomNavigationItems();
        bottomNavigation.setCurrentItem(0);


        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
//                fragment.updateColor(ContextCompat.getColor(MainActivity.this, colors[position]));

                if (!wasSelected)
                    viewPager.setCurrentItem(position);

                // remove notification badge
                int lastItemPos = bottomNavigation.getItemsCount() - 1;
                if (notificationVisible && position == lastItemPos)
                    bottomNavigation.setNotification(new AHNotification(), lastItemPos);

                return true;
            }
        });

    }

    private void setupViewPager() {
        viewPager = findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);
        pagerAdapter = new BottomBarAdapter(getSupportFragmentManager());

        //DEFAUL BACKUP DEFAULT FRAGMENT ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       /* pagerAdapter.addFragments(createFragment(R.color.bottomtab_0));
        pagerAdapter.addFragments(createFragment(R.color.bottomtab_1));
        pagerAdapter.addFragments(createFragment(R.color.bottomtab_2));*/

        HomeFragment home_fragment = new HomeFragment();
        ProgressFragment progress_fragment = new ProgressFragment();
        NotificationFragment notification_fragment = new NotificationFragment();

        progress_fragment.setMyTag("PROGRESS_TAG");

        pagerAdapter.addFragments(home_fragment);
        pagerAdapter.addFragments(progress_fragment);
        pagerAdapter.addFragments(notification_fragment);

        viewPager.setAdapter(pagerAdapter);
    }

    //PASANGAN DUMMY FRAGMENT ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /*@NonNull
    private DummyFragment createFragment(int color) {
        DummyFragment fragment = new DummyFragment();
        fragment.setArguments(passFragmentArguments(fetchColor(color)));
        return fragment;
    }*/

    @NonNull
    private Bundle passFragmentArguments(int color) {
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);
        return bundle;
    }

    private void createFakeNotification() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AHNotification notification = new AHNotification.Builder()
                        .setText("1")
                        .setBackgroundColor(Color.YELLOW)
                        .setTextColor(Color.BLACK)
                        .build();
                // Adding notification to last item.

                bottomNavigation.setNotification(notification, bottomNavigation.getItemsCount() - 1);

                notificationVisible = true;
            }
        }, 1000);
    }


    public void setupBottomNavBehaviors() {
//        bottomNavigation.setBehaviorTranslationEnabled(false);

        /*
        Before enabling this. Change MainActivity theme to MyTheme.TranslucentNavigation in
        AndroidManifest.

        Warning: Toolbar Clipping might occur. Solve this by wrapping it in a LinearLayout with a top
        View of 24dp (status bar size) height.
         */
        bottomNavigation.setTranslucentNavigationEnabled(false);
    }

    /**
     * Adds styling properties to {@link AHBottomNavigation}
     */
    private void setupBottomNavStyle() {
        /*
        Set Bottom Navigation colors. Accent color for active item,
        Inactive color when its view is disabled.

        Will not be visible if setColored(true) and default current item is set.
         */
        bottomNavigation.setDefaultBackgroundColor(Color.WHITE);
        bottomNavigation.setAccentColor(fetchColor(R.color.bottomtab_0));
        bottomNavigation.setInactiveColor(fetchColor(R.color.bottomtab_item_resting));

        // Colors for selected (active) and non-selected items.
        bottomNavigation.setColoredModeColors(Color.WHITE,
                fetchColor(R.color.bottomtab_item_resting));

        //  Enables Reveal effect
        bottomNavigation.setColored(true);

        //  Displays item Title always (for selected and non-selected items)
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
    }


    /**
     * Adds (items) {@link AHBottomNavigationItem} to {@link AHBottomNavigation}
     * Also assigns a distinct color to each Bottom Navigation item, used for the color ripple.
     */
    private void addBottomNavigationItems() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_home_24dp, colors[0]);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_progress_24dp, colors[1]);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_notifications_24dp, colors[2]);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
    }


    /**
     * Simple facade to fetch color resource, so I avoid writing a huge line every time.
     *
     * @param color to fetch
     * @return int color value.
     */
    private int fetchColor(@ColorRes int color) {
        return ContextCompat.getColor(this, color);
    }
}


