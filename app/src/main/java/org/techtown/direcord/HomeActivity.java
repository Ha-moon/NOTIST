package org.techtown.direcord;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentHome fragmentHome;
    FragmentList fragmentList;
    FragmentRecord fragmentRecord;
    FragmentGroup fragmentGroup;
    FragmentSettings fragmentSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        fragmentHome = new FragmentHome();
        fragmentList = new FragmentList();
        fragmentRecord = new FragmentRecord();
        fragmentGroup = new FragmentGroup();
        fragmentSettings = new FragmentSettings();

        //제일 처음 띄워줄 뷰를 세팅해줍니다. commit();까지 해줘야 합니다.
        getSupportFragmentManager().beginTransaction().replace(R.id.home_layout,fragmentHome).commitAllowingStateLoss();
        //bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록
        // 리스너를 추가합니다.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_layout,fragmentHome).commitAllowingStateLoss();
                        return true;
                    case R.id.list:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_layout,fragmentList).commitAllowingStateLoss();
                        return true;
                    case R.id.record:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_layout,fragmentRecord).commitAllowingStateLoss();
                        return true;

                    case R.id.group:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_layout,fragmentGroup).commitAllowingStateLoss();
                        return true;

                    case R.id.settings:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_layout,fragmentSettings).commitAllowingStateLoss();
                        return true;
                }
                return false;
            }

        });
    }
}
