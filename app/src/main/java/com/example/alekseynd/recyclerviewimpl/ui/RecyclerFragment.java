package com.example.alekseynd.recyclerviewimpl.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alekseynd.recyclerviewimpl.R;

public class RecyclerFragment extends Fragment {

    private RecyclerView mMRecyclerView;

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fr_recycler, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mMRecyclerView = view.findViewById(R.id.recycler);
    }
}
