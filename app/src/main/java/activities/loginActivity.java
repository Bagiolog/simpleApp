package activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.stage3.myapplication.R;

import features.loginFragment;

public class loginActivity extends AppCompatActivity implements loginFragment.OnFragmentInteractionListener{
    //private long backPressedTime;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        loginFragment fragment = new loginFragment();
        fragmentTransaction.add(R.id.frConteiner, fragment);
        fragmentTransaction.commit();

    }
  /*  public void onBackPressed() {

        if(backPressedTime+2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }
        else{
            Toast.makeText(getBaseContext(),"Press back again to exit", Toast.LENGTH_SHORT).show();

        }
        backPressedTime=System.currentTimeMillis();
    }*/
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
