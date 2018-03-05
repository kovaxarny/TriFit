package com.kovaxarny.trifit.adapter;

import android.content.Context;
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
                LinearLayout currentLinearLayout = (LinearLayout) holder.linearLayout_ChildItems.getChildAt(index);
                currentLinearLayout.setVisibility(View.GONE);
            }
        }
        for (int textViewIndex = 0; textViewIndex < noOfChild; textViewIndex++) {
            LinearLayout currentLinearLayout = (LinearLayout) holder.linearLayout_ChildItems.getChildAt(textViewIndex);
            for (int index = 0; index < currentLinearLayout.getChildCount(); index++){
                if (currentLinearLayout.getChildAt(index).getClass() == TextView.class){
                    TextView currentTextView = (TextView) currentLinearLayout.getChildAt(index);
                    currentTextView.setText(workoutStyleModel.getWorkoutModelItems().get(textViewIndex).getWorkoutName());
                }else{
                    if (currentLinearLayout.getChildAt(index).getClass() == ImageView.class){
                        ImageView currentImageView = (ImageView) currentLinearLayout.getChildAt(index);
                        currentImageView.setImageResource(workoutStyleModel.getWorkoutModelItems().get(textViewIndex).getWorkoutImage());
                    }
                }
            }
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
                textView.setTextSize(18);
                textView.setGravity(Gravity.CENTER);

                ImageView imageView = new ImageView(context);
                imageView.setId(indexView);
                imageView.setAdjustViewBounds(true);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setOnClickListener(this);
                linearLayout.setId(indexView);
                linearLayout.setBackgroundResource(R.drawable.border);
                linearLayout.setPadding(10,0,10,10);

                linearLayout.addView(textView, layoutParams);
                linearLayout.addView(imageView);

                layoutParams.setMargins(20,10,20,0);
                linearLayout_ChildItems.addView(linearLayout,layoutParams);
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
                LinearLayout childLinearLayout = (LinearLayout) view;
                TextView currentTextView = (TextView) childLinearLayout.getChildAt(0);
                Toast.makeText(context, "" + currentTextView.getText(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
