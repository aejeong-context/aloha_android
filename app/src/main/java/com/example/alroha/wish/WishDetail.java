package com.example.alroha.wish;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import com.example.alroha.MainActivity;
import com.example.alroha.R;
import com.example.alroha.onBackPressListener;

import java.util.Objects;

public class WishDetail extends Fragment implements onBackPressListener {

    public static WishDetail newInstance() {
        return new WishDetail();
    }

    ViewGroup viewGroup;
    String content;
    String completeDate;

    LinearLayout linearLayout;


    @Override
    public void onAttach(@NonNull  Context context) {

        getParentFragmentManager().setFragmentResultListener("WishList", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull  String requestKey, @NonNull  Bundle result) {
               content =  result.getString("contents");
               completeDate = result.getString("completeDate");



                TextView contentView = viewGroup.findViewById(R.id.contents);
                contentView.setText(content);
            }
        });
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewGroup = (ViewGroup) inflater.inflate(R.layout.wish_detail,container,false);
        LinearLayout dateView = viewGroup.findViewById(R.id.dateViewLayout);
        if(completeDate != "" ){
            System.out.println("여기 들어올까나?");

            TextView textView = new TextView(getActivity().getApplicationContext());
            textView.setText(completeDate);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.CENTER;
            textView.setLayoutParams(lp);

            dateView.addView(textView);

//
//                   CardView dateView = new CardView(WishDetail.newInstance().getContext());
//                   dateView.setMinimumWidth(370);
//                   dateView.setMinimumHeight(80);
//                   dateView.setCardBackgroundColor(Color.WHITE);
//
//                   linearLayout.addView(dateView);

        }


        return viewGroup;
    }


    @Override
    public void onBackKey() {
        goToBack();
    }

    private void goToBack(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_layout,Fragment2.newInstance()).commit();
    }
}
