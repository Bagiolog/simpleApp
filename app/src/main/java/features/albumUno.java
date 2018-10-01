package features;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.stage3.myapplication.R;

import java.util.List;

import entities.Photo;
import helpers.RecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.GetDataService;
import services.RetrofitIstance;

public class albumUno extends Fragment {
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;


    private OnFragmentInteractionListener mListener;

    public albumUno() { }

    public static albumUno newInstance() {
        return new albumUno();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_album_uno,container,false);
        GetDataService service= RetrofitIstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Photo>> call= service.getAllPhotos(1);
        recyclerView = v.findViewById(R.id.recyclerView);
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                generateDataList(response.body(),recyclerView);
            }
            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
        return v;
    }

    private void generateDataList(List<Photo> photoList,RecyclerView recyclerView) {
        recyclerViewAdapter = new RecyclerViewAdapter(photoList,getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
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
