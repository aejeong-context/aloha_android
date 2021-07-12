package com.example.alroha.day;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alroha.R;

import java.util.ArrayList;

public class DayDetail extends AppCompatActivity {


    ArrayList<Day> dayArrayList;
    DayList dayAdapter;
    ListView listView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.day_dedtail);
    System.out.println("여기 들어오시나요?");
        dayArrayList = new ArrayList<>();
        dayArrayList.add(new Day("발렌타인데이","D-18", "2021.07.09 (금)"));
    LayoutInflater inflater = getLayoutInflater();
        dayAdapter = new DayList(dayArrayList,inflater);

        listView = (ListView) findViewById(R.id.dayList);
        listView.setAdapter(dayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),i+"번째 아이템!",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
