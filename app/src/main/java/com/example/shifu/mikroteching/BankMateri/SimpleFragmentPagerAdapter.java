package com.example.shifu.mikroteching.BankMateri;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.shifu.mikroteching.R;

/**
 * Created by Shifu on 31/03/2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PendahuluanFragment();
        } else {
            return new KDMFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.kategori_pendahuluan);
            case 1:
                return mContext.getString(R.string.kategori_kdm);
            default:
                return null;
        }
    }
}
