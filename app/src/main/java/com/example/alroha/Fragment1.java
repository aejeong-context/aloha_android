package com.example.alroha;

import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1  extends Fragment {

    ViewGroup viewGroup;
    private ImageView jjang;
    private ImageView ch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment1,container,false);

        jjang = viewGroup.findViewById(R.id.jang);
        ch = viewGroup.findViewById(R.id.ch);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ch.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0,0,view.getWidth(),view.getHeight()+200,40);
                }
            });
            jjang.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0,0,view.getWidth(),view.getHeight()+200,40);
                }
            });
            jjang.setClipToOutline(true);
        }
        return viewGroup;
    }
}
