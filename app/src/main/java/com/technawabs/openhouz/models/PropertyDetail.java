package com.technawabs.openhouz.models;

import android.location.Location;

import java.util.List;

public class PropertyDetail {

    private String locationName;
    private String price;
    private SpaceDetail spaceDetail;
    private BuildingSpecs buildingSpecs;
    private List<MetroStation> metroStations;
    private List<String> restrictions;
    private Location location;
    private boolean isFavorite;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SpaceDetail getSpaceDetail() {
        return spaceDetail;
    }

    public void setSpaceDetail(SpaceDetail spaceDetail) {
        this.spaceDetail = spaceDetail;
    }

    public BuildingSpecs getBuildingSpecs() {
        return buildingSpecs;
    }

    public void setBuildingSpecs(BuildingSpecs buildingSpecs) {
        this.buildingSpecs = buildingSpecs;
    }

    public List<MetroStation> getMetroStations() {
        return metroStations;
    }

    public void setMetroStations(List<MetroStation> metroStations) {
        this.metroStations = metroStations;
    }

    public List<String> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<String> restrictions) {
        this.restrictions = restrictions;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
