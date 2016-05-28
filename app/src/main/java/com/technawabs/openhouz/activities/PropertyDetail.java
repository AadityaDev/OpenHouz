package com.technawabs.openhouz.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.views.uicomponents.SlidingTabLayout;

public class PropertyDetail extends AppCompatActivity {

    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"InYourCity","NearBy","BestOffer"};
    int NumbOfTabs=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_detail);

        adapter=new ViewPagerAdapter(getSupportFragmentManager(),Titles,NumbOfTabs);

        //Assign the viewpager view
        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        //Assign sliding tab layout
        tabs=(SlidingTabLayout)findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        //setting custom color
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.black);
            }
        });

        tabs.setViewPager(pager);
    }
}

class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabs) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
//            case 0:
//                InYourCity inYourCityTab=new InYourCity();
//                return inYourCityTab;
//            case 1:
//                NearBy nearByTab=new NearBy();
//                return nearByTab;
//            case 2:BestOffers bestOffersTab=new BestOffers();
//                return bestOffersTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NumbOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        return Titles[position];
    }
}