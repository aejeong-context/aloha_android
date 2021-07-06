package com.example.alroha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



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

        ViewHolder holder;
        System.out.println("들어옴?");
        if(view == null) {
            System.out.println("들어옴? ? @2222");

            holder = new ViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView content = (TextView) view.findViewById(R.id.content);
            holder.content = content;
            holder.title = title;

            view.setTag(holder);
        }else{
            System.out.println("들어옴?3333");

            holder = (ViewHolder) view.getTag();
        }
        System.out.println("들어옴?44444");

        Diary diary = diaryList.get(i);
        holder.content.setText(diary.getContent());
        holder.title.setText(diary.getTitle());


        return view;
    }

    static class ViewHolder{
        TextView title,content;
    }
}
