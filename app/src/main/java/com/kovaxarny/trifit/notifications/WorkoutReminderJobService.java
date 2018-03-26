package com.kovaxarny.trifit.notifications;

import android.content.Context;
import android.os.AsyncTask;

import com.firebase.jobdispatcher.JobParameters;
import com.kovaxarny.trifit.utilities.NotificationUtil;

/**
 * Created by kovax on 2018-03-26.
 */

public class WorkoutReminderJobService extends com.firebase.jobdispatcher.JobService{
    private AsyncTask mBackgroundTask;

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        mBackgroundTask = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] params) {
                Context context = WorkoutReminderJobService.this;
                NotificationUtil.executeTask(context, NotificationUtil.ACTION_WORKOUT_REMINDER);
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                jobFinished(jobParameters, false);
            }
        };

        mBackgroundTask.execute();
        return true;
    }
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        if (mBackgroundTask != null) mBackgroundTask.cancel(true);
        return true;
    }
}
