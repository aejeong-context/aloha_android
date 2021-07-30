package com.example.alroha.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.alroha.R;

import java.util.ArrayList;

public class Fragment5 extends Fragment {

    ViewGroup viewGroup;
    ListView listView;
    ArrayList<SettingMenu> settingMenuArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingMenuArrayList.add(new SettingMenu("별명 변경"));
        settingMenuArrayList.add(new SettingMenu("생일 변경"));

        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,settingMenuArrayList);

        listView =(ListView)viewGroup.findViewById(R.id.settingList);
        listView.setAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment5, container, false);
        return viewGroup;
    }
}
