package com.example.austin.project5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyService extends Service {

	private static final String TAG = "myService";

    private int count = 0;
    private int noteCount=0;



	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle extras = null;
        if (intent != null){
            extras = intent.getExtras();
        }
        String params;
        if(extras==null){
            Log.e(TAG, "Extras = null");
        }else{
            params = (String) extras.get("From");
            Log.e(TAG, "Params = " + params);
            if(params!=null) {
                if(params.equals("addOne")) {
                    increaseCountByOne();


                } else if (params.equals("addTwo")) {
                    increaseCountByTwo();

                } else if (params.equals("subOne")) {
                    decreseCount();

                } else if (params.equals("makeBreakfast")) {
                    makeBreakfast();

                }
            }else {
                Log.e(TAG, "Params were null, no action taken");
            }


        }



        Toast.makeText(this, "Count = " + count, Toast.LENGTH_SHORT).show();
        Log.e(TAG, "Count = " + count);

		return 0;
	}


	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}


    public void increaseCountByOne(){
        count++;
        note("You have "+count+" Eggs!");


    }

    public void increaseCountByTwo(){
        count=count+2;
        note("You have "+count+" Eggs!");
    }

    public void decreseCount() {
        if (count>0) {
            count--;
            note("You have "+count+" Eggs!");
        }

    }
    public void makeBreakfast(){
        if(count>=6){
            count = count-6;
            note("You have made an omelet! " + count + " eggs remaining!");

        }else {
            count = 0;
            note("You have made an Gruel! " + count + " eggs remaining!");
        }

    }


    private void note(String notification) {
        noteCount++;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification noti = new Notification.Builder(this)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(notification)
                .setSmallIcon(R.drawable.ra)
                .setOngoing(false)						//true only dismissable by app

                .build();

        // Hide the notification after its selected
        //noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(noteCount, noti);
    }


}
