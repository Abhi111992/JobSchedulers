package com.example.jobschedulerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
private static final int JOB_ID=101;
private JobScheduler jobScheduler;
private JobInfo jobInfo;

Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.b1);
        button2=findViewById(R.id.b2);
button1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view)
                               {

                                   scheduleJob(view);
                               }
           });
        button2.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View view)
                                       {

                                           clearJob(view);
                                       }
        });

        ComponentName componentName=new ComponentName(this,MJobScheduler.class);
        JobInfo.Builder builder=new JobInfo.Builder(JOB_ID,componentName);
        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo=builder.build();
        jobScheduler=(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);


    }
    public void scheduleJob(View view)
    {
        jobScheduler.schedule(jobInfo);
        Toast.makeText(this, "Job Scheduled", Toast.LENGTH_SHORT).show();

    }
    public void clearJob(View view){

jobScheduler.cancel(JOB_ID);
        Toast.makeText(this, "Job Cancel", Toast.LENGTH_SHORT).show();

    }
}