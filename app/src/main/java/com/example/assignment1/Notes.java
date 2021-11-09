package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.assignment1.Model.ToDo;
import com.example.assignment1.Model.ToDoModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;

//used gson and shared prefrence
public class Notes extends AppCompatActivity {
    ArrayAdapter listAdapt;
    private ListView notesList;
    private EditText title;
    private EditText desc;
    private BottomNavigationView bottomNav;
    ToDoModel model = new ToDoModel();
    ArrayList<ToDo> result;
    ToDo[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        result = model.getNotes();
//        array = result.toArray(new ToDo[result.size()]);

        notesList = findViewById(R.id.notes_list);



        bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.home);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.watch:
                        startActivity(new Intent(getApplicationContext(), Watch.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.notes:

                        return true;

                }
                return false;
            }
        });
    }

//    public void insert(View view) {
//        ToDo newobj = new ToDo(title.getText().toString(), desc.getText().toString());
//
//        result.add(newobj);
//        array = result.toArray(new ToDo[result.size()]);
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = prefs.edit();
//        Gson gson = new Gson();
//        String booksString = gson.toJson(array);
//
//        editor.putString("123", booksString);
//        editor.commit();
//    }

    public void btnSaveOnClick(View view) {

        array = result.toArray(new ToDo[result.size()]);
        String[] msg = new String[result.size()];
        if (!result.isEmpty()) {
            for (int i = 0; i < result.size(); i++) {
                msg[i] = array[i].getNote_title() + " :" + array[i].getNote_details();
            }
            listAdapt = new ArrayAdapter(Notes.this, android.R.layout.simple_list_item_1, msg);
        }
        notesList.setAdapter(listAdapt);


        SharedPreferences notesPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = notesPref.edit();
        Gson gson = new Gson();
        String booksString = gson.toJson(msg);

        editor.putString("123", booksString);
        editor.commit();
        Toast.makeText(this, "Data Saved" ,
                Toast.LENGTH_SHORT).show();


    }

    public void btnLoadOnClick(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("123", "");
        try {
            ToDo[] books = gson.fromJson(str, ToDo[].class);
        }
        catch (IllegalStateException | JsonSyntaxException exception){

        }

        Toast.makeText(this, "number of notes =" + result.size()
                , Toast.LENGTH_SHORT).show();
    }
}