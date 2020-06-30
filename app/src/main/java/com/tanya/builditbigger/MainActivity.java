package com.tanya.builditbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.SendJokes {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new EndpointsAsyncTask(this).execute();
        t=findViewById(R.id.text);
    }

    @Override
    public void onFinish(String joke) {
        Log.e("Joke",joke);
        if(joke!=null||!joke.isEmpty())
            t.setText(joke);

    }
}