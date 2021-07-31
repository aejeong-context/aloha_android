package com.example.alroha.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alroha.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment5 extends Fragment {

    ViewGroup viewGroup;
    String[] settingMenu = {"별명 바꾸기","생일 바꾸기","기념일 변경","로그아웃","회원탈퇴"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment5, container, false);


        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.setting_menu,R.id.setting_text,settingMenu);

        ListView listView = (ListView) viewGroup.findViewById(R.id.setting_menu);
        listView.setAdapter(adapter);

        return viewGroup;
    }
}
