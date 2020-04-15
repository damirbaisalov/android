package com.example.vkfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //init fragments
    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new FavoritesFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottmNav = findViewById(R.id.bottom_nav);
        bottmNav.setOnNavigationItemSelectedListener(navListener);

        //set homeFragment as default
        setFragment(fragment1);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            setFragment(fragment1); //fragment for list news
                            break;
//                            fm.beginTransaction().hide(active).show(fragment1).commit();
//                            active = fragment1;
//                            return true;
//
                        case R.id.nav_fav:
                            setFragment(fragment2); //fragment for likes
                            break;
//                            fm.beginTransaction().hide(active).show(fragment2).commit();
//                            active = fragment2;
//                            return true;

                    }
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };

    //function to replace and commit chosen fragment
    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }


}
