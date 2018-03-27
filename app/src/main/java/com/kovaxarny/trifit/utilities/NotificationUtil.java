package com.kovaxarny.trifit.utilities;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.kovaxarny.trifit.AddBodyStatActivity;
import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.drawer.WorkoutProgramsActivity;

/**
 * Created by kovax on 2018-03-18.
 */

public class NotificationUtil{

    public static final int WORKOUT_REMINDER_NOTIFICATION_ID = 1138;
    public static final int LOGGING_REMINDER_NOTIFICATION_ID = 1139;

    public static final int WORKOUT_REMINDER_PENDING_INTENT_ID = 3417;
    public static final int LOGGING_REMINDER_PENDING_INTENT_ID = 3417;

    public static final int ACTION_IGNORE_PENDING_INTENT_ID = 14;

    public static final String WORKOUT_REMINDER_NOTIFICATION_CHANNEL_ID = "reminder_notification_channel";

    public static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notification";
    public static final String ACTION_WORKOUT_REMINDER = "workout-reminder";
    public static final String ACTION_LOGGING_REMINDER = "logging-reminder";


    public static void remindUserToWorkout(Context context) {
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    WORKOUT_REMINDER_NOTIFICATION_CHANNEL_ID,
                    context.getString(R.string.main_notification_channel_name),
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context, WORKOUT_REMINDER_NOTIFICATION_CHANNEL_ID)
                        .setColor(ContextCompat.getColor(context, R.color.primary))
                        .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
                        .setLargeIcon(largeRunIcon(context))
                        .setContentTitle(context.getString(R.string.workout_reminder_notification_title))
                        .setContentText(context.getString(R.string.workout_reminder_notification_body))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(
                                context.getString(R.string.workout_reminder_notification_body)))
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setContentIntent(contentWorkoutIntent(context))
                        .addAction(ignoreReminderAction(context))
                        .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        }

        notificationManager.notify(WORKOUT_REMINDER_NOTIFICATION_ID, notificationBuilder.build());
    }

    public static void remindUserToLog(Context context) {
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    WORKOUT_REMINDER_NOTIFICATION_CHANNEL_ID,
                    context.getString(R.string.main_notification_channel_name),
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context, WORKOUT_REMINDER_NOTIFICATION_CHANNEL_ID)
                        .setColor(ContextCompat.getColor(context, R.color.primary))
                        .setSmallIcon(R.drawable.ic_action_log_weight)
                        .setLargeIcon(largeLogIcon(context))
                        .setContentTitle(context.getString(R.string.log_reminder_notification_title))
                        .setContentText(context.getString(R.string.log_reminder_notification_body))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(
                                context.getString(R.string.log_reminder_notification_body)))
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setContentIntent(contentLoggingIntent(context))
                        .addAction(ignoreReminderAction(context))
                        .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        }

        notificationManager.notify(LOGGING_REMINDER_NOTIFICATION_ID, notificationBuilder.build());
    }

    private static NotificationCompat.Action ignoreReminderAction(Context context) {
        Intent ignoreReminderIntent = new Intent(context, WorkoutReminderIntentService.class);
        ignoreReminderIntent.setAction(ACTION_DISMISS_NOTIFICATION);

        PendingIntent ignoreReminderPendingIntent = PendingIntent.getService(
                context,
                ACTION_IGNORE_PENDING_INTENT_ID,
                ignoreReminderIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Action ignoreReminderAction = new NotificationCompat.Action(R.drawable.ic_cancel,
                "Nah... maybe later",
                ignoreReminderPendingIntent);
        return ignoreReminderAction;
    }

    private static PendingIntent contentWorkoutIntent(Context context) {
        Intent startActivityIntent = new Intent(context, WorkoutProgramsActivity.class);

        return PendingIntent.getActivity(
                context,
                WORKOUT_REMINDER_PENDING_INTENT_ID,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private static PendingIntent contentLoggingIntent(Context context) {
        Intent startActivityIntent = new Intent(context, AddBodyStatActivity.class);

        return PendingIntent.getActivity(
                context,
                WORKOUT_REMINDER_PENDING_INTENT_ID,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static void executeTask(Context context, String action) {
        if (ACTION_DISMISS_NOTIFICATION.equals(action)) {
            clearAllNotifications(context);
        } else if (ACTION_WORKOUT_REMINDER.equals(action)){
            issueWorkoutReminder(context);
        } else if (ACTION_LOGGING_REMINDER.equals(action)){
            issueLoggingReminder(context);
        }
    }

    private static void issueLoggingReminder(Context context) {
        NotificationUtil.remindUserToLog(context);
    }

    private static void issueWorkoutReminder(Context context) {
        NotificationUtil.remindUserToWorkout(context);
    }

    private static void clearAllNotifications(Context context) {
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }

    private static Bitmap largeRunIcon(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_directions_run_black_24dp);
    }

    private static Bitmap largeLogIcon(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_action_log_weight);
    }



    public static class WorkoutReminderIntentService extends IntentService {

        public WorkoutReminderIntentService(String name) {
            super(name);
        }

        public WorkoutReminderIntentService() {
            super("Workout ReminderIntentService");
        }

        @Override
        protected void onHandleIntent(Intent intent) {
            String action = intent.getAction();
            executeTask(this, action);
        }
    }
}
