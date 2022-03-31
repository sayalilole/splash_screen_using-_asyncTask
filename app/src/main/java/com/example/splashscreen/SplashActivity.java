package com.example.splashscreen;



import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends Activity {

    //  private TextView textView;
    private ProgressBar progressBar;
    private ImageView imageView;//
    Handler handler1;//
    SplashActivity splashActivity;
   private TimeThread2 timeThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashfile);
        init();

        new TimeThread2(SplashActivity.this,new SplashProgress(),progressBar).execute();
    }

    public class SplashProgress extends Handler
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.e("to","splashprogress");
            if(msg.arg1 ==1)
            {
                finish();
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }
            else{

            }
//                progressBar.setProgress((Integer)msg.obj);
        }
    }

    public void init(){
        // textView=findViewById(R.id.textView);
        progressBar=findViewById(R.id.pbBar);
        imageView=findViewById(R.id.imageView);//
    }

}
