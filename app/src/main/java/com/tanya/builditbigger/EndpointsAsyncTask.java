package com.tanya.builditbigger;


import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private JokeTransfer mJokes;

    public EndpointsAsyncTask(JokeTransfer sendJokes){
        mJokes = sendJokes;
    }
    public interface JokeTransfer{
        void tellAJoke(String joke);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
//
    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:80/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    })
                    .setApplicationName("Build it Bigger");



            myApiService = builder.build();
        }


        try {
            return myApiService.getjoke().execute().getData();
        } catch (IOException e) {
            Log.e("Async Task",e.getMessage());
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mJokes.tellAJoke(result);
    }
}
