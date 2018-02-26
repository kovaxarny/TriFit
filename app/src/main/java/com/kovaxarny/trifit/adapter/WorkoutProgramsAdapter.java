package com.kovaxarny.trifit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.rss.ItemClickListener;

/**
 * Created by kovax on 2018-02-26.
 */

public class WorkoutProgramsAdapter extends RecyclerView.Adapter<WorkoutProgramsAdapter.WorkoutProgramsViewHolder> {

    private Context mContext;

    private int[] imageArray;
    private String[] titleArray;

    private LayoutInflater inflater;

    public WorkoutProgramsAdapter(Context mContext, int[] imageArray, String[] titleArray) {
        this.mContext = mContext;
        this.imageArray = imageArray;
        this.titleArray = titleArray;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public WorkoutProgramsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.workoutprograms_list_item ,parent,false);
        return new WorkoutProgramsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WorkoutProgramsViewHolder holder, int position) {
        holder.wpTitle.setText(titleArray[position]);
        holder.wpImage.setImageResource(imageArray[position]);
    }

    @Override
    public int getItemCount() {
        if (imageArray != null){
            return imageArray.length;
        }else{
            return 0;
        }
    }

    class WorkoutProgramsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private static final String TAG = "WorkoutProgramsViewHold";
        public TextView wpTitle;
        private ImageView wpImage;

        private ItemClickListener itemClickListener;

        public WorkoutProgramsViewHolder(View itemView) {
            super(itemView);

            wpTitle = (TextView) itemView.findViewById(R.id.tv_wp_title);
            wpImage = (ImageView) itemView.findViewById(R.id.iv_wp_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: clicked");
        }
    }
}
