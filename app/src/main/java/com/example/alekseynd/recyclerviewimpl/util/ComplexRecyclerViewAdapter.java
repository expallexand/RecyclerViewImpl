package com.example.alekseynd.recyclerviewimpl.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alekseynd.recyclerviewimpl.R;
import com.example.alekseynd.recyclerviewimpl.data.User;
import com.example.alekseynd.recyclerviewimpl.ui.RecyclerFragment;
import com.example.alekseynd.recyclerviewimpl.ui.RecyclerViewSimpleTextViewHolder;
import com.example.alekseynd.recyclerviewimpl.ui.ViewHolderImage;
import com.example.alekseynd.recyclerviewimpl.ui.ViewHolderUser;


import java.util.List;

public class ComplexRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> mItems;

    public static final int USER = 0, IMAGE = 1;

    public ComplexRecyclerViewAdapter(List<Object> items) {
        this.mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position) instanceof User) {
            return USER;
        } else if (mItems.get(position) instanceof String) {
            return IMAGE;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case USER:
                View v1 = inflater.inflate(R.layout.viewholder_text, parent, false);
                viewHolder = new ViewHolderUser(v1);
                break;
            case IMAGE:
                View v2 = inflater.inflate(R.layout.viewholder_image, parent, false);
                viewHolder = new ViewHolderImage(v2);
                break;
            default:
                View v = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                viewHolder = new RecyclerViewSimpleTextViewHolder(v);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch(holder.getItemViewType()) {
            case USER:
                ViewHolderUser vhUser = (ViewHolderUser) holder;
                configureViewHolderUser(vhUser, position);
                break;
            case IMAGE:
                ViewHolderImage vhImage = (ViewHolderImage) holder;
                configureViewHolderImage(vhImage, position);
                break;
            default:
                RecyclerViewSimpleTextViewHolder vhDefault = (RecyclerViewSimpleTextViewHolder) holder;
                confgureDefaultViewHolder(vhDefault, position);
                break;
        }
    }

    private void confgureDefaultViewHolder(RecyclerViewSimpleTextViewHolder vhDefault, int position) {
        vhDefault.getSimpleTextView().setText((CharSequence) mItems.get(position));
    }

    private void configureViewHolderUser(ViewHolderUser vhUser, int position) {
        User user = (User) mItems.get(position);
        if (user != null) {
            vhUser.getTvFirstName().setText("Name: " + user.getFirstname());
            vhUser.getTvSecondName().setText("Family: " + user.getSecondName());
        }
    }

    private void configureViewHolderImage(ViewHolderImage vhImage, int position) {

        vhImage.getImageView().setImageResource(R.drawable.ic_launcher_background);
    }

    public void addItem(RecyclerFragment context, int type) {
        switch(type) {
            case IMAGE:
                mItems.add("image");
                notifyItemInserted(mItems.size());
                break;
            case USER:
                mItems.add(new User("Test", "Test"));
                notifyItemInserted(mItems.size());
                break;
            default:
                break;
        }
    }

    public void deleteItem(int position) {
        mItems.remove(position);
        notifyDataSetChanged();
    }

}
