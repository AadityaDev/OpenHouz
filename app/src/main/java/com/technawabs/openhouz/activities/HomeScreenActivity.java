package com.technawabs.openhouz.activities;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.views.fragments.Favorite;
import com.technawabs.openhouz.views.fragments.Filter;
import com.technawabs.openhouz.views.fragments.Home;
import com.technawabs.openhouz.views.fragments.ScheduledVisits;
import com.technawabs.openhouz.views.uicomponents.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity implements Home.OnFragmentInteractionListener,
        Filter.OnFragmentInteractionListener, Favorite.OnFragmentInteractionListener, ScheduledVisits.OnFragmentInteractionListener {

    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        initializeUIComponents();
    }

    private void initializeUIComponents() {
        // Create the adapter that will return a fragment for each section
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[]{
                    new Home(),
                    new Filter(),
                    new Favorite(),
                    new ScheduledVisits(),
            };
            private final String[] mFragmentNames = new String[]{
                    "Home",
                    "Filter",
                    "Favorite",
                    "Visits"
            };

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

            @Override
            public int getCount() {
                return mFragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }
        };
        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(fragmentPagerAdapter);

        final String[] colors = getResources().getStringArray(R.array.default_preview);
        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_home_24dp),
                        Color.parseColor(colors[0]))
                        .title("Heart")
                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_search_24dp),
                        Color.parseColor(colors[1]))
                        .title("Heart")
                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_favorite_border_24dp),
                        Color.parseColor(colors[2]))
                        .title("Heart")
                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_date_range_24dp),
                        Color.parseColor(colors[3]))
                        .title("Heart")
                        .badgeTitle("NTB")
                        .build()
        );
        navigationTabBar.setModels(models);
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                navigationTabBar.getModels().get(position).hideBadge();
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
        navigationTabBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
                    navigationTabBar.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);
        navigationTabBar.setViewPager(viewPager, 0);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
