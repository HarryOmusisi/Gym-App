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

public class User extends AppCompatActivity implements View.OnClickListener {
    private Button buttonAdd;
    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;
    private EditText Editmail,EditAge,EditTimeframe,EditPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        Editmail=(EditText)findViewById(R.id.Editmail);
        EditAge=(EditText)findViewById(R.id.EditAge);
        EditTimeframe=(EditText)findViewById(R.id.EditTimeframe);
        EditPhone=(EditText)findViewById(R.id.EditPhone);

        buttonAdd=(Button)findViewById(R.id.buttonAdd);

        FirebaseUser user=firebaseAuth.getCurrentUser();

        buttonAdd.setOnClickListener(this);
    }

    private void saveData(){

        String mail=Editmail.getText().toString().trim();
        String Age=EditAge.getText().toString().trim();
        String Timeframe=EditTimeframe.getText().toString().trim();
        String Phone=EditPhone.getText().toString().trim();

        saveData data=new saveData(mail,Age,Timeframe,Phone);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(user);
        Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if(view==buttonAdd){
            saveData();
            startActivity(new Intent(User.this,home.class));
        }

    }
}
