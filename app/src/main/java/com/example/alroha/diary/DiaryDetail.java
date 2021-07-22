package com.example.alroha.diary;

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
import com.example.alroha.wish.Fragment2;

public class DiaryDetail extends Fragment implements onBackPressListener {

    ViewGroup viewGroup;

    public static DiaryDetail newInstance(){
        return new DiaryDetail();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.diary_detail, container, false);

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
