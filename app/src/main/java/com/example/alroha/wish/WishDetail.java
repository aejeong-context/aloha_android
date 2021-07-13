package com.example.alroha.wish;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.alroha.MainActivity;
import com.example.alroha.R;
import com.example.alroha.onBackPressListener;

import java.util.Objects;

public class WishDetail extends Fragment implements onBackPressListener {

    public static WishDetail newInstance() {
        return new WishDetail();
    }

    ViewGroup viewGroup;

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
