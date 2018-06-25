package com.example.asus.demmi;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class Notifications {

    String TAG = "Restaurant a proximité !";

    public void notifier(Context context, CharSequence message, int number){

        // The intent to launch when the user clicks the notification
        Intent intent = new Intent(context, MainActivity.class);

        // Here we build our notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle("Restaurant a proximité !") // Notification title
                .setContentText(message) // Notification message
                .setNumber(number) // The notification number
                .setSmallIcon(R.mipmap.ic_launcher) // The notification icon
                .setAutoCancel(true) // The notification must be gone when the user clicks on it
                .setContentIntent(PendingIntent // The intent to call when the user clicks on the notification
                        .getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT));

        // We create a notification manager to send the notification
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // Now we send the notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            nm.notify(TAG, 0, builder.build());
        }else{
            nm.notify(TAG.hashCode(), builder.build());
        }
    }

}
