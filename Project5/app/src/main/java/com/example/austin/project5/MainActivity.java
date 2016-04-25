package com.example.austin.project5;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    MyService myService;
    boolean isBound;
    Intent myIntent = new Intent();
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = new TextView(this);


        myIntent.setAction(MyReceiver.MY_ACTION);
        sendBroadcast(myIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addOneEgg(View View){

        //Intent myIntent = new Intent();
        myIntent.setAction(MyReceiver.MY_ACTION);
        myIntent.putExtra("From","addOne");
        sendBroadcast(myIntent);

    }

    public void addTwoEggs(View View){
        //Intent myIntent = new Intent();
        myIntent.setAction(MyReceiver.MY_ACTION);
        myIntent.putExtra("From","addTwo");
        sendBroadcast(myIntent);

    }

    public void subOneEgg(View View){
        //Intent myIntent = new Intent();
        myIntent.setAction(MyReceiver.MY_ACTION);
        myIntent.putExtra("From","subOne");
        sendBroadcast(myIntent);

    }

    public void makeBreakfast(View View){
        //Intent myIntent = new Intent();
        myIntent.setAction(MyReceiver.MY_ACTION);
        myIntent.putExtra("From","makeBreakfast");
        sendBroadcast(myIntent);

    }
}
