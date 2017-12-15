package com.example.ishpreetkaur.autoslider;

/**
 * Created by Ishpreet Kaur on 15-12-2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public MainPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
//                FragmentSlide1 tab1 = new FragmentSlide1();
//                return tab1;
            case 1:
                FragmentPager tab2 = new FragmentPager();
                bundle.putInt("img", position);
                tab2.setArguments(bundle);
                return tab2;
            case 2:
                FragmentPager tab3 = new FragmentPager();

                bundle.putInt("img", position);
                tab3.setArguments(bundle);
                return tab3;
            case 3:
                FragmentPager tab4 = new FragmentPager();
                bundle.putInt("img", position);
                tab4.setArguments(bundle);
                return tab4;
            case 4:
                FragmentPager tab5 = new FragmentPager();
                bundle.putInt("img", position);
                tab5.setArguments(bundle);
                return tab5;

            case 5:
                FragmentPager tab6=new FragmentPager();
                bundle.putInt("img",position);
                tab6.setArguments(bundle);
                return tab6;

            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return 5;
    }
}
