package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.assignment1.Model.Workout;
import com.example.assignment1.Model.WorkoutModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String workoutType[]= {"legs","abs","arms"};
    private ListView workoutList;
    String[] msg;
    Workout[] newres;
    ArrayList<Workout> result;
    ArrayList<Workout> new_result= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.type_spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, workoutType);
        spinner.setAdapter(spinnerAdapter);

        workoutList= findViewById(R.id.workout_list);
        CustomAdapter customAdapter = new CustomAdapter();
//        listView.setAdapter(customAdapter);
       // ArrayAdapter listAdapt;

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //code below is used to change the listview content based on what thus user chooses from the spinner
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {


                CustomAdapter listAdapt;
                    if(position==0) {
                        WorkoutModel model = new WorkoutModel();

                      result = model.getWorkoutsByTypr(workoutType[0].toString());
                         msg = new String[100];
                        newres = new Workout[100];

                        if (!result.isEmpty()) {
                        for (int i = 0; i < result.size(); i++) {
                            msg[i] = result.get(i).getName()+result.get(i).getType();
                            newres[i]=result.get(i);
                        }
                            listAdapt = new CustomAdapter();                    } else {
                            listAdapt = new CustomAdapter();                    }
                    workoutList.setAdapter(listAdapt);
                }if(position==1){
                    WorkoutModel model = new WorkoutModel();

                    ArrayList<Workout> result = model.getWorkoutsByTypr(workoutType[1].toString());
                    String[] msg = new String[result.size()];

                    if (!result.isEmpty()) {
                        for (int i = 0; i < result.size(); i++) {
                            msg[i] = result.get(i).getName()+result.get(i).getType();
                            newres[i]=result.get(i);
                        }
                        listAdapt = new CustomAdapter();                    } else {
                        listAdapt = new CustomAdapter();                    }
                    workoutList.setAdapter(listAdapt);

                } if(position==2){
                    WorkoutModel model = new WorkoutModel();

                     result = model.getWorkoutsByTypr(workoutType[2].toString());
                    String[] msg = new String[result.size()];


                    if (!result.isEmpty()) {
                    for (int i = 0; i < result.size(); i++) {
                        msg[i] = result.get(i).getName()+result.get(i).getType();
                        newres[i]=result.get(i);
                    }
                    listAdapt = new CustomAdapter();
                } else {
                        listAdapt = new CustomAdapter();                }
                workoutList.setAdapter(listAdapt);

            }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        //===========================================================

        //add bottom navigation with three meny items (im not sure if we're allowed to use it but i dont see why not :p)
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.home);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.watch:
                        startActivity(new Intent(getApplicationContext(),Watch.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:

                        return true;
                    case R.id.notes:
                        startActivity(new Intent(getApplicationContext(),Notes.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return result.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView workoutname = view1.findViewById(R.id.row_title);
            TextView workouttype = view1.findViewById(R.id.row_desc);
            TextView workoutduration = view1.findViewById(R.id.row_durationt);
            TextView workoutsets = view1.findViewById(R.id.row_sets);


            ImageView image = view1.findViewById(R.id.imgv);

            workoutname.setText(newres[i].getName());
            workouttype.setText("Type: "+newres[i].getType());
            workoutduration.setText(newres[i].getDuration()+" mins");
            workoutsets.setText("x"+newres[i].getSets());
            image.setImageResource(newres[i].getImg());
            return view1;
        }
    }
}