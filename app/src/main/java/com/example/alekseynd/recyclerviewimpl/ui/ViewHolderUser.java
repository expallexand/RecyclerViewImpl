package com.example.alekseynd.recyclerviewimpl.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alekseynd.recyclerviewimpl.R;

public class ViewHolderUser extends RecyclerView.ViewHolder {

    private TextView mTvFirstName, mTvSecondName;

    public ViewHolderUser(View view) {
        super(view);
        mTvFirstName = view.findViewById(R.id.tv_first_name);
        mTvSecondName = view.findViewById(R.id.tv_second_name);
    }

    public TextView getTvFirstName() {
        return mTvFirstName;
    }

    public void setTvFirstName(TextView tvFirstName) {
        this.mTvFirstName = tvFirstName;
    }

    public TextView getTvSecondName() {
        return mTvSecondName;
    }

    public void setTvSecondName(TextView tvSecondName) {
        this.mTvSecondName = tvSecondName;
    }
}
