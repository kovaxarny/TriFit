package com.kovaxarny.trifit.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.workout.ExerciseContract;
import com.kovaxarny.trifit.data.workout.ExerciseModel;
import com.kovaxarny.trifit.exercise.ExerciseDetailsActivity;
import com.kovaxarny.trifit.rss.ItemClickListener;

/**
 * Created by kovax on 2018-03-11.
 */

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder> {

    private Context context;
    private Cursor cursor;

    public ExerciseListAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exercise_list_item,parent,false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position) {
        if (!cursor.moveToPosition(position))
            return;

        final ExerciseModel exerciseModel = new ExerciseModel();
        exerciseModel.setName(cursor.getString(cursor.getColumnIndex(ExerciseContract.ExerciseEntry.COLUMN_NAME)));

        holder.nameTextView.setText(exerciseModel.getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick) {
                    Intent exerciseDetailsActivityIntent = new Intent(context, ExerciseDetailsActivity.class);
                    exerciseDetailsActivityIntent.putExtra("name", exerciseModel.getName());
                    context.startActivity(exerciseDetailsActivityIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nameTextView;

        private ItemClickListener itemClickListener;

        public ExerciseViewHolder(View itemView) {
            super(itemView);
            this.nameTextView = (TextView) itemView.findViewById(R.id.tv_exercise_title);

            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition(), false);
        }
    }
}
