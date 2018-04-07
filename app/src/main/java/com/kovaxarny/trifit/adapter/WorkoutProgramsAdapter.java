package com.kovaxarny.trifit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.workout.WorkoutStyleModel;
import com.kovaxarny.trifit.exercise.ExerciseListActivity;
import com.kovaxarny.trifit.exercise.cardio.RunningActivity;
import com.kovaxarny.trifit.rss.ItemClickListener;

import java.util.ArrayList;

/**
 * Created by kovax on 2018-02-26.
 */

public class WorkoutProgramsAdapter extends RecyclerView.Adapter<WorkoutProgramsAdapter.WorkoutProgramsViewHolder> {

    private ArrayList<WorkoutStyleModel> workoutStyleArrayList;
    private LayoutInflater inflater;

    public WorkoutProgramsAdapter(Context context, ArrayList<WorkoutStyleModel> workoutStyleArrayList) {
        this.workoutStyleArrayList = workoutStyleArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public WorkoutProgramsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.workoutprograms_list_item, parent, false);
        return new WorkoutProgramsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WorkoutProgramsViewHolder holder, int position) {
        WorkoutStyleModel workoutStyle = workoutStyleArrayList.get(position);
        holder.wpTitle.setText(workoutStyle.getStyleName());
        holder.wpImage.setImageResource(workoutStyle.getStyleImage());

        int childViews = holder.linearLayout_ChildItems.getChildCount();
        int child = workoutStyle.getWorkoutModelItems().size();
        if (child < childViews) {
            for (int i = child; i < childViews; i++) {
                LinearLayout currentLinearLayout = (LinearLayout) holder.linearLayout_ChildItems.getChildAt(i);
                currentLinearLayout.setVisibility(View.GONE);
            }
        }
        for (int linearLayoutIndex = 0; linearLayoutIndex < child; linearLayoutIndex++) {
            LinearLayout currentLinearLayout = (LinearLayout) holder.linearLayout_ChildItems.getChildAt(linearLayoutIndex);
            for (int i = 0; i < currentLinearLayout.getChildCount(); i++) {
                if (currentLinearLayout.getChildAt(i).getClass() == TextView.class) {
                    TextView currentTextView = (TextView) currentLinearLayout.getChildAt(i);
                    currentTextView.setText(workoutStyle.getWorkoutModelItems().get(linearLayoutIndex).getWorkoutName());
                }
                if (currentLinearLayout.getChildAt(i).getClass() == ImageView.class) {
                    ImageView currentImageView = (ImageView) currentLinearLayout.getChildAt(i);
                    currentImageView.setImageResource(workoutStyle.getWorkoutModelItems().get(linearLayoutIndex).getWorkoutImage());
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if (workoutStyleArrayList != null) {
            return workoutStyleArrayList.size();
        } else {
            return 0;
        }
    }

    class WorkoutProgramsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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

            int maxNoOfChild = 0;
            for (int i = 0; i < workoutStyleArrayList.size(); i++) {
                int currentSize = workoutStyleArrayList.get(i).getWorkoutModelItems().size();
                if (currentSize > maxNoOfChild) maxNoOfChild = currentSize;
            }
            for (int i = 0; i < maxNoOfChild; i++) {
                TextView textView = new TextView(context);
                textView.setId(i);
                textView.setPadding(0, 20, 0, 20);
                textView.setTextSize(18);
                textView.setGravity(Gravity.CENTER);

                ImageView imageView = new ImageView(context);
                imageView.setId(i);
                imageView.setAdjustViewBounds(true);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setOnClickListener(this);
                linearLayout.setId(i);
                linearLayout.setBackgroundResource(R.drawable.border);
                linearLayout.setPadding(10, 0, 10, 10);

                linearLayout.addView(textView, layoutParams);
                linearLayout.addView(imageView);

                layoutParams.setMargins(20, 10, 20, 0);
                linearLayout_ChildItems.addView(linearLayout, layoutParams);
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

                startNewActivity(currentTextView.getText().toString());

            }
        }

        private void startNewActivity(String name) {
            if (name.equals("Walking")) {
                Intent RunningActivityIntent = new Intent(context, RunningActivity.class);
                context.startActivity(RunningActivityIntent);
            } else if (name.equals("Running")) {
                Intent RunningActivityIntent = new Intent(context, RunningActivity.class);
                context.startActivity(RunningActivityIntent);
            } else if (name.equals("Bicycle")) {
                Intent RunningActivityIntent = new Intent(context, RunningActivity.class);
                context.startActivity(RunningActivityIntent);
            } else if (name.equals("Skipping")) {
                Intent RunningActivityIntent = new Intent(context, RunningActivity.class);
                context.startActivity(RunningActivityIntent);
            } else {
                Intent exerciseDetailsActivityIntent = new Intent(context, ExerciseListActivity.class);
                exerciseDetailsActivityIntent.putExtra("muscle", name);
                context.startActivity(exerciseDetailsActivityIntent);
            }
        }
    }
}
