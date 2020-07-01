package com.tanya.jokesdisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
public static final String Joke="joke";
        String mJoke;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_joke);
            Intent intent = getIntent();
            TextView jokeView = findViewById(R.id.joke_display);
            if(intent.hasExtra("joke")) {
                mJoke = getIntent().getStringExtra("joke");
                jokeView.setText(mJoke);
            }
            else {
                jokeView.setText(R.string.empty);
            }


        }

}