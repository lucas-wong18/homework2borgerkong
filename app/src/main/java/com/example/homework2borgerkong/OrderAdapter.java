package com.example.homework2borgerkong;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.homework2borgerkong.Order.itemCount;
import static com.example.homework2borgerkong.Order.menuCost;
import static com.example.homework2borgerkong.Order.menuOrder;
import static com.example.homework2borgerkong.Order.status;
import static com.example.homework2borgerkong.Order.totalCost;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private ArrayList<MenuItem> mExampleList1;

    public void setData(ArrayList<MenuItem> ordersToAdapt) {
        this.mExampleList1 = ordersToAdapt;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public ImageView mImageView2;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public View mView;



        public OrderViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.menuImage);
            mImageView2 = itemView.findViewById(R.id.delete);
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
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.example_order, parent, false);
        OrderViewHolder ovh = new OrderViewHolder(v);
        return ovh;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {
        final MenuItem currentItem = mExampleList1.get(position);

        holder.mImageView.setImageResource(currentItem.getImageID());
        holder.mTextView1.setText(currentItem.getName());
        holder.mTextView2.setText(currentItem.getBlurb());
        holder.mTextView3.setText("$" + String.format("%,.2f", currentItem.getCost()));

        double orderTotal = 0;
        for (double i : menuCost)
            orderTotal = orderTotal + i;
        String sums = String.format("%,.2f", orderTotal);
        totalCost.setText("$" + String.valueOf(sums));

        holder.mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuOrder.remove(currentItem);
                menuCost.remove(currentItem.getCost());
                notifyItemRemoved(position);


                int items = menuOrder.size();
                itemCount.setText(items + " Item(s) in Basket");

                double orderTotal = 0;
                for (double i : menuCost)
                    orderTotal = orderTotal + i;
                String sums = String.format("%,.2f", orderTotal);
                totalCost.setText("$" + String.valueOf(sums));

                if (menuOrder.size() < 1){
                    status.setText("No items in order.");
                }
            }
        });

        holder.mImageView.setImageResource(currentItem.getImageID());
    }

    @Override
    public int getItemCount() {
        return mExampleList1.size();
    }


}