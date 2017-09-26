package com.jbillote.weatherreportapp.darksky.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by i863247 (jeremy.billote@sap.com) on 9/26/17.
 */

public class WeeklyForecast {

    @SerializedName("summary")
    private String summary;

    @SerializedName("icon")
    private String icon;    // TODO: Maybe ignore?

    @SerializedName("data")
    private List<DailyForecast> data;

    public WeeklyForecast(String summary, String icon, List<DailyForecast> data) {
        this.summary = summary;
        this.icon = icon;
        this.data = data;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getIcon() {
        return this.icon;
    }

    public List<DailyForecast> getData() {
        return this.data;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setData(List<DailyForecast> data) {
        this.data = data;
    }
}
