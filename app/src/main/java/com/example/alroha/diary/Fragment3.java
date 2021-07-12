package com.example.alroha.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.alroha.R;

import java.util.ArrayList;

public class Fragment3  extends Fragment {

    ViewGroup viewGroup;

    ArrayList<Diary> diaryArrayList;
    DiaryList diaryAdapter;
    ListView listView;
    ImageButton diaryAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment3,container,false);

       diaryArrayList = new ArrayList<>();
       diaryArrayList.add(new Diary("한강에서 점심","한강에서 도시락 싸서 먹었다"));
       diaryArrayList.add(new Diary("집데이트","집에서 롤 했따"));
       diaryArrayList.add(new Diary("배곧 데이트","새로 생긴 카페를 갔다."));

        diaryAdapter = new DiaryList(diaryArrayList);
        listView = (ListView) viewGroup.findViewById(R.id.textView);
        listView.setAdapter(diaryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),i+"번째 Item",Toast.LENGTH_SHORT).show();
            }
        });

        diaryAdd = viewGroup.findViewById(R.id.diary_add);

        diaryAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });







//        ListView listView = viewGroup.findViewById(R.id.textView);

//        List<String> list = new ArrayList<String>();
//        list.add("0장 오늘은 허리가 아프다");
//        list.add("1장 배도 아프다");
//        list.add("에라이 썅");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(viewGroup.getContext(), android.R.layout.simple_list_item_1,list);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String data = (String) adapterView.getItemAtPosition(i);
//                System.out.println("현재 선택한 아이템의 정보는? "+data);
//            }
//        });

        return viewGroup;
    }
}
