package com.jbillote.weatherreportapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // TODO: Change to ProgressBar
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchPressed(View view) {
        ExecuteAPI executeAPI = new ExecuteAPI();
        executeAPI.execute();
    }

    private class ExecuteAPI extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage(getApplicationContext().getString(R.string.searching));
            dialog.setIndeterminate(true);
            dialog.setCancelable(true);
        }

        @Override
        protected Void doInBackground(Void... unused) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialog.show();
                }
            });

            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            dialog.dismiss();
        }
    }
}
