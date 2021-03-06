package com.example.alroha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import android.view.MenuItem;
import android.widget.Toast;

import com.example.alroha.coupon.Fragment4;
import com.example.alroha.diary.Fragment3;
import com.example.alroha.setting.Fragment5;
import com.example.alroha.wish.Fragment2;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
    }

    BottomNavigationView bottomNavigationView;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    Fragment5 fragment5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment1).commitNow();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.tab1:{
                        
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment1).commitNow();
                        return true;
                    }
                    case R.id.tab2:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment2).commitNow();
                        return true;
                    }
                    case R.id.tab3:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment3).commitNow();
                        return true;
                    }

                    case R.id.tab4:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment4).commitNow();
                        return true;
                    }

                    case R.id.tab5:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment5).commitNow();
                        return true;
                    }


                    default: return false;
                }
            }
        });
    }

   public void replaceFragment(Fragment fragment){
       FragmentManager fragmentManager = getSupportFragmentManager();
       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       fragmentTransaction.replace(R.id.main_layout,fragment).commit();

   }


   private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        for(Fragment fragment : fragmentList){
            if(fragment instanceof OnBackPressListener){
                ((OnBackPressListener)fragment).onBackKey();
                return;
            }
        }
        if(System.currentTimeMillis()- lastTimeBackPressed < 1500){
            finish();
            return;
        }
        lastTimeBackPressed = System.currentTimeMillis();
        Toast.makeText(this,"'??????' ????????? ??? ??? ??? ????????? ???????????????.",Toast.LENGTH_SHORT).show();
    }
}

