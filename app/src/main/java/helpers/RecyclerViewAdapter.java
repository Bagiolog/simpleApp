package helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stage3.myapplication.R;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import entities.Photo;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Photo> dataList;
    private Context context;

    public RecyclerViewAdapter(List<Photo> dataList,Context context){
        this.dataList=dataList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtTitle.setText(" "+dataList.get(i).getTitle()+"\n");
        //imageView
        /*Picasso.Builder builder =new Picasso.Builder(context);
        builder.downloader(new OkHttpDownloader(context));
        builder.build().load(dataList.get(i).getThumbanailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(viewHolder.coverImage);*/
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView txtTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;

            txtTitle=mView.findViewById(R.id.title);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
