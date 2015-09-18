package com.karuppiah.bringit;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;

import java.sql.Connection;
import java.util.ArrayList;


public class Dashboard extends ActionBarActivity {

    public static final int DONE = 1;
    public static Connection conn = null;

    private ArrayList<Food> foodList;
    private ListView foodView;

    private final Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DONE:

                    FoodAdapter foodAdt = new FoodAdapter(Dashboard.this, foodList);
                    foodView.setAdapter(foodAdt);

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        foodView = (ListView) findViewById(R.id.food_list);

        foodList = new ArrayList<Food>();

        dbconnection dbconn = new dbconnection(mHandler,foodList);

        dbconn.start();
    }

    public void foodPicked(View view) {



    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
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
    */
}
