package com.kovaxarny.trifit.notifications;

import android.content.Context;
import android.support.annotation.NonNull;

import com.firebase.jobdispatcher.Driver;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

import java.util.concurrent.TimeUnit;

/**
 * Created by kovax on 2018-03-26.
 */

public class ReminderUtilities {
    //TODO change these numbers so reminder comes daily. and new reminder for data logging
    private static final int INTERVAL_MINUTES = 10;
    private static final int INTERVAL_SECONDS = (int) (TimeUnit.MINUTES.toSeconds(INTERVAL_MINUTES));

    private static final int LOGGING_REMINDER_INTERVAL_SECONDS = (int) TimeUnit.DAYS.toSeconds(7);
    private static final int WORKOUT_REMINDER_INTERVAL_SECONDS = (int) TimeUnit.HOURS.toSeconds(24);

    private static final String LOGGING_REMINDER_JOB_TAG = "logging_reminder_job";
    private static final String WORKOUT_REMINDER_JOB_TAG = "workout_reminder_job";

    private static boolean loggingReminderInitialized;
    private static boolean workoutReminderInitialized;

    synchronized public static void scheduleWorkoutReminder(@NonNull final Context context) {

        if (workoutReminderInitialized) return;

        Driver driver = new GooglePlayDriver(context);
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);

        Job constraintReminderJob = dispatcher.newJobBuilder()
                .setService(WorkoutReminderJobService.class)
                .setTag(WORKOUT_REMINDER_JOB_TAG)
                .setLifetime(Lifetime.FOREVER)
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(
                        WORKOUT_REMINDER_INTERVAL_SECONDS,
                        WORKOUT_REMINDER_INTERVAL_SECONDS + INTERVAL_SECONDS))
                .setReplaceCurrent(true)
                .build();

        dispatcher.schedule(constraintReminderJob);

        workoutReminderInitialized = true;
    }

    synchronized public static void cancelWorkoutReminder(@NonNull final Context context){
        if (!workoutReminderInitialized) return;

        Driver driver = new GooglePlayDriver(context);
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);

        dispatcher.cancel(WORKOUT_REMINDER_JOB_TAG);

        workoutReminderInitialized = false;
    }

    synchronized public static void scheduleLoggingReminder(@NonNull final Context context) {

        if (loggingReminderInitialized) return;

        Driver driver = new GooglePlayDriver(context);
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);

        Job constraintReminderJob = dispatcher.newJobBuilder()
                .setService(WorkoutReminderJobService.class)
                .setTag(LOGGING_REMINDER_JOB_TAG)
                .setLifetime(Lifetime.FOREVER)
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(
                        LOGGING_REMINDER_INTERVAL_SECONDS,
                        LOGGING_REMINDER_INTERVAL_SECONDS + INTERVAL_SECONDS))
                .setReplaceCurrent(true)
                .build();

        dispatcher.schedule(constraintReminderJob);

        loggingReminderInitialized = true;
    }

    synchronized public static void cancelLoggingReminder(@NonNull final Context context){
        if (!loggingReminderInitialized) return;

        Driver driver = new GooglePlayDriver(context);
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);

        dispatcher.cancel(LOGGING_REMINDER_JOB_TAG);

        loggingReminderInitialized = false;
    }

}
