package com.example.vkfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

//
//    final Fragment fragment1 = new HomeFragment();
//    final Fragment fragment2 = new FavoritesFragment();
//    final FragmentManager fm = getSupportFragmentManager();
//    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottmNav = findViewById(R.id.bottom_nav);
        bottmNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

//        fm.beginTransaction().add(R.id.fragment_container, fragment2, "2").hide(fragment2).commit();
//        fm.beginTransaction().add(R.id.fragment_container, fragment1, "1").commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment(); //fragment for list news
                            break;
//                            fm.beginTransaction().hide(active).show(fragment1).commit();
//                            active = fragment1;
//                            return true;
//
                        case R.id.nav_fav:
                            selectedFragment = new FavoritesFragment(); //fragment for likes
                            break;
//                            fm.beginTransaction().hide(active).show(fragment2).commit();
//                            active = fragment2;
//                            return true;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
//
//    public void switchToFragment1() {
//        FragmentManager manager = getSupportFragmentManager();
//        manager.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
//    }
//    public void switchToFragment2() {
//        FragmentManager manager = getSupportFragmentManager();
//        manager.beginTransaction().replace(R.id.fragment_container, new FavoritesFragment()).commit();
//    }



}
