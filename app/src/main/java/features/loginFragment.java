package features;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stage3.myapplication.R;
import activities.homeActivity;
public class loginFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    public loginFragment() {
    }

    public static loginFragment newInstance() {
        return new loginFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @SuppressLint("SetTextI18n")
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        final EditText eUsername = (EditText) v.findViewById(R.id.eUsername);
        final EditText ePassword = (EditText) v.findViewById(R.id.ePassword);
        final TextView tUsername = (TextView) v.findViewById(R.id.tUsername);
        Button bLogin = (Button) v.findViewById(R.id.bLogin);
        boolean controlloSalvaDati=false;


        final String key="username";
        final SharedPreferences preferences = getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
        String username= preferences.getString("username",null);
        Boolean controlloSwitch=preferences.getBoolean("controlloSwitch",false);

        if(controlloSwitch){
            tUsername.setVisibility(View.VISIBLE);
            eUsername.setVisibility(View.INVISIBLE);
            tUsername.setText("Benvenuta "+username+" !");
            controlloSalvaDati=true;

        }
        final boolean finalControlloSalvaDati1 = controlloSalvaDati;
        bLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((eUsername.getText().toString()).equals("")) {
                    eUsername.setError("Inserisci il tuo username");
                }

                if(!eUsername.getText().toString().equals("") && (ePassword.getText().toString()).equals("")){
                    ePassword.setError("Inserisci la password");
                }

                if(finalControlloSalvaDati1 || (eUsername.getText().toString()).equals(getString(R.string.username1))) {
                    if ((ePassword.getText().toString()).equals(getString(R.string.password1))) {
                        if(finalControlloSalvaDati1){
                            String username = preferences.getString("username",null);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString(key, username);
                            editor.apply();
                            }
                            else{
                            String username = eUsername.getText().toString();
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString(key, username);
                            editor.apply();

                        }
                        Intent intent = new Intent(getActivity(), homeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        if((ePassword.getText().toString()).equals("")){
                            ePassword.setError("Inserisci la password");
                        }
                        else{
                            ePassword.setError("Password errata");
                        }

                    }
                }
            }

        });

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
