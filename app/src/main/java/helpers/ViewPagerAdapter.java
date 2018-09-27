package helpers;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import features.albumDue;
import features.albumTre;
import features.albumUno;

public class ViewPagerAdapter extends FragmentPagerAdapter  {

    private String tabtitles[] = new String[] { "ALBUM 1", "ALBUM 2", "ALBUM 3" };
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    final int nPagine=3;
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
        return nPagine;
    }
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }

}
