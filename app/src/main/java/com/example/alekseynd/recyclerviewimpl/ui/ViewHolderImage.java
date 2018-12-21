package com.example.alekseynd.recyclerviewimpl.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.alekseynd.recyclerviewimpl.R;

public class ViewHolderImage extends RecyclerView.ViewHolder {

    private ImageView mImageExample;

    public ViewHolderImage(View view) {
        super(view);
        mImageExample = view.findViewById(R.id.ivExample);
    }

    public ImageView getImageView() {
        return mImageExample;
    }

    public void setImageView (ImageView imageExample) {
        mImageExample = imageExample;
    }
}
