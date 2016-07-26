package com.technawabs.openhouz.models;

import android.location.Location;

import java.util.List;

public class PropertyDetail {

    private long id;
    private String locationName;
    private String price;
    private SpaceDetail spaceDetail;
    private BuildingSpecs buildingSpecs;
    private List<MetroStation> metroStations;
    private List<String> restrictions;
    private Location location;
    private boolean isFavorite;
    private String propertyImageUrl;
    private String propertyBHK;
    private String propertyTitle;
    private String propertyLocation;
    private transient int cardType;
    private transient PropertyViewing propertyViewing;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getPropertyImageUrl() {
        return this.propertyImageUrl;
    }

    public void setPropertyImageUrl(String propertyImageUrl) {
        this.propertyImageUrl = propertyImageUrl;
    }

    public String getPropertyBHK() {
        return this.propertyBHK;
    }

    public void setPropertyBHK(String propertyBHK) {
        this.propertyBHK = propertyBHK;
    }

    public String getPropertyTitle() {
        return this.propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public String getPropertyLocation() {
        return this.propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public int getCardType() {
        return this.cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public PropertyViewing getPropertyViewing() {
        return this.propertyViewing;
    }

    public void setPropertyViewing(PropertyViewing propertyViewing) {
        this.propertyViewing = propertyViewing;
    }
}
