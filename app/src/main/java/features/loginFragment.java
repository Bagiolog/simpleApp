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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link loginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link loginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class loginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public loginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static loginFragment newInstance(String param1, String param2) {
        loginFragment fragment = new loginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
                if(finalControlloSalvaDati1 || (eUsername.getText().toString()).equals(getString(R.string.username1))) {
                    if ((ePassword.getText().toString()).equals(getString(R.string.password1))) {
                        if(finalControlloSalvaDati1){
                            String username = preferences.getString("username",null);;
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
                }
            }

        });

    }

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
