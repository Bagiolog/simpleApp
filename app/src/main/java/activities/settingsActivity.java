package activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.example.stage3.myapplication.R;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        RelativeLayout settingSfondo=(RelativeLayout)findViewById(R.id.sfondoSettings);
        settingSfondo.setBackgroundColor(Color.rgb(135,206,250));
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
