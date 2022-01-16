package com.example.harry.bodysoulgym;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class home extends AppCompatActivity {
    CardView profile_card, workout_card,history_card,location_card,CardInstructor,CardLogout;

    private RecyclerView recyclerView;
    //private ActivitiesAdapter adapter;
    private List<Activity> activityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final CardView profile_card,workout_card,history_card,location_card,CardInstructor,CardLogout;

        history_card=findViewById(R.id.history_card);
        {
            history_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 if(view==history_card){
                     startActivity(new Intent(home.this,History.class));
                 }
                }
            });

            profile_card=findViewById(R.id.profile_card);
            {
                profile_card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(home.this,User.class));

                    }
                });
                }

                workout_card=findViewById(R.id.workoutplan_card);
            {
                workout_card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(home.this,plan.class));
                    }
                });
            }

            location_card=findViewById(R.id.location_card);
            {
                location_card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        {
                           startActivity(new Intent(home.this,DemoMaps.class));
                        }

                    }
                });
        }
       CardInstructor=findViewById(R.id.CardInstructor);
            {
                CardInstructor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(home.this,Instructors.class));

                    }
                });
            }
            CardLogout=findViewById(R.id.CardLogout);
            {
                CardLogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(home.this,LoginActivity.class));

                    }
                });
            }



        }

    }
    }

