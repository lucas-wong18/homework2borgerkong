package com.example.homework2borgerkong;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private ArrayList<MenuItem> mExampleList;

    public void setData(ArrayList<MenuItem> mExampleList) {
        this.mExampleList = mExampleList;
    }


    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public View mView;



        public MenuViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.menuImage);
            mTextView1 = itemView.findViewById(R.id.menuName);
            mTextView2 = itemView.findViewById(R.id.menuBlurb);
            mTextView3 = itemView.findViewById(R.id.menuCost);
            mView = itemView;

        }
    }


    //    public ExampleAdapterBooks(ArrayList<Book> exampleList) {
//        mExampleList = exampleList;
//    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.example_menuitem, parent, false);

        MenuViewHolder mvh = new MenuViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        final MenuItem currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageID());
        holder.mTextView1.setText(currentItem.getName());
        holder.mTextView2.setText(currentItem.getBlurb());
        holder.mTextView3.setText("$"+ String.format("%,.2f", currentItem.getCost()));



        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {

                Context context = views.getContext();

                Intent test = new Intent(context, Click.class);
                test.putExtra("foodID", currentItem.getItemID());

                context.startActivity(test);
            }
        });

        holder.mImageView.setImageResource(currentItem.getImageID());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


}