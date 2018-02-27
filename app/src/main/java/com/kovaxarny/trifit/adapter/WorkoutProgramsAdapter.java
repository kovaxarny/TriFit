package com.kovaxarny.trifit.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.workout.WorkoutStyleModel;
import com.kovaxarny.trifit.rss.ItemClickListener;

import java.util.ArrayList;

/**
 * Created by kovax on 2018-02-26.
 */

public class WorkoutProgramsAdapter extends RecyclerView.Adapter<WorkoutProgramsAdapter.WorkoutProgramsViewHolder> {

    private Context mContext;

//    private int[] imageArray;
//    private String[] titleArray;

    private ArrayList<WorkoutStyleModel> workoutStyleModelArrayList;

    private LayoutInflater inflater;

    public WorkoutProgramsAdapter(Context mContext, ArrayList<WorkoutStyleModel> workoutStyleModelArrayList) {
        this.mContext = mContext;
        this.workoutStyleModelArrayList = workoutStyleModelArrayList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public WorkoutProgramsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.workoutprograms_list_item ,parent,false);
        return new WorkoutProgramsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WorkoutProgramsViewHolder holder, int position) {
        WorkoutStyleModel workoutStyleModel = workoutStyleModelArrayList.get(position);
        holder.wpTitle.setText(workoutStyleModel.getStyleName());
        holder.wpImage.setImageResource(workoutStyleModel.getStyleImage());

        int noOfChildTextViews = holder.linearLayout_ChildItems.getChildCount();
        int noOfChild = workoutStyleModel.getWorkoutModelItems().size();
        if (noOfChild < noOfChildTextViews) {
            for (int index = noOfChild; index < noOfChildTextViews; index++) {
                TextView currentTextView = (TextView) holder.linearLayout_ChildItems.getChildAt(index);
                currentTextView.setVisibility(View.GONE);
            }
        }
        for (int textViewIndex = 0; textViewIndex < noOfChild; textViewIndex++) {
            TextView currentTextView = (TextView) holder.linearLayout_ChildItems.getChildAt(textViewIndex);
            currentTextView.setText(workoutStyleModel.getWorkoutModelItems().get(textViewIndex).getWorkoutName());
                /*currentTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "" + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });*/
        }
    }

    @Override
    public int getItemCount() {
        if (workoutStyleModelArrayList != null){
            return workoutStyleModelArrayList.size();
        }else{
            return 0;
        }
    }

    class WorkoutProgramsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private static final String TAG = "WorkoutProgramsViewHold";

        private Context context;
        private TextView wpTitle;
        private ImageView wpImage;
        private LinearLayout linearLayout_ChildItems;

        private ItemClickListener itemClickListener;

        public WorkoutProgramsViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            wpTitle = (TextView) itemView.findViewById(R.id.tv_wp_title);
            wpImage = (ImageView) itemView.findViewById(R.id.iv_wp_image);
            linearLayout_ChildItems = (LinearLayout) itemView.findViewById(R.id.ll_child_items);
            linearLayout_ChildItems.setVisibility(View.GONE);

            int intMaxNoOfChild = 0;
            for (int index = 0; index < workoutStyleModelArrayList.size(); index++) {
                int intMaxSizeTemp = workoutStyleModelArrayList.get(index).getWorkoutModelItems().size();
                if (intMaxSizeTemp > intMaxNoOfChild) intMaxNoOfChild = intMaxSizeTemp;
            }
            for (int indexView = 0; indexView < intMaxNoOfChild; indexView++) {
                TextView textView = new TextView(context);
                textView.setId(indexView);
                textView.setPadding(0, 20, 0, 20);
                textView.setGravity(Gravity.CENTER);
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.background_sub_module_text));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                textView.setOnClickListener(this);
                linearLayout_ChildItems.addView(textView, layoutParams);
            }

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.card_view) {
                if (linearLayout_ChildItems.getVisibility() == View.VISIBLE) {
                    linearLayout_ChildItems.setVisibility(View.GONE);
                } else {
                    linearLayout_ChildItems.setVisibility(View.VISIBLE);
                }
            } else {
                TextView childTextView = (TextView) view;
                Toast.makeText(context, "" + childTextView.getText(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(mContext,String.valueOf(view.getId()), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
