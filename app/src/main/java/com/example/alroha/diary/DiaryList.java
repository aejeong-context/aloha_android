package com.example.alroha.diary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.alroha.R;

import java.util.ArrayList;
import java.util.List;

public class DiaryList extends BaseAdapter {

    private final List<Diary> diaryList;


    public DiaryList(ArrayList<Diary> diaryArrayList) {
        diaryList = diaryArrayList;

    }

    @Override
    public int getCount() {
        return diaryList.size();
    }

    @Override
    public Object getItem(int i) {
        return diaryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {

        ViewHolder holder = new ViewHolder();
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.diary_list, viewGroup, false);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView content = (TextView) view.findViewById(R.id.content);

            holder.content = content;
            holder.title = title;

        }else{

            holder = (ViewHolder) view.getTag();
        }

        Diary diary = diaryList.get(i);
        holder.content.setText(diary.getContent());
        holder.title.setText(diary.getTitle());


        return view;
    }

    static class ViewHolder{
        TextView title,content;
    }
}
