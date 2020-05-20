package com.example.apphoctuvung.views;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.apphoctuvung.R;
import com.example.apphoctuvung.views.fragment.DanhSachTuVungFragment;
import com.example.apphoctuvung.views.fragment.HocAlphabetFragment;
import com.example.apphoctuvung.views.fragment.OnTapTuVungFragment;
import com.example.apphoctuvung.views.fragment.TraTuVungFragment;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navtratuvung);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new TraTuVungFragment()).commit();
        navigationView.setCheckedItem(R.id.navtratuvung);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.tratuvung:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new TraTuVungFragment()).commit();
                break;
            case R.id.danhsach:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new DanhSachTuVungFragment()).commit();
                break;
            case R.id.ontap:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new OnTapTuVungFragment()).commit();
                break;
            case R.id.hocbangchucai:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new HocAlphabetFragment()).commit();
                break;
            default:
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       App.dispose();
    }
}
