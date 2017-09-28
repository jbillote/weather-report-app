package com.jbillote.weatherreportapp.activity;

import com.jbillote.weatherreportapp.R;
import com.jbillote.weatherreportapp.darksky.DarkSkyAPI;
import com.jbillote.weatherreportapp.darksky.model.Forecast;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class SearchActivity extends AppCompatActivity {

    // TODO: Change to ProgressBar
    private ProgressDialog dialog;

    public static final String EXTRA_FORECAST = "com.jbillote.weatherreportapp.WEEKLY_FORECAST";

    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void searchPressed(View view) {
        ExecuteAPI executeAPI = new ExecuteAPI(this);

        this.longitude = Double.parseDouble(((EditText)findViewById(R.id.longitude)).getText().toString());
        this.latitude = Double.parseDouble(((EditText)findViewById(R.id.latitude)).getText().toString());

        executeAPI.execute(this.longitude, this.latitude);
    }

    private class ExecuteAPI extends AsyncTask<Double, Void, Forecast> {

        private Activity activity;

        ExecuteAPI(Activity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(SearchActivity.this);
            dialog.setMessage(getApplicationContext().getString(R.string.searching));
            dialog.setIndeterminate(true);
            dialog.setCancelable(true);
        }

        @Override
        protected Forecast doInBackground(Double... coordinates) {
            Forecast forecast = null;

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialog.show();
                }
            });

            try {
                forecast = DarkSkyAPI.getForecast(coordinates[0], coordinates[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return forecast;
        }

        @Override
        protected void onPostExecute(Forecast res) {
            if (res != null) {
                Gson gson = new Gson();
                String serializedForecast = gson.toJson(res);

                Intent intent = new Intent(this.activity, WeeklyForecastActivity.class);
                intent.putExtra(EXTRA_FORECAST, serializedForecast);

                dialog.dismiss();
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.search_failed), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }
    }
}
