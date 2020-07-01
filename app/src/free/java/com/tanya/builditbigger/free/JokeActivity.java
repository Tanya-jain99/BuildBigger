package com.tanya.builditbigger.free;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.tanya.builditbigger.EndpointsAsyncTask;
import com.tanya.builditbigger.R;
import android.view.View;
public class JokeActivity extends AppCompatActivity implements EndpointsAsyncTask.JokeTransfer{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
    public void showJoke(View view) {
       try {
           new EndpointsAsyncTask(this).execute();
       }
       catch (Exception e)
       {
           Log.d("TAG",e.getMessage()+"");
       }
    }


    @Override
    public void tellAJoke(String jokes) {
        Intent in = new Intent(this, com.tanya.jokesdisplay.JokeActivity.class);
        in.putExtra("joke",jokes);
        startActivity(in);
    }
}