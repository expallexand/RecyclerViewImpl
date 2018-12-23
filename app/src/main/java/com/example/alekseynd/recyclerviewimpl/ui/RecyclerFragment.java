package com.example.alekseynd.recyclerviewimpl.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.alekseynd.recyclerviewimpl.R;
import com.example.alekseynd.recyclerviewimpl.data.User;
import com.example.alekseynd.recyclerviewimpl.util.ComplexRecyclerViewAdapter;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ComplexRecyclerViewAdapter mComplexRecyclerViewAdapter;

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add_typeUser_item:
                mComplexRecyclerViewAdapter.addItem(this, ComplexRecyclerViewAdapter.USER);
                mComplexRecyclerViewAdapter.notifyItemChanged(mComplexRecyclerViewAdapter.getItemCount());
                mRecyclerView.scrollToPosition(mComplexRecyclerViewAdapter.getItemCount()-1);
                return true;
            case R.id.action_add_image_item:
                mComplexRecyclerViewAdapter.addItem(this, ComplexRecyclerViewAdapter.IMAGE);
                mComplexRecyclerViewAdapter.notifyItemChanged(mComplexRecyclerViewAdapter.getItemCount());
                mRecyclerView.scrollToPosition(mComplexRecyclerViewAdapter.getItemCount()-1);
                return true;
            case R.id.action_exit:
                System.exit(0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<Object> getInitData() {
        ArrayList<Object> items = new ArrayList<>();
        items.add(new User("Coming ", "Soon!"));
        items.add("image");

        return items;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setRetainInstance(true);
          setHasOptionsMenu(true);

        mComplexRecyclerViewAdapter = new ComplexRecyclerViewAdapter(getInitData());
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fr_recycler, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recycler);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mComplexRecyclerViewAdapter);
    }
}
