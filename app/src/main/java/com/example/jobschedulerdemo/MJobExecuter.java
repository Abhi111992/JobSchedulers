package com.example.jobschedulerdemo;

import android.os.AsyncTask;

public class MJobExecuter extends AsyncTask<Void,Void,String> {
   /* @Override
    protected String doInBackground() {
        return doInBackground();
    }*/

    @Override
    protected String doInBackground(Void... voids) {
        return "Back Ground Long Running Task Finishers...";
    }

   /* protected String doInBackground(String... params) {
        return "Back Ground Long Running Task Finishers...";
    }*/

}