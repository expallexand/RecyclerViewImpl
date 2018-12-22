package com.example.alekseynd.recyclerviewimpl.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alekseynd.recyclerviewimpl.R;

public class RecyclerViewSimpleTextViewHolder extends RecyclerView.ViewHolder {

    private TextView mSimpleTextView;

    public RecyclerViewSimpleTextViewHolder(View view) {
        super(view);
        mSimpleTextView = view.findViewById(R.id.simple_text);
    }

    public TextView getSimpleTextView() {
        return mSimpleTextView;
    }

    public void setSimpleTextView(TextView simpleTextView) {
        mSimpleTextView = simpleTextView;
    }
}
