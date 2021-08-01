package com.example.alroha.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.alroha.R;
import com.example.alroha.diary.Fragment3;
import com.example.alroha.OnBackPressListener;

public class RemoveUser extends Fragment implements OnBackPressListener {
    public static RemoveUser newInstance(){
        return new RemoveUser();
    }

    ViewGroup viewGroup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.remove_user, container, false);

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
