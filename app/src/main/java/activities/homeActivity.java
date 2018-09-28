package activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stage3.myapplication.R;

import features.albumDue;
import features.albumTre;
import features.albumUno;
import helpers.ViewPagerAdapter;

public class homeActivity extends AppCompatActivity implements albumUno.OnFragmentInteractionListener , albumDue.OnFragmentInteractionListener, albumTre.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
        PagerTabStrip pagerTabStrip=(PagerTabStrip)findViewById(R.id.pts);
        pagerTabStrip.setDrawFullUnderline(true);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));



        Button impostazioni=(Button)findViewById(R.id.impostazioni);
        impostazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(homeActivity.this,settingsActivity.class);
                startActivity(intent);

            }
        });
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Ocio!")
                .setMessage("In questo modo effettuerai il logout!\nContinuare?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent=new Intent(homeActivity.this,loginActivity.class);
                        startActivity(intent);
                    }
                }).create().show();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
