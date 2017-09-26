package com.jbillote.weatherreportapp.darksky.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by i863247 (jeremy.billote@sap.com) on 9/26/17.
 */

public class DailyForecast {

    @SerializedName("time")
    private long time;
    
    @SerializedName("summary")
    private String summary;
    
    @SerializedName("icon")
    private String icon;    // TODO: Maybe remove?
    
    @SerializedName("sunriseTime")
    private long sunriseTime;
    
    @SerializedName("sunsetTime")
    private long sunsetTime;
    
    @SerializedName("moonPhase")
    private float moonPhase;
    
    @SerializedName("precipIntensity")
    private float precipitationIntensity;
    
    @SerializedName("precipIntensityMax")
    private float precitipationIntensityMax;
    
    @SerializedName("precipIntensityMaxTime")
    private long precipitationIntensityMaxTime;

    @SerializedName("precipProbability")
    private float precipitationProbability;

    @SerializedName("precipType")
    private String precipitationType;

    @SerializedName("temperatureMin")
    private float temperatureMin;

    @SerializedName("temperatureMax")
    private float temperatureMax;

    @SerializedName("temperatureMaxTime")
    private long temperatureMaxTime;

    @SerializedName("apparentTemperatureMin")
    private float apparentTemperatureMin;

    @SerializedName("apparentTemperatureMinTime")
    private long apparentTemperatureMinTime;

    @SerializedName("apparentTemperatureMax")
    private float apparentTemperatureMax;

    @SerializedName("apparentTemperatureMaxTime")
    private long apparentTemperatureMaxTime;

    @SerializedName("dewPoint")
    private float dewPoint;

    @SerializedName("humidity")
    private float humidity;

    @SerializedName("windSpeed")
    private float windSpeed;

    @SerializedName("windBearing")
    private long windBearing;   // TODO: Maybe float

    @SerializedName("visibility")
    private float visibility;

    @SerializedName("cloudCover")
    private float cloudCover;

    @SerializedName("pressure")
    private float pressure;

    @SerializedName("ozone")
    private float ozone;

    public DailyForecast(long time, String summary, String icon, long sunriseTime, long sunsetTime,
                         float moonPhase, float precipitationIntensity,
                         float precitipationIntensityMax, long precipitationIntensityMaxTime,
                         float precipitationProbability, String precipitationType,
                         float temperatureMin, float temperatureMax, long temperatureMaxTime,
                         float apparentTemperatureMin, long apparentTemperatureMinTime,
                         float apparentTemperatureMax, long apparentTemperatureMaxTime,
                         float dewPoint, float humidity, float windSpeed, long windBearing,
                         float visibility, float cloudCover, float pressure, float ozone) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
        this.precipitationIntensity = precipitationIntensity;
        this.precitipationIntensityMax = precitipationIntensityMax;
        this.precipitationIntensityMaxTime = precipitationIntensityMaxTime;
        this.precipitationProbability = precipitationProbability;
        this.precipitationType = precipitationType;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.temperatureMaxTime = temperatureMaxTime;
        this.apparentTemperatureMin = apparentTemperatureMin;
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        this.apparentTemperatureMax = apparentTemperatureMax;
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
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

    public long getSunriseTime() {
        return this.sunriseTime;
    }

    public long getSunsetTime() {
        return this.sunsetTime;
    }

    public float getMoonPhase() {
        return this.moonPhase;
    }

    public float getPrecipitationIntensity() {
        return this.precipitationIntensity;
    }

    public float getPrecitipationIntensityMax() {
        return this.precitipationIntensityMax;
    }

    public long getprecipitationIntensityMaxTime() {
        return this.precipitationIntensityMaxTime;
    }

    public float getPrecipitationProbability() {
        return this.precipitationProbability;
    }

    public String getPrecipitationType() {
        return this.precipitationType;
    }

    public float getTemperatureMin() {
        return this.temperatureMin;
    }

    public float getTemperatureMax() {
        return this.temperatureMax;
    }

    public long getTemperatureMaxTime() {
        return this.temperatureMaxTime;
    }

    public float getApparentTemperatureMin() {
        return this.apparentTemperatureMin;
    }

    public long getApparentTemperatureMinTime() {
        return this.apparentTemperatureMinTime;
    }

    public float getApparentTemperatureMax() {
        return this.apparentTemperatureMax;
    }

    public long getApparentTemperatureMaxTime() {
        return this.apparentTemperatureMaxTime;
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

    public long getWindBearing() {
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

    public void setSunriseTime(long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public void setSunsetTime(long sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public void setMoonPhase(float moonPhase) {
        this.moonPhase = moonPhase;
    }

    public void setPrecipitationIntensity(float precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }

    public void setPrecitipationIntensityMax(float precitipationIntensityMax) {
        this.precitipationIntensityMax = precitipationIntensityMax;
    }

    public void setprecipitationIntensityMaxTime(long precipitationIntensityMaxTime) {
        this.precipitationIntensityMaxTime = precipitationIntensityMaxTime;
    }

    public void setPrecipitationProbability(float precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public void setTemperatureMin(float temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public void setTemperatureMax(float temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public void setTemperatureMaxTime(long temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public void setApparentTemperatureMin(float apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public void setApparentTemperatureMinTime(long apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMax(float apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public void setApparentTemperatureMaxTime(long apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
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

    public void setWindBearing(long windBearing) {
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
