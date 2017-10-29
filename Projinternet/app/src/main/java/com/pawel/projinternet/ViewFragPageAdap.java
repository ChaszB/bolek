package com.pawel.projinternet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by uczen on 2017-10-29.
 */

public class ViewFragPageAdap extends FragmentPagerAdapter {


    public ViewFragPageAdap(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FerstFrag.newIstance();
            case 1:
                return SecFrag.newIstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
