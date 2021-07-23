package com.example.alroha.diary;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.alroha.R;
import com.example.alroha.onBackPressListener;
import com.example.alroha.wish.Fragment2;

public class AddDiary extends Fragment implements onBackPressListener {

    ViewGroup viewGroup;
    ImageButton addPlace;
    public static AddDiary newInstance() {
        return new AddDiary();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.diary_add, container, false);
        addPlace = viewGroup.findViewById(R.id.addPlace);
        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("다이~");
                LinearLayout dateView = (LinearLayout) viewGroup.findViewById(R.id.diary_card);

                CardView cardView = new CardView(getActivity().getApplicationContext());

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);



                params.topMargin = 35;
                params.leftMargin = 20;

                EditText placeEdit = new EditText(getActivity().getApplicationContext());
                placeEdit.setHint("번째 장소이름");
                placeEdit.setHintTextColor(Color.parseColor("#DDDDDD"));

                EditText commentEdit = new EditText(getActivity().getApplicationContext());
                commentEdit.setHint("한줄평");
                commentEdit.setHintTextColor(Color.parseColor("#DDDDDD"));


                cardView.addView(commentEdit);
                cardView.addView(placeEdit);

                dateView.addView(cardView);





            }
        });
        return viewGroup;
    }

    @Override
    public void onBackKey() {
        goToBack();
    }

    private void goToBack() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_layout, Fragment3.newInstance()).commit();
    }
}
