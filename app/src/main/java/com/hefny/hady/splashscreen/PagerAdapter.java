package com.hefny.hady.splashscreen;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private static final int FRAGMENT_SIZE = 5;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return SlidingFragment.createSlidingFragment(position);
    }

    @Override
    public int getCount() {
        return FRAGMENT_SIZE;
    }
}