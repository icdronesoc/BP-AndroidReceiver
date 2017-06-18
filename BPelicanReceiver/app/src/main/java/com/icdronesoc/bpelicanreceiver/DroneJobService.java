package com.icdronesoc.bpelicanreceiver;

/**
 * Created by Conoha Concordia on 18/06/2017.
 */

import android.util.Log;



import com.firebase.jobdispatcher.JobParameters;

import com.firebase.jobdispatcher.JobService;



public class DroneJobService extends JobService {



    private static final String TAG = "MyJobService";



    @Override

    public boolean onStartJob(JobParameters jobParameters) {

        Log.d(TAG, "Performing long running task in scheduled job");

        // TODO(developer): add long running task here.

        return false;

    }



    @Override

    public boolean onStopJob(JobParameters jobParameters) {

        return false;

    }



}