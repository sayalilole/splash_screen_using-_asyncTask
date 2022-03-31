package com.example.splashscreen;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.splashscreen.SplashActivity;

public class TimeThread2 extends AsyncTask<Integer,Integer,Integer> {
    private ProgressBar progressBar;
    private Handler handler;
    int req;
    Context context;

    //private long lastDuratioon,updateDuration;//every sec user will updated

    public TimeThread2(Context context ,Handler handler,ProgressBar progressBar)
    {
        this.handler=handler;
        this.context=context;
        this.progressBar = progressBar;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        Log.e("to","DO IN backgroud");
        for(int i=0;i<=100;i++)
        {

            try {
                Thread.sleep(20);
                progressBar.setProgress(i);
                publishProgress(new Integer(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return 1;

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.e("to","update");
        super.onProgressUpdate(values);
        Message message=new Message();
        message.arg1=2;
        message.obj=values;
        handler.sendMessage(message);

    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        Log.e("to","post execute");
        Message message=new Message();
        message.arg1=1;
        message.obj= message;
        handler.handleMessage(message);
    }
}
