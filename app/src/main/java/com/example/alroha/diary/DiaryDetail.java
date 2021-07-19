package com.example.alroha.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.alroha.R;

public class DiaryDetail extends Fragment {

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


}
