package com.example.user.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.user.myapplication.Constant.Const;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    RecyclerView recyclerView;
    RecylerviewAdapter adapter;

    List<String> list = new ArrayList<>();
    RecyclerView.LayoutManager mLayoutManager;

    private OnFragmentListener mListener;

    private TestListener testListener;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        adapter = new RecylerviewAdapter();

        mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, 20, true, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        RecylerViewObjects objects = new RecylerViewObjects();
        objects.name = "1";
        objects.type = 0;
        adapter.addItem(objects);

        objects = new RecylerViewObjects();
        objects.address = "jasdhkasjdh";
        objects.type = 1;
        adapter.addItem(objects);

        objects = new RecylerViewObjects();
        objects.address = "click clock";
        objects.type = 1;
        adapter.addItem(objects);

        objects = new RecylerViewObjects();
        objects.name = "AAASADASD";
        objects.type = 0;
        adapter.addItem(objects);

        objects = new RecylerViewObjects();
        objects.address = "HELLO";
        objects.type = 1;
        adapter.addItem(objects);

        adapter.notifyDataSetChanged();

        adapter.setOnTextListener(new TestListener()
        {
            @Override
            public void onCallBack()
            {

            }

            @Override
            public void onClick(String string)
            {
                Toast.makeText(getContext(), string, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentListener) {
            mListener = (OnFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentListener");
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
    public interface OnFragmentListener {
        // TODO: Update argument type and name

        void onGoBack();

    }

    public void setOnTextListener(TestListener listener) {

        listener = testListener;
    }
}
