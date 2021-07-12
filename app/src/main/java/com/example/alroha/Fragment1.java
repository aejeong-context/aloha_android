package com.example.alroha;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.alroha.day.DayDetail;

public class Fragment1  extends Fragment {


    private CardView d_day;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
       ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment1,container,false);

        ImageButton left_setting = viewGroup.findViewById(R.id.left_setting);
        d_day = viewGroup.findViewById(R.id.dday_button);

        left_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("G,,,,,");
            }
        });

        d_day.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                System.out.println("gg=================");
                Intent intent = new Intent(getActivity(), DayDetail.class);
                startActivity(intent);
            }
        });



        return viewGroup;
    }


}
