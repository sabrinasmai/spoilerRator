package com.example.androidthings.simpleui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ridhwaan on 9/9/17.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private Context mContext;
    private ArrayList<FoodItem> mDataset;



    public FoodListAdapter(Context context,  ArrayList<FoodItem> listOfItems){
        this.mContext = context;
        this.mDataset = listOfItems ;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.single_food_item_list, parent,false);
        return new FoodViewHolder(v);

    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {

        FoodItem item = mDataset.get(position);
        holder.bindholder(item,mContext);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView mTitle;
    private TextView mStatus;
    private TextView mDate;
    private FrameLayout mStatusColor;
    private FrameLayout mDateContainer;
    private Context mContext;


    public FoodViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.tv_title);
        mStatus = (TextView)itemView.findViewById(R.id.container);
        mStatusColor = (FrameLayout) itemView.findViewById(R.id.status_container);

        
        mDate = (TextView) itemView.findViewById(R.id.date);
        mDateContainer = (FrameLayout) itemView.findViewById(R.id.date_container);

    }


    @Override
    public void onClick(View v) {

        Intent i = new Intent(mContext,GraphActivity.class);
        mContext.startActivity(i);

    }

    public void bindholder(FoodItem item,Context c){

        mTitle.setText(item.getmName());
        mStatus.setText(item.getmStatus());
        mDate.setText(item.getmDate());


        switch (item.getmStatus()) {

            case Config.FRESH:
                mStatusColor.setBackgroundColor(Color.GREEN);
                break;

            case Config.SPOILED:
                mStatusColor.setBackgroundColor(Color.RED);
                break;

            default: mStatusColor.setBackgroundColor(Color.YELLOW);
                break;

        }


    }
}