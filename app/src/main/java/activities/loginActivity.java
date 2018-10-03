package activities;

import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.stage3.myapplication.R;

import features.loginFragment;

public class loginActivity extends AppCompatActivity implements loginFragment.OnFragmentInteractionListener{

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ConstraintLayout sfondo = (ConstraintLayout) findViewById(R.id.sfondoLogin);
        sfondo.setBackgroundColor(Color.rgb(135,206,250));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        loginFragment fragment = new loginFragment();
        fragmentTransaction.add(R.id.frConteiner, fragment);
        fragmentTransaction.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onBackPressed() {
        this.finishAffinity();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
