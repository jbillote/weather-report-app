package com.jbillote.weatherreportapp.darksky.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by i863247 (jeremy.billote@sap.com) on 9/26/17.
 */

public class Forecast {

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("timezone")
    private String timezone;    // TODO: Maybe remove

    @SerializedName("currently")
    private CurrentConditions currently;

    @SerializedName("daily")
    private WeeklyForecast daily;

    public Forecast(double latitude, double longitude, String timezone,
                    CurrentConditions currently, WeeklyForecast daily) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.currently = currently;
        this.daily = daily;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public CurrentConditions getCurrently() {
        return this.currently;
    }

    public WeeklyForecast getDaily() {
        return this.daily;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setCurrently(CurrentConditions currently) {
        this.currently = currently;
    }

    public void setDaily(WeeklyForecast daily) {
        this.daily = daily;
    }

    /*
    // TODO: FOR DEBUGGING; Remove
    public String toString() {
        String s = "Latitude: " + this.latitude + "\nLongitude: " + this.longitude + "\nTimezone: " + this.timezone;
        s += "\nCurrently:\n\tTime: " + this.currently.getTime() + "\n\tSummary: " +
                this.currently.getSummary() + "\n\tIcon: " + this.currently.getIcon() +
                "\n\tNearest Storm DistanceL " + this.currently.getNearestStormDistance() +
                "\n\tPrecipitation Intensity: " + this.currently.getPrecipitationIntensity() +
                "\n\tPrecipitation Intensity Error" +
                this.currently.getPrecipitationIntensityError() +
                "\n\tPrecipitation Probability: " + this.currently.getPrecipitationProbability() +
                "\n\tPrecipitation Type: " + this.currently.getPrecipitationType() +
                "\n\tTemperature: " + this.currently.getTemperature() +
                "\n\tApparent Temperature: " + this.currently.getApparentTemperature() +
                "\n\tDew Point: " + this.currently.getDewPoint() +
                "\n\tHumidity: " + this.currently.getHumidity() +
                "\n\tWind Speed: " + this.currently.getWindSpeed() +
                "\n\tWind Bearing: " + this.currently.getWindBearing() +
                "\n\tVisibility: " + this.currently.getVisibility() +
                "\n\tCloud Cover: " + this.currently.getCloudCover() +
                "\n\tPressure: " + this.currently.getPressure() +
                "\n\tOzone: " + this.currently.getOzone();
        s += "\nDaily:\n\tSummary: " + this.daily.getSummary() + "\n\tIcon: " + this.daily.getIcon() + "\n\tData:";

        List<DailyForecast> l = this.daily.getData();
        for (int i = 0; i < l.size(); i++) {
            DailyForecast e = l.get(i);
            s += "\n\t\tTime: " + e.getTime() + "\n\t\tSummary: " + e.getSummary() +
                    "\n\t\tIcon: " + e.getIcon() + "\n\t\tSunrise Time: " + e.getSunriseTime() +
                    "\n\t\tSunset Time: " + e.getSunsetTime() + "\n\t\tMoon Phase: " + e.getMoonPhase() +
                    "\n\t\tPrecipitation Intensity: " + e.getPrecipitationIntensity() +
                    "\n\t\tPrecipitation Intensity Max: " + e.getPrecitipationIntensityMax() +
                    "\n\t\tPrecipitation Intensity Max Time: " + e.getprecipitationIntensityMaxTime() +
                    "\n\t\tPrecipitation Probability: " + e.getPrecipitationProbability() +
                    "\n\t\tPrecipitation Type: " + e.getPrecipitationType() +
                    "\n\t\tTemperature Min: " + e.getTemperatureMin() +
                    "\n\t\tTemperature Min Time: " + e.getApparentTemperatureMinTime() +
                    "\n\t\tTemperature Max: " + e.getTemperatureMax() +
                    "\n\t\tTemperature Max Time: " + e.getTemperatureMaxTime() +
                    "\n\t\tApparent Temperature Min: " + e.getApparentTemperatureMin() +
                    "\n\t\tApparent Temperature Min Time: " + e.getApparentTemperatureMinTime() +
                    "\n\t\tApparent Temperature Max: " + e.getApparentTemperatureMax() +
                    "\n\t\tApparent Temperature Max Time: " + e.getApparentTemperatureMaxTime() +
                    "\n\t\tDew Point: " + e.getDewPoint() +
                    "\n\t\tHumidity: " + e.getHumidity() +
                    "\n\t\tWind Speed: " + e.getWindSpeed() +
                    "\n\t\tWind Bearing: " + e.getWindBearing() +
                    "\n\t\tVisibility: " + e.getVisibility() +
                    "\n\t\tCloud Cover: " + e.getCloudCover() +
                    "\n\t\tPressure: " + e.getPressure() +
                    "\n\t\tOzone: " + e.getOzone() + "\n";
        }

        return s;
    }
    */
}
