package com.jbillote.weatherreportapp.activity;

import com.jbillote.weatherreportapp.darksky.model.DailyForecast;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jbillote.weatherreportapp.R;

public class DailyForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        LoadForecast asyncTask = new LoadForecast((ProgressBar)findViewById(R.id.forecast_loading));
        asyncTask.execute();
    }

    private class LoadForecast extends AsyncTask<Void, Void, Void> {

        private ProgressBar progressBar;

        public LoadForecast(ProgressBar progressBar) {
            this.progressBar = progressBar;
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected Void doInBackground(Void... unused) {
            Gson gson = new Gson();
            DailyForecast forecast = gson.fromJson(getIntent().getStringExtra(WeeklyForecastActivity.EXTRA_FORECAST), DailyForecast.class);

            // Initialize all values so UI thread doesn't do any accessing
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE, MMM. dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            final String day = dayFormat.format(new Date(forecast.getTime() * 1000));
            final String summary = forecast.getSummary();
            final String high = String.valueOf(Math.round(forecast.getTemperatureMax())) + "\u2109";
            final String low = String.valueOf(Math.round(forecast.getTemperatureMin())) + "\u2109";
            final String sunriseSunset = timeFormat.format(new Date(forecast.getSunriseTime() * 1000)) + " / " + timeFormat.format(new Date(forecast.getSunsetTime() * 1000));
            final String precipChance = String.valueOf((int)(forecast.getPrecipitationProbability() * 100)) + "%" + (forecast.getPrecipitationType() != null ?  " chance of " + forecast.getPrecipitationType() + "." : "");

            String iconName = forecast.getIcon();
            int iconId;
            switch (iconName) {
                case "clear-day":
                    iconId = R.drawable.clear_day;
                    break;
                case "clear-night":
                    iconId = R.drawable.clear_night;
                    break;
                case "rain:":
                    iconId = R.drawable.rain;
                    break;
                case "snow":
                    iconId = R.drawable.snow;
                    break;
                case "sleet":
                    iconId = R.drawable.snow;
                    break;
                case "wind":
                    iconId = R.drawable.wind;
                    break;
                case "fog":
                    iconId = R.drawable.fog;
                    break;
                case "cloudy":
                    iconId = R.drawable.cloudy;
                    break;
                case "partly-cloudy-day":
                    iconId = R.drawable.partly_cloudy_day;
                    break;
                case "partly-cloudy-night":
                    iconId = R.drawable.partly_cloudy_night;
                    break;
                default:
                    iconId = R.drawable.clear_day;
                    break;
            }
            final Drawable icon = getResources().getDrawable(iconId, null);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((TextView)findViewById(R.id.forecast_day)).setText(day);
                    ((TextView)findViewById(R.id.forecast_summary)).setText(summary);
                    ((TextView)findViewById(R.id.temp_high_text)).setText(high);
                    ((TextView)findViewById(R.id.temp_low_text)).setText(low);
                    ((TextView)findViewById(R.id.sunrise_sunset_times)).setText(sunriseSunset);
                    ((TextView)findViewById(R.id.precip_chance_text)).setText(precipChance);
                    ((ImageView)findViewById(R.id.forecast_icon)).setImageDrawable(icon);
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            ((TextView)findViewById(R.id.forecast_day)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.forecast_summary)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.temp_high_label)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.temp_high_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.temp_low_label)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.temp_low_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.sunrise_sunset_label)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.sunrise_sunset_times)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.precip_chance_label)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.precip_chance_text)).setVisibility(View.VISIBLE);
            ((ImageView)findViewById(R.id.forecast_icon)).setVisibility(View.VISIBLE);

            this.progressBar.setVisibility(View.GONE);
        }
    }
}
