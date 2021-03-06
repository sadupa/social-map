package com.winter.codefest.SocialMap.util;

/**
 * Created by thilina on 11/18/14.
 */

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.winter.codefest.SocialMap.R;

import java.io.IOException;
import java.util.Map;

/**
 * Asynchronous task to send the login request
 */
public abstract class AsyncHttpPost extends AsyncTask<Map<String, String>, Void, String> {
    private Context context;
    private static final String TAG = "AsyncHttpPost";
    private String url;

    public AsyncHttpPost(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    @Override
    protected String doInBackground(Map<String, String>... data) {
        Log.d(TAG, "start background async task ");
        try {
            return HTTPRequest.post(context, url, data[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public abstract void onPostExecute(String result);

}