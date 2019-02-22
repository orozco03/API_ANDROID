package www.mensajerosurbanos.com.co.login;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import www.mensajerosurbanos.com.co.login.Activitys.Main2Activity;
import www.mensajerosurbanos.com.co.login.Models.Artists;
import www.mensajerosurbanos.com.co.login.Models.CardModelo;
import www.mensajerosurbanos.com.co.login.Models.Image;
import www.mensajerosurbanos.com.co.login.Models.ScrollListener;
import www.mensajerosurbanos.com.co.login.Models.Topartists;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Artists> dataList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Artists> dataList) {
        this.context = context;
        this.dataList = dataList;

    }
        public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, url;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.text_name);
            img = itemView.findViewById(R.id.img);
            url = itemView.findViewById(R.id.text_url);
        }
    }

    ArrayList<Artists> list = new ArrayList<>();


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(final ViewHolder holder, int position){
        holder.name.setText(dataList.get(position).getName());
        holder.url.setText(dataList.get(position).getUrl());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getListaImg()[4].getText())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.img);


        holder.url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Main2Activity.class);
                i.putExtra("web", holder.url.getText().toString());
                context.startActivity(i);
            }
        });
    }

    public int getItemCount(){
        return dataList.size();
    }
}
