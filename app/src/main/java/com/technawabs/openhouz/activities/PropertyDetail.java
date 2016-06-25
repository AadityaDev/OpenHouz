package com.technawabs.openhouz.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.widget.ListView;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.models.BuildingSpecs;
import com.technawabs.openhouz.models.GenericArrayItem;
import com.technawabs.openhouz.models.MetroStation;
import com.technawabs.openhouz.models.SpaceDetail;
import com.technawabs.openhouz.utils.Utility;
import com.technawabs.openhouz.views.adapters.GenericArrayAdapter;
import com.technawabs.openhouz.views.adapters.SpaceAdapter;
import com.technawabs.openhouz.views.uicomponents.SlidingTabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class PropertyDetail extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"VR Tour", "Living Room", "Bedroom", "Bathroom"};
    int NumbOfTabs = 4;
    ListView spaceDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_detail);

//        adapter=new ViewPagerAdapter(getSupportFragmentManager(),Titles,NumbOfTabs);
//
//        //Assign the viewpager view
//        pager=(ViewPager)findViewById(R.id.pager);
//        pager.setAdapter(adapter);
//
//        //Assign sliding tab layout
//        tabs=(SlidingTabLayout)findViewById(R.id.tabs);
//        tabs.setDistributeEvenly(true);
//
//        //setting custom color
//        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
//            @Override
//            public int getIndicatorColor(int position) {
//                return getResources().getColor(R.color.black);
//            }
//        });
//        tabs.setViewPager(pager);

        setupSpaceDetailCard();
        //Building specs
        setupBuildingSpecs();
        //Nearby Metro stations
        setupNearbyMetroStations();
        setupRestrictions();
    }

    private void setupSpaceDetailCard() {
        //Get Space Detail
        final SpaceDetail spaceDetail = new SpaceDetail();
        spaceDetail.setAvailableDate("dsdsds");
        spaceDetail.setDeposit("434343");
        spaceDetail.setNumOfBedrooms(5);
        spaceDetail.setNumOfBathrooms(4);
        spaceDetail.setPropertyType("Villa");
        spaceDetail.setHelperRoomAvailable(false);
        spaceDetail.setFurnished(true);
        spaceDetail.setGasPipelineAvailable(true);
        spaceDetail.setMinimumStay("3 dats");
        GenericArrayAdapter genericArrayAdapter = new GenericArrayAdapter(PropertyDetail.this, Utility.getArrayForSpaceDetail(spaceDetail),0);
        ListView spaceDetails = (ListView) findViewById(R.id.space_detail_list);
        spaceDetails.setAdapter(genericArrayAdapter);
        genericArrayAdapter.notifyDataSetChanged();
        Utility.setListViewHeightBasedOnChildren(spaceDetails);
        Log.d(TAG, ": " + genericArrayAdapter.getCount());
    }

    private void setupBuildingSpecs() {
        BuildingSpecs buildingSpecs = new BuildingSpecs();
        buildingSpecs.setBalconyAvailable(true);
        buildingSpecs.setBuildUpArea("2000sp ft");
        buildingSpecs.setFacingDirection("North East");
        buildingSpecs.setCarPark(4);
        buildingSpecs.setFloor("3");
        buildingSpecs.setSize("4");
        GenericArrayAdapter genericArrayAdapter = new GenericArrayAdapter(PropertyDetail.this, Utility.getArrayForBuildingSpecs(buildingSpecs),0);
        ListView buildingSpecList = (ListView) findViewById(R.id.building_specs_list);
        buildingSpecList.setAdapter(genericArrayAdapter);
        genericArrayAdapter.notifyDataSetChanged();
        Utility.setListViewHeightBasedOnChildren(buildingSpecList);
        Log.d(TAG, ": " + genericArrayAdapter.getCount());
    }

    private void setupNearbyMetroStations() {
        List<MetroStation> metroStationList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            final MetroStation metroStation = new MetroStation();
            metroStation.setDistanceFromMetroStation("5 mins away");
            metroStation.setMetroStationName("Rohini" + i);
            metroStationList.add(metroStation);
        }
        GenericArrayAdapter genericArrayAdapter = new GenericArrayAdapter(PropertyDetail.this, Utility.getArrayForMetroStations(metroStationList),0);
        ListView metroStations = (ListView) findViewById(R.id.metrostations_list);
        metroStations.setAdapter(genericArrayAdapter);
        genericArrayAdapter.notifyDataSetChanged();
        Utility.setListViewHeightBasedOnChildren(metroStations);
        Log.d(TAG, ": " + genericArrayAdapter.getCount());
    }

    private void setupRestrictions() {
        List<String> restrictionList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String restriction = new String();
            restriction = "No House Party";
            restrictionList.add(restriction);
        }
        GenericArrayAdapter genericArrayAdapter = new GenericArrayAdapter(PropertyDetail.this, Utility.getArrayForRestrictions(restrictionList),0);
        ListView restrictions = (ListView) findViewById(R.id.restrictions_list);
        restrictions.setAdapter(genericArrayAdapter);
        genericArrayAdapter.notifyDataSetChanged();
        Utility.setListViewHeightBasedOnChildren(restrictions);
        Log.d(TAG, ": " + genericArrayAdapter.getCount());
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
