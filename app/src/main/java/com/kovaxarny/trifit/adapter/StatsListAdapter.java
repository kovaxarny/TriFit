package com.kovaxarny.trifit.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.BodyStatsContract;

import java.util.Locale;

/**
 * Created by kovax on 2018-02-11.
 */

public class StatsListAdapter extends RecyclerView.Adapter<StatsListAdapter.StatsViewHolder>{

    private Context mContext;
    private Cursor mCursor;

    public StatsListAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    @Override
    public StatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.stats_list_item, parent, false);
        return new StatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatsViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position))
            return;

        Integer height = mCursor.getInt(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT));
        Double weight = mCursor.getDouble(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT));
        String date = mCursor.getString(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_TIMESTAMP));

        holder.heightTextView.setText(String.valueOf(height));
        holder.weightTextView.setText(String.format(Locale.US,"%.2f",weight));
        holder.timeStampTextView.setText(date);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    class StatsViewHolder extends RecyclerView.ViewHolder {

        TextView heightTextView;
        TextView weightTextView;
        TextView timeStampTextView;

        public StatsViewHolder(View itemView) {
            super(itemView);
            heightTextView = (TextView) itemView.findViewById(R.id.height_text_view);
            weightTextView = (TextView) itemView.findViewById(R.id.weight_text_view);
            timeStampTextView = (TextView) itemView.findViewById(R.id.timestamp_text_view);
        }

    }
}
