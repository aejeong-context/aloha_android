package com.example.alroha.wish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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


    @Override
    public void onAttach(@NonNull  Context context) {
        getParentFragmentManager().setFragmentResultListener("WishList", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull  String requestKey, @NonNull  Bundle result) {
               content =  result.getString("contents");

                TextView contentView = viewGroup.findViewById(R.id.contents);
                contentView.setText(content);
            }
        });
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewGroup = (ViewGroup) inflater.inflate(R.layout.wish_detail,container,false);
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
