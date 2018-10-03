package helpers;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import features.albumDue;
import features.albumTre;
import features.albumUno;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int numOfPage;

    public ViewPagerAdapter(FragmentManager fm,int numOfPage) {
        super(fm);
        this.numOfPage=numOfPage;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                 return new albumUno();
            case 1:
                return new albumDue();
            case 2:
                return new albumTre();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numOfPage;
    }

}
