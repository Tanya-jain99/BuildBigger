package com.tanya.builditbigger.paid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

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
        new EndpointsAsyncTask(this).execute();

    }




    @Override
    public void tellAJoke(String jokes) {
        Intent intent = new Intent(this, com.tanya.jokesdisplay.JokeActivity.class);
        intent.putExtra("joke",jokes);
        startActivity(intent);
    }
}