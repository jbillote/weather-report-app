package com.jbillote.weatherreportapp.darksky;

import com.jbillote.weatherreportapp.darksky.model.CurrentConditions;
import com.jbillote.weatherreportapp.darksky.model.DailyForecast;
import com.jbillote.weatherreportapp.darksky.model.Forecast;
import com.jbillote.weatherreportapp.darksky.model.WeeklyForecast;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by i863247 (jeremy.billote@sap.com) on 9/26/17.
 */

/**
 * This class is a wrapper for the Dark Sky weather API.
 *
 * @author Jeremy Billote
 */

public class DarkSkyAPI {

    private static String API_KEY = "caf90d01ee454fdbd98a7cb108f4fce7";

    // "Override" default constructor to forbid instantiability
    private DarkSkyAPI() {}

    public static Forecast getForecast(double longitude, double latitude) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String requestUrl = "https://api.darksky.net/forecast/" + API_KEY + "/" + longitude + "," + latitude;

        System.out.println(requestUrl);

        Request request = new Request.Builder().url(requestUrl).build();

        Reader reader = new InputStreamReader(client.newCall(request).execute().body().source().inputStream());
        Gson gson = new Gson();
        Forecast forecast = gson.fromJson(reader, Forecast.class);

        System.out.println(forecast.toString());

        return null;
    }
}
