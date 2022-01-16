package com.example.harry.bodysoulgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth firebaseAuth;
    private TextView textViewProfile;
    private Button buttonLogout;

    private DatabaseReference databaseReference;
    private EditText textFirstName,textLastName;
    private Button buttonAddUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        databaseReference= FirebaseDatabase.getInstance().getReference();

        textFirstName=(EditText) findViewById(R.id.textFirstName);
        textLastName=(EditText)findViewById(R.id.textLastName);
        buttonAddUser=(Button)findViewById(R.id.buttonAddUser);

        FirebaseUser user=firebaseAuth.getCurrentUser();

        textViewProfile=(TextView)findViewById(R.id.textViewProfile);

        textViewProfile.setText("Welcome"+user.getEmail());
        buttonLogout=(Button)findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(this);
        buttonAddUser.setOnClickListener(this);
    }

    private void saveUserInfo(){
        String FirstName=textFirstName.getText().toString().trim();
        String LastName=textLastName.getText().toString().trim();

        UserInformation userInformation=new UserInformation(FirstName,LastName);

        FirebaseUser user=firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userInformation);
        Toast.makeText(this,"Information saved...",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        if(view==buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,home.class));
        }

        if(view==buttonAddUser){
            saveUserInfo();
        }

    }
}
