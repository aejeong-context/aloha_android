package com.example.alroha.day;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alroha.R;

import java.util.ArrayList;
import java.util.List;

public class DayList extends BaseAdapter {


    private final List<Day> dayList;
    LayoutInflater inflate;

    public DayList(ArrayList<Day> dayArrayList,LayoutInflater inflater) {
        inflate = inflater;
        dayList = dayArrayList;
    }

    @Override
    public int getCount() {
        return dayList.size();
    }

    @Override
    public Object getItem(int i) {
        return dayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        if(view == null){
//            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.day_list,viewGroup,false);
            view = inflate.inflate(R.layout.day_list,viewGroup,false);
            TextView title = (TextView) view.findViewById(R.id.dayTitle);
            TextView content = (TextView) view.findViewById(R.id.dayDday);
            TextView date = (TextView) view.findViewById(R.id.dayDate);

            holder.content = content;
            holder.date = date;
            holder.title = title;

        }else {
            holder = (ViewHolder) view.getTag();
        }
            Day day = dayList.get(i);
            holder.content.setText(day.getContent());
            holder.title.setText(day.getTitle());
            holder.date.setText(day.getDate());

            return view;

    }

    static class ViewHolder{
        TextView title;
        TextView content;
        TextView date;

    }
}
