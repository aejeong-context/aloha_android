package com.example.alroha.coupon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alroha.OnBackPressListener;
import com.example.alroha.R;
import com.example.alroha.setting.Fragment5;

import java.util.ArrayList;

public class HistoryAll extends Fragment implements OnBackPressListener {

    ViewGroup viewGroup;
    HistoryAllAdapter historyAdapter;
    ArrayList<HistoryCoupon> historyCouponArrayList;
    ListView listView;
    int count = 0;

    public static HistoryAll newInstance(){
        return new HistoryAll();
    }

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        historyCouponArrayList = new ArrayList<>();
        historyCouponArrayList.add(new HistoryCoupon("욕먹기","지수"));
        historyCouponArrayList.add(new HistoryCoupon("한대 맞기","지수"));
        historyCouponArrayList.add(new HistoryCoupon("엉덩이 맞기","지수"));
        historyCouponArrayList.add(new HistoryCoupon("애정이 빵 사주기","지수"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater,  ViewGroup container, @Nullable  Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.coupon_history_all, container, false);

        historyAdapter = new HistoryAllAdapter(historyCouponArrayList);

        listView =(ListView) viewGroup.findViewById(R.id.history_all_list);

        listView.setAdapter(historyAdapter);


//        ImageButton imageButton = viewGroup.findViewById(R.id.coupon_like);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count = 1-count;
//                if(count == 0)
//                imageButton.setImageResource(R.drawable.ic_baseline_favorite_24);
//                else{
//                    imageButton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
//                }
//            }
//        });
        return viewGroup;
    }


    @Override
    public void onBackKey() {
        goToBack();
    }

    private void goToBack() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_layout, Fragment5.newInstance()).commit();
    }
}
