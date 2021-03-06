package com.example.harry.bodysoulgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class Instructors extends AppCompatActivity {
    ListView search_instructors;
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructors);

        search_instructors=(ListView)findViewById(R.id.search_instructors);

        ArrayList<String>instrucorsGym=new ArrayList<>();
        instrucorsGym.addAll(Arrays.asList(getResources().getStringArray(R.array.Instructors)));

        adapter=new ArrayAdapter<String>(
                Instructors.this,
                android.R.layout.simple_list_item_1,
                instrucorsGym
        );

        search_instructors.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
         inflater.inflate(R.menu.menu,menu);
        MenuItem item=menu.findItem(R.id.search_instructors);
        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
