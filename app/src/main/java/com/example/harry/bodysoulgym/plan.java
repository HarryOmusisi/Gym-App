package com.example.harry.bodysoulgym;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class plan extends AppCompatActivity implements View.OnClickListener {
    private Button buttonCreate;
    private Button buttonView;
    private FirebaseAuth firebaseAuth;


    private DatabaseReference databaseReference;
    private EditText Editworkout, EditWeight1, EditExxercise, EditTime, EditInstructor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        Editworkout = (EditText) findViewById(R.id.Editworkout);
        EditWeight1 = (EditText) findViewById(R.id.EditWeight1);
        EditExxercise = (EditText) findViewById(R.id.EditExercise);
        EditTime = (EditText) findViewById(R.id.EditTime);
        EditInstructor = (EditText) findViewById(R.id.EditInstructor);

        buttonCreate = (Button) findViewById(R.id.buttonCreate);
        buttonView = (Button) findViewById(R.id.buttonView);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        buttonCreate.setOnClickListener(this);
        buttonView.setOnClickListener(this);

    }

    private void saveUserInformation() {

        String WorkoutName = Editworkout.getText().toString().trim();
        String Weight = EditWeight1.getText().toString().trim();
        String Exercise = EditExxercise.getText().toString().trim();
        String Time = EditTime.getText().toString().trim();
        String Instructor = EditInstructor.getText().toString().trim();


        PlanInformation planInformation=new PlanInformation(WorkoutName, Weight, Exercise, Time, Instructor);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(planInformation);
        Toast.makeText(this, "Information added successfully", Toast.LENGTH_LONG).show();


    }


    @Override
    public void onClick(View view) {
        if (view == buttonCreate) {
            saveUserInformation();
            startActivity(new Intent(plan.this,home.class));
        }
        if (view == buttonView) {
            startActivity(new Intent(plan.this, History.class));
        }
    }
}



