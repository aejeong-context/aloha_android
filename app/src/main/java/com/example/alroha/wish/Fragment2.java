package com.example.alroha.wish;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.alroha.R;

import java.util.ArrayList;

public class Fragment2  extends ListFragment {

    ViewGroup viewGroup;

    ArrayList<Wish> wishArrayList;
    WishList wishAdapter;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);

        wishArrayList = new ArrayList<>();
        wishArrayList.add(new Wish("바다에서 맥주마시기",false));
        wishArrayList.add(new Wish("도깨비 드라마 정주행하기",false));
        wishArrayList.add(new Wish("커플 운동화 사기",true));

        wishAdapter = new WishList(wishArrayList);
        listView = (ListView) viewGroup.findViewById(android.R.id.list);
        listView.setAdapter(wishAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getContext(),i+"번째 소원입니다.",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(), WishDetail.class);
//                startActivity(intent);
//            }
//        });



        return viewGroup;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull  View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
                Toast.makeText(getContext(),id+"번째 소원입니다.",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.setClass(getActivity(),WishDetail.class);
        startActivity(intent);
    }
}
