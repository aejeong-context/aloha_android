package com.example.alroha.wish;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import com.example.alroha.MainActivity;
import com.example.alroha.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class   Fragment2 extends Fragment {

    ViewGroup viewGroup;

    ArrayList<Wish> apiResponse;
    ArrayList<Wish> wishArrayList;
    WishList wishAdapter;
    ListView listView;

    public static Fragment2 newInstance() {
        return new Fragment2();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiResponse = new ArrayList<>();
        wishArrayList = new ArrayList<>();

        apiResponse.add(new Wish("바다에서 맥주마시기", false, null));
        apiResponse.add(new Wish("도깨비 드라마 정주행하기", false, null));
        apiResponse.add(new Wish("커플 운동화 사기", true, "2021년 07월 05일"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        for (Wish wish : apiResponse) {
            if (wish.isChecked() == false) {
                wishArrayList.add(new Wish(wish.getContents(), wish.isChecked(), wish.getCompleteDate()));
            }
        }
        wishAdapter = new WishList(wishArrayList);
        listView = (ListView) viewGroup.findViewById(android.R.id.list);
        listView.setAdapter(wishAdapter);



        TextView addWish = (TextView) viewGroup.findViewById(R.id.wishAdd);
        addWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).replaceFragment(AddWish.newInstance());
            }
        });

        TabLayout wishTab = (TabLayout) viewGroup.findViewById(R.id.wishTab);
        wishTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // tab의 상태가 선택 상태로 변경
                int pos = tab.getPosition();
                changView(pos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // tab의 상태가 선택되지 않음으로 변경
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // 이미 선택된 tab이 사용자에 의해 다시 선택됨.
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle result = new Bundle();
                result.putString("contents", wishArrayList.get(i).getContents());
                result.putBoolean("isChecked", wishArrayList.get(i).isChecked());
                result.putString("completeDate", wishArrayList.get(i).getCompleteDate());
                getParentFragmentManager().setFragmentResult("WishList", result);

                ((MainActivity) getActivity()).replaceFragment(WishDetail.newInstance());
            }
        });

        return viewGroup;
    }


    private void changView(int index) {
        switch (index) {
            case 0:
                wishArrayList.clear();
                for (Wish wish : apiResponse) {
                    if (wish.isChecked() == false) {
                        wishArrayList.add(new Wish(wish.getContents(), wish.isChecked(), wish.getCompleteDate()));
                        wishAdapter = new WishList(wishArrayList);
                        listView = (ListView) viewGroup.findViewById(android.R.id.list);
                        listView.setAdapter(wishAdapter);
                    }
                }

                break;
            case 1:
                wishArrayList.clear();
                for (Wish wish : apiResponse) {

                    if (wish.isChecked() == true) {

                        wishArrayList.add(new Wish(wish.getContents(), wish.isChecked(), wish.getCompleteDate()));
                        wishAdapter = new WishList(wishArrayList);
                        listView = (ListView) viewGroup.findViewById(android.R.id.list);
                        listView.setAdapter(wishAdapter);
                    }
                }
                break;
        }

    }

}
