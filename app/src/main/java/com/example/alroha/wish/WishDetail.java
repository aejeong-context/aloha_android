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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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


    @Override
    public void onAttach(@NonNull Context context) {

        getParentFragmentManager().setFragmentResultListener("WishList", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                content = result.getString("contents");
                completeDate = result.getString("completeDate");

                TextView contentView = viewGroup.findViewById(R.id.contents);
                contentView.setText(content);

                if (completeDate != null) {
                    LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 190);
                    LinearLayout dateView = (LinearLayout) viewGroup.findViewById(R.id.dateViewLayout);
                    param.topMargin=20;
                    dateView.setLayoutParams(param);

                    CardView cardView = (CardView) viewGroup.findViewById(R.id.cardView);


                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                    params.topMargin = 35;
                    params.leftMargin = 20;
                    TextView textView = new TextView(getActivity().getApplicationContext());
                    textView.setText("달성한 날짜");
                    textView.setTextSize(19);
                    textView.setTextColor(Color.BLACK);

                    textView.setLayoutParams(params);


                    LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


                    TextView textView1 = new TextView(getActivity().getApplicationContext());
                    textView1.setText(completeDate);
                    textView1.setTextSize(19);
                    params2.topMargin = 35;
                    params2.rightMargin = 20;
                    textView1.setTextColor(Color.BLACK);
                    textView1.setGravity(Gravity.RIGHT);
                    textView1.setLayoutParams(params2);


                    cardView.addView(textView);
                    cardView.addView(textView1);
                } else {
                    System.out.println("여긴 어떠신가!");
                }
            }
        });


        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewGroup = (ViewGroup) inflater.inflate(R.layout.wish_detail, container, false);


//            LinearLayout dateView = (LinearLayout) viewGroup.findViewById(R.id.dateViewLayout);
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//            TextView textView = new TextView(getActivity().getApplicationContext());
//            textView.setText(completeDate);
//            textView.setLayoutParams(params);
//            dateView.addView(textView);


        return viewGroup;
    }


    @Override
    public void onBackKey() {
        goToBack();
    }

    private void goToBack() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_layout, Fragment2.newInstance()).commit();
    }
}
