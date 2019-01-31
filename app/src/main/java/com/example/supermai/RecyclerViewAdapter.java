package com.example.supermai;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Categorias> mData;

    public RecyclerViewAdapter(Context mContext, List<Categorias> mData){
        this.mContext = mContext;
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_categorias_name.setText(mData.get(position).getNombre());
        holder.iv_categorias_thumbnail.setImageResource(mData.get(position).getThumbnail());

        //set click listener
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, CategoriasActivity.class);

                //passing data to the category activity
                intent.putExtra("Nombre", mData.get(position).getNombre());
                intent.putExtra("Descripcion", mData.get(position).getDescripcion());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());
                //start the activity
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_categorias_name;
        ImageView iv_categorias_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_categorias_name = itemView.findViewById(R.id.tv_hogar);
            iv_categorias_thumbnail = itemView.findViewById(R.id.iv_hogar);
            cardView = itemView.findViewById(R.id.cardviewcat);
        }
    }
}
