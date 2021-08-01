package com.example.alroha.diary;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.alroha.R;
import com.example.alroha.OnBackPressListener;

public class AddDiary extends Fragment implements OnBackPressListener {

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

                // 추가될 장소인 레이아웃
                LinearLayout dateView = (LinearLayout) viewGroup.findViewById(R.id.diary_card);


                CardView cardView = new CardView(getActivity().getApplicationContext());
                CardView cardView2 = new CardView(getActivity().getApplicationContext());


                EditText placeEdit = new EditText(getActivity().getApplicationContext());
                placeEdit.setHint("번째 장소이름");
                placeEdit.setTextSize(15);
                placeEdit.setBackground(null);
                placeEdit.setHintTextColor(Color.parseColor("#DDDDDD"));
                cardView.addView(placeEdit);


                // 카드
                LinearLayout.LayoutParams cardParam = new LinearLayout.LayoutParams(1000, ViewGroup.LayoutParams.WRAP_CONTENT);

                cardView.setLayoutParams(cardParam);

                cardView.setCardBackgroundColor(Color.WHITE);
                cardView.setCardElevation(0);



                EditText commentEdit = new EditText(getActivity().getApplicationContext());

                commentEdit.setHint("한줄평");
                commentEdit.setTextSize(15);
                placeEdit.setBackground(null);
                commentEdit.setHintTextColor(Color.parseColor("#DDDDDD"));

                cardView2.addView(commentEdit);

                // 레이아웃에 카드 넣기

                dateView.addView(cardView);
                dateView.addView(cardView2);


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
