package com.example.user.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/17/2017.
 */

public class RecylerviewAdapter extends RecyclerView.Adapter<RecylerviewAdapter.AAA>
{
    List<RecylerViewObjects> list = new ArrayList<>();

    private TestListener listener;

    public RecylerviewAdapter()
    {

    }

    public void setOnTextListener(TestListener listener) {

        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position)
    {
        return list.get(position).type;
    }


    @Override
    public RecylerviewAdapter.AAA onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = null;

        switch (viewType)
        {
            case 0:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_student, parent, false);
                return new AAAProduct(itemView);

            case 1:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_new, parent, false);
                return new BBBProduct(itemView);
        }

        return new AAA(itemView);
    }

    @Override
    public void onBindViewHolder(RecylerviewAdapter.AAA holder, int position)
    {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void addItem(RecylerViewObjects recylerViewObjects)
    {
        list.add(recylerViewObjects);
    }


    public class AAA extends RecyclerView.ViewHolder
    {
        public AAA(View view) {
            super(view);

        }

        public void bindData(RecylerViewObjects recylerViewObjects)
        {


        }
    }

    public class AAAProduct extends AAA
    {
        public TextView textView;
        public ImageView imageView;

        public AAAProduct(View view)
        {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
            imageView = (ImageView)view.findViewById(R.id.imageView);

        }

        public void bindData(RecylerViewObjects recylerViewObjects)
        {
            textView.setText(recylerViewObjects.name);
        }

    }

    public class BBBProduct extends AAA
    {
        public Button button;
        public TextView textView;

        public BBBProduct(View view)
        {
            super(view);
            textView = (TextView) view.findViewById(R.id.textViewButton);
            button = (Button) view.findViewById(R.id.buttonClickMe);
            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int i = getAdapterPosition();
                    listener.onClick(textView.getText().toString() + i);
                }
            });
        }

        public void bindData(RecylerViewObjects recylerViewObjects)
        {
            textView.setText(recylerViewObjects.address);
        }



    }
}
