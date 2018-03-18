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

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.drawer.WorkoutProgramsActivity;

/**
 * Created by kovax on 2018-03-18.
 */

public class NotificationUtil {

    private static final int WORKOUT_REMINDER_NOTIFICATION_ID = 1138;
    private static final int WORKOUT_REMINDER_PENDING_INTENT_ID = 3417;

    private static final int ACTION_IGNORE_PENDING_INTENT_ID = 14;

    private static final String WORKOUT_REMINDER_NOTIFICATION_CHANNEL_ID = "reminder_notification_channel";
    private static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notification";


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
                        .setLargeIcon(largeIcon(context))
                        .setContentTitle(context.getString(R.string.workout_reminder_notification_title))
                        .setContentText(context.getString(R.string.workout_reminder_notification_body))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(
                                context.getString(R.string.workout_reminder_notification_body)))
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setContentIntent(contentIntent(context))
                        .addAction(ignoreReminderAction(context))
                        .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        }

        notificationManager.notify(WORKOUT_REMINDER_NOTIFICATION_ID, notificationBuilder.build());
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

    public static void clearAllNotifications(Context context) {
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }

    private static PendingIntent contentIntent(Context context) {
        Intent startActivityIntent = new Intent(context, WorkoutProgramsActivity.class);

        return PendingIntent.getActivity(
                context,
                WORKOUT_REMINDER_PENDING_INTENT_ID,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private static Bitmap largeIcon(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_directions_run_black_24dp);
    }

    private static void executeTask(Context context, String action) {
        if (ACTION_DISMISS_NOTIFICATION.equals(action)) {
            clearAllNotifications(context);
        }
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
