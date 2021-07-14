package com.example.alroha.wish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.alroha.R;
import com.example.alroha.onBackPressListener;

public class AddWish extends Fragment implements onBackPressListener {

    ViewGroup viewGroup;

    public static Fragment newInstance() {
        return new AddWish();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {

        viewGroup = (ViewGroup) inflater.inflate(R.layout.wish_add,container,false);
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
