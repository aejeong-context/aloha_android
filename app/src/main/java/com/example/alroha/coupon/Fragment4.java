package com.example.alroha.coupon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alroha.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment4 extends Fragment {

    ViewGroup viewGroup;
    RecyclerView recyclerView;
    ArrayList<HistoryCoupon> historyCouponArrayList;
    ArrayList<HistoryCoupon> apiResponse;
    HistoryAdapter historyAdapter;

    ListView listView;
    CouponAdapter couponAdapter;
    ArrayList<Coupon> couponArrayList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        historyCouponArrayList = new ArrayList<>();
        couponArrayList = new ArrayList<>();

        historyCouponArrayList.add(new HistoryCoupon("욕먹기","지수"));
        historyCouponArrayList.add(new HistoryCoupon("한대 맞기","지수"));
        historyCouponArrayList.add(new HistoryCoupon("엉덩이 맞기","지수"));
        historyCouponArrayList.add(new HistoryCoupon("애정이 빵 사주기","지수"));

        couponArrayList.add(new Coupon("밥사주기","20일 전"));
        couponArrayList.add(new Coupon("가방들어주기","19일 전"));
        couponArrayList.add(new Coupon("물떠주기","22일 전"));
        couponArrayList.add(new Coupon("배곧가기","12일 전"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment4, container, false);
       historyAdapter = new HistoryAdapter(historyCouponArrayList);
       couponAdapter = new CouponAdapter(couponArrayList);

       listView = (ListView) viewGroup.findViewById(R.id.couponList);
       recyclerView = (RecyclerView) viewGroup.findViewById(R.id.historyCouponList);


       recyclerView.setAdapter(historyAdapter);
        listView.setAdapter(couponAdapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(),RecyclerView.HORIZONTAL,false));

       ListUtils.setDynamicHeight(listView);



        return viewGroup;
    }

    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }
}
