package com.tanya.builditbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import  android.view.View;

import com.tanya.jokesdisplay.*;
public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.SendJokes {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new EndpointsAsyncTask(this).execute();
        t=findViewById(R.id.instructions_text_view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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

    public void tellJoke(View view) {
        new EndpointsAsyncTask(this) {
            @Override
            protected void onPostExecute(String joke) {
                Intent in  = new Intent(getApplicationContext(), JokeActivity.class);
                in.putExtra(JokeActivity.Joke, joke);
                startActivity(in);
            }
        }.execute();
    }

    @Override
    public void onFinish(String joke) {

    }


//    @Override
//    public void onFinish(String joke) {
//        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show();
//
//        Intent intent = new Intent(this, JokeActivity.class);
//        TellJokes telljokes=new TellJokes();
//        intent.putExtra("joke",telljokes.getAllJokes());
//        startActivity(intent);
//    }
}