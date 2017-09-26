package com.jbillote.weatherreportapp.darksky.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by i863247 (jeremy.billote@sap.com) on 9/26/17.
 */

public class CurrentConditions {

    @SerializedName("time")
    private long time;

    @SerializedName("summary")
    private String summary;

    @SerializedName("icon")
    private String icon;    // TODO: Maybe ignore this?

    @SerializedName("nearestStormDistance")
    private float nearestStormDistance;    // TODO: Maybe long?

    @SerializedName("precipIntensity")
    private float precipitationIntensity;

    @SerializedName("precipIntensityError")
    private float precipitationIntensityError;

    @SerializedName("precipProbability")
    private float precipitationProbability;

    @SerializedName("precipType")
    private String precipitationType;

    @SerializedName("temperature")
    private float temperature; // TODO: Figure out units

    @SerializedName("apparentTemperature")
    private float apparentTemperature;

    @SerializedName("dewPoint")
    private float dewPoint;

    @SerializedName("humidity")
    private float humidity;

    @SerializedName("windSpeed")
    private float windSpeed;

    @SerializedName("windBearing")
    private float windBearing; // TODO: Maybe long?

    @SerializedName("visibility")
    private float visibility;

    @SerializedName("cloudCover")
    private float cloudCover;

    @SerializedName("pressure")
    private float pressure;

    @SerializedName("ozone")
    private float ozone;

    public CurrentConditions(long time, String summary, String icon, float nearestStormDistance,
                             float precipitationIntensity, float precipitationIntensityError,
                             float precipitationProbability, String precipitationType,
                             float temperature, float apparentTemperature, float dewPoint,
                             float humidity, float windSpeed, float windBearing, float visibility,
                             float cloudCover, float pressure, float ozone) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.nearestStormDistance = nearestStormDistance;
        this.precipitationIntensity = precipitationIntensity;
        this.precipitationIntensityError = precipitationIntensityError;
        this.precipitationProbability = precipitationProbability;
        this.precipitationType = precipitationType;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windBearing = windBearing;
        this.visibility = visibility;
        this.cloudCover = cloudCover;
        this.pressure = pressure;
        this.ozone = ozone;
    }

    public long getTime() {
        return this.time;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getIcon() {
        return this.icon;
    }

    public float getNearestStormDistance() {
        return this.nearestStormDistance;
    }

    public float getPrecipitationIntensity() {
        return this.precipitationIntensity;
    }

    public float getPrecipitationIntensityError() {
        return this.precipitationIntensityError;
    }

    public float getPrecipitationProbability() {
        return this.precipitationProbability;
    }

    public String getPrecipitationType() {
        return this.precipitationType;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getApparentTemperature() {
        return this.apparentTemperature;
    }

    public float getDewPoint() {
        return this.dewPoint;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public float getWindSpeed() {
        return this.windSpeed;
    }

    public float getWindBearing() {
        return this.windBearing;
    }

    public float getVisibility() {
        return this.visibility;
    }

    public float getCloudCover() {
        return this.cloudCover;
    }

    public float getPressure() {
        return this.pressure;
    }

    public float getOzone() {
        return this.ozone;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setNearestStormDistance(float nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public void setPrecipitationIntensity(float precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }

    public void setPrecipitationIntensityError(float precipitationIntensityError) {
        this.precipitationIntensityError = precipitationIntensityError;
    }

    public void setPrecipitationProbability(float precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setApparentTemperature(float apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public void setDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindBearing(float windBearing) {
        this.windBearing = windBearing;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public void setCloudCover(float cloudCover) {
        this.cloudCover = cloudCover;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setOzone(float ozone) {
        this.ozone = ozone;
    }
}
