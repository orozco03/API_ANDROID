package www.mensajerosurbanos.com.co.login;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import www.mensajerosurbanos.com.co.login.Models.CardModelo;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView email;

        public ViewHolder(View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.text_email);
        }
    }

    public List<CardModelo> lista;

    public RecyclerViewAdapter(List<CardModelo> lista){
        this.lista = lista;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        holder.email.setText(lista.get(position).getEmail());
    }

    public int getItemCount(){
        return lista.size();
    }
}
