package com.jbillote.weatherreportapp.activity;

import com.jbillote.weatherreportapp.darksky.model.DailyForecast;
import com.jbillote.weatherreportapp.darksky.model.Forecast;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jbillote.weatherreportapp.R;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeeklyForecastActivity extends AppCompatActivity {

    public static String EXTRA_FORECAST = "com.jbillote.weatherreportapp.DAILY_FORECAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_forecast);

        PopulateList populateList = new PopulateList(this, (ProgressBar)findViewById(R.id.loading), (ListView)findViewById(R.id.daysList));
        populateList.execute();
    }

    private class PopulateList extends AsyncTask<Void, Void, DailyForecastAdapter> {

        private Activity activity;
        private ProgressBar progressBar;
        private ListView listView;

        public PopulateList(Activity activity, ProgressBar progressBar, ListView listView) {
            this.activity = activity;
            this.progressBar = progressBar;
            this.listView = listView;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected DailyForecastAdapter doInBackground(Void... unused) {
            // Deserialize forecast data
            Gson gson = new Gson();
            Forecast forecast = gson.fromJson(getIntent().getStringExtra(SearchActivity.EXTRA_FORECAST), Forecast.class);
            List<DailyForecast> days = new ArrayList<>(forecast.getDaily().getData());

            return new DailyForecastAdapter(this.activity, days);
        }

        @Override
        protected void onPostExecute(DailyForecastAdapter res) {
            this.progressBar.setVisibility(View.GONE);

            this.listView.setAdapter(res);
            this.listView.setVisibility(View.VISIBLE);
        }
    }

    private class DailyForecastAdapter extends ArrayAdapter<DailyForecast> {

        private class DailyForecastClickListener implements View.OnClickListener {

            private Activity activity;
            private DailyForecast forecast;

            public DailyForecastClickListener(Activity activity, DailyForecast forecast) {
                this.activity = activity;
                this.forecast = forecast;
            }

            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String serializedForecast = gson.toJson(this.forecast);

                Intent intent = new Intent(this.activity, DailyForecastActivity.class);
                intent.putExtra(EXTRA_FORECAST, serializedForecast);

                startActivity(intent);
            }
        }

        private Activity activity;

        public DailyForecastAdapter(Activity activity, List<DailyForecast> data) {
            super(WeeklyForecastActivity.this, R.layout.daily_forecast_item, data);
            this.activity = activity;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DailyForecast forecast = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.daily_forecast_item, parent, false);
            }

            String day;
            if (DateUtils.isToday(forecast.getTime() * 1000)) {
                day = "Today";
            } else {
                SimpleDateFormat format = new SimpleDateFormat("EEEE, MMM. dd");
                day = format.format(new Date(forecast.getTime() * 1000));
            }

            int iconId;
            String iconName = forecast.getIcon();
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

            ((TextView)convertView.findViewById(R.id.day)).setText(day);
            ((TextView)convertView.findViewById(R.id.summary)).setText(forecast.getSummary());
            ((ImageView)convertView.findViewById(R.id.icon)).setImageDrawable(getResources().getDrawable(iconId, null));
            ((TextView)convertView.findViewById(R.id.tempHigh)).setText(String.valueOf(Math.round(forecast.getTemperatureMax())));
            ((TextView)convertView.findViewById(R.id.tempLow)).setText(String.valueOf(Math.round(forecast.getTemperatureMin())));

            convertView.setOnClickListener(new DailyForecastClickListener(this.activity, forecast));

            return convertView;
        }
    }
}
