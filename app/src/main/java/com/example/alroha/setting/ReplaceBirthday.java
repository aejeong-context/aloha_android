package com.example.alroha.setting;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.alroha.OnBackPressListener;
import com.example.alroha.R;

public class ReplaceBirthday extends Fragment implements OnBackPressListener {
    public static ReplaceBirthday newInstance() {
        return new ReplaceBirthday();
    }

    ViewGroup viewGroup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.replace_birthday, container, false);

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
