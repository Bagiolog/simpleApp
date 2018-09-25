package com.example.stage3.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Switch simpleSwitch = (Switch) findViewById(R.id.simpleSwitch);

        final SharedPreferences preferences =getSharedPreferences("login", Context.MODE_PRIVATE);
        String username= preferences.getString("username",null);
        Boolean controlloSwitch=preferences.getBoolean("controlloSwitch",false);
        if(controlloSwitch){
            simpleSwitch.setChecked(true);
        }
        else{

            simpleSwitch.setChecked(false);
        }

        Button logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(settingsActivity.this,loginActivity.class);
                startActivity(intent);


            }
        });

        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("controlloSwitch",true);
                    editor.apply();
                }
                else{

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("controlloSwitch",false);
                    editor.apply();

                }

            }
        });

    }
}
