package com.example.harry.bodysoulgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;

public class History extends AppCompatActivity {
    private TextView workout,weight,exercise,time,instructor;

    private FirebaseApp mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        workout=(TextView)findViewById(R.id.textViewWorkout);
        weight=(TextView)findViewById(R.id.textViewWeight);
        exercise=(TextView)findViewById(R.id.textViewExercise);
        time=(TextView)findViewById(R.id.textViewTime);
        instructor=(TextView)findViewById(R.id.textViewInstructor);

       // mRef=new FirebaseApp("https://project-3934122924791978223.firebaseio.com/FirstName,LastName");

        //mRef.addLifecycleEventListener(new View.OnClickListener());
    }

}
