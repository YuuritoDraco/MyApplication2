package com.example.user.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/17/2017.
 */

public class RecylerviewAdapter extends RecyclerView.Adapter<RecylerviewAdapter.AAA>
{
    List<String> list = new ArrayList<>();

    public RecylerviewAdapter()
    {

    }
    @Override
    public RecylerviewAdapter.AAA onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_student, parent, false);
        return new AAA(itemView);
    }

    @Override
    public void onBindViewHolder(RecylerviewAdapter.AAA holder, int position)
    {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void addItem(String stringItem)
    {
        list.add(stringItem);
    }


    public class AAA extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public ImageView imageView;

        public AAA(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.textView);
            imageView = (ImageView) view.findViewById((R.id.imageView));

        }
    }
}
