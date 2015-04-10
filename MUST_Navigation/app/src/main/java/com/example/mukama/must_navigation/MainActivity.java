package com.example.mukama.must_navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finally{

                    startActivity(new Intent(getApplicationContext(),SearchMUST.class));
                }
            }
        };
        timer.start();
    }

    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
