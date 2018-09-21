package com.example.stage3.myapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter  {

    private String tabtitles[] = new String[] { "Tab1", "Tab2", "Tab3" };
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    final int nPagine=3;
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            // Open FragmentTab1.java
            case 0:
                 return new albumUno();
            case 1:
                return new albumDue();
                // Open FragmentTab3.java
            case 2:
                return new albumTre();
        }
        return null;
    }

    @Override
    public int getCount() {
        return nPagine;
    }
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }



}
