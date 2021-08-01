package com.example.alroha.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alroha.MainActivity;
import com.example.alroha.R;
import com.example.alroha.diary.DiaryDetail;

import java.util.ArrayList;
import java.util.List;

public class Fragment5 extends Fragment {

    public static Fragment5 newInstance() {
      return new Fragment5();
    }

    ViewGroup viewGroup;
    public static final String[] settingMenu = {"별명 바꾸기", "생일 바꾸기", "기념일 변경", "로그아웃", "회원탈퇴"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment5, container, false);


        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.setting_menu, R.id.setting_text, settingMenu);

        ListView listView = (ListView) viewGroup.findViewById(R.id.setting_menu);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch ((int) id) {
                    case 0: {
                        ((MainActivity) getActivity()).replaceFragment(ReplaceNickname.newInstance());

                        break;
                    }
                    case 1: {
                        ((MainActivity) getActivity()).replaceFragment(ReplaceBirthday.newInstance());

                        break;

                    }
                    case 2: {
                        ((MainActivity) getActivity()).replaceFragment(ReplaceDate.newInstance());

                        break;

                    }
                    case 3: {
                        ((MainActivity) getActivity()).replaceFragment(LogOut.newInstance());

                        break;
                    }
                    case 4: {
                        ((MainActivity) getActivity()).replaceFragment(RemoveUser.newInstance());

                    }

                }

            }
        });

        return viewGroup;
    }


}
