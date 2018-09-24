package com.example.stage3.myapplication;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import java.util.ArrayList;

public class home extends AppCompatActivity implements albumUno.OnFragmentInteractionListener , albumDue.OnFragmentInteractionListener, albumTre.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));


    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
