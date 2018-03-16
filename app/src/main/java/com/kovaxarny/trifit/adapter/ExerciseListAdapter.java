package com.kovaxarny.trifit.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.workout.ExerciseContract;
import com.kovaxarny.trifit.data.workout.ExerciseModel;

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

        ExerciseModel exerciseModel = new ExerciseModel();
        exerciseModel.setName(cursor.getString(cursor.getColumnIndex(ExerciseContract.ExerciseEntry.COLUMN_NAME)));

        holder.nameTextView.setText(exerciseModel.getName());
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;

        public ExerciseViewHolder(View itemView) {
            super(itemView);
            this.nameTextView = (TextView) itemView.findViewById(R.id.tv_exercise_title);
        }
    }
}
