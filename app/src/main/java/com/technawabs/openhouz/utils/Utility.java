package com.technawabs.openhouz.utils;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.models.BuildingSpecs;
import com.technawabs.openhouz.models.GenericArrayItem;
import com.technawabs.openhouz.models.Message;
import com.technawabs.openhouz.models.MetroStation;
import com.technawabs.openhouz.models.SpaceDetail;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static Message userSentMessage(String message) {
        final Message userMessage = new Message();
        userMessage.setMessage(message);
        userMessage.setSender(OpenHouzConstants.Sender.USER);
        return userMessage;
    }

    public static Message sendMessage(String message, String sender) {
        final Message botMessage = new Message();
        botMessage.setMessage(message);
        botMessage.setSender(sender);
        return botMessage;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public static void setListViewHeightBasedOnChildrenHalf(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight() / 5;
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public static void setListViewHeightBasedOnChildrenHalff(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight() / 1.8;
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public static List<GenericArrayItem> getArrayForSpaceDetail(SpaceDetail spaceDetail) {
        List<GenericArrayItem> genericArrayItemList = new ArrayList<>();
        GenericArrayItem propertyAvailableDate = new GenericArrayItem("Available From", spaceDetail.getAvailableDate());
        GenericArrayItem propertyDeposit = new GenericArrayItem("Deposit", spaceDetail.getDeposit());
        GenericArrayItem propertyNumOfBedrooms = new GenericArrayItem("Bedrooms", "" + spaceDetail.getNumOfBedrooms());
        GenericArrayItem propertyNumOfBathrooms = new GenericArrayItem("Bathrooms", spaceDetail.getAvailableDate());
        GenericArrayItem propertyType = new GenericArrayItem("Property Type", spaceDetail.getPropertyType());
        GenericArrayItem propertyHelperRoom = new GenericArrayItem("Helper's room", String.valueOf(spaceDetail.isHelperRoomAvailable));
        GenericArrayItem propertyFurnished = new GenericArrayItem("Furnished", String.valueOf(spaceDetail.isFurnished));
        GenericArrayItem propertyGasPipeline = new GenericArrayItem("Gas Pipeline", String.valueOf(spaceDetail.isGasPipelineAvailable));
        GenericArrayItem propertyMinimumStay = new GenericArrayItem("Minimum Stay", "5 days");
        genericArrayItemList.add(propertyNumOfBedrooms);
        genericArrayItemList.add(propertyNumOfBathrooms);
        genericArrayItemList.add(propertyFurnished);
        genericArrayItemList.add(propertyType);
        genericArrayItemList.add(propertyAvailableDate);
        genericArrayItemList.add(propertyHelperRoom);
        genericArrayItemList.add(propertyGasPipeline);
        genericArrayItemList.add(propertyDeposit);
        genericArrayItemList.add(propertyMinimumStay);
        return genericArrayItemList;
    }

    public static List<GenericArrayItem> getArrayForBuildingSpecs(BuildingSpecs buildingSpecs) {
        List<GenericArrayItem> genericArrayItemList = new ArrayList<>();
        GenericArrayItem balcony = new GenericArrayItem("Balcony", buildingSpecs.isBalconyAvailable() ? "Yes" : "No");
        GenericArrayItem buildUpArea = new GenericArrayItem("Build-Up Area", buildingSpecs.getBuildUpArea());
        GenericArrayItem facing = new GenericArrayItem("Facing", buildingSpecs.getFacingDirection());
        GenericArrayItem carpark = new GenericArrayItem("Carpark", "" + buildingSpecs.getCarPark());
        GenericArrayItem floor = new GenericArrayItem("Floor", buildingSpecs.getFloor());
        GenericArrayItem size = new GenericArrayItem("Size", buildingSpecs.getSize());
        genericArrayItemList.add(balcony);
        genericArrayItemList.add(buildUpArea);
        genericArrayItemList.add(facing);
        genericArrayItemList.add(carpark);
        genericArrayItemList.add(floor);
        genericArrayItemList.add(size);
        return genericArrayItemList;
    }

    public static List<GenericArrayItem> getArrayForMetroStations(List<MetroStation> metroStations) {
        List<GenericArrayItem> genericArrayItemList = new ArrayList<>();
        for (int i = 0; i < metroStations.size(); i++) {
            MetroStation metroStation = new MetroStation();
            metroStation = metroStations.get(i);
            final GenericArrayItem genericArrayItem = new GenericArrayItem(metroStation.getMetroStationName(), metroStation.getDistanceFromMetroStation());
            genericArrayItemList.add(genericArrayItem);
        }
        return genericArrayItemList;
    }

    public static List<GenericArrayItem> getArrayForRestrictions(List<String> restrictions) {
        List<GenericArrayItem> genericArrayItemList = new ArrayList<>();
        for (int i = 0; i < restrictions.size(); i++) {
            String restriction = new String();
            restriction = restrictions.get(i);
            final GenericArrayItem genericArrayItem = new GenericArrayItem(restriction, "");
            genericArrayItemList.add(genericArrayItem);
        }
        return genericArrayItemList;
    }

    public static SpannableString getUnderlinedText(String text) {
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        return spannableString;
    }
}
