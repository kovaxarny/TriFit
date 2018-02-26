package com.kovaxarny.trifit.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.rss.ItemClickListener;
import com.kovaxarny.trifit.rss.RSSObject;

/**
 * Created by kovax on 2018-02-20.
 */


public class RSSFeedAdapter extends RecyclerView.Adapter<RSSFeedAdapter.FeedViewHolder> {

    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;

    public RSSFeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.rss_list_item, parent, false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.tvTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.tvPubDate.setText(rssObject.getItems().get(position).getPubDate());
        holder.tvContent.setText(rssObject.getItems().get(position).getContent());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.getItems().get(position).getLink()));
                    browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(browserIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (rssObject != null) {
            return rssObject.items.size();
        } else {
            return 0;
        }
    }

    class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public TextView tvTitle;
        public TextView tvPubDate;
        public TextView tvContent;

        private ItemClickListener itemClickListener;

        public FeedViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tv_rss_title);
            tvPubDate = (TextView) itemView.findViewById(R.id.tv_rss_pubDate);
            tvContent = (TextView) itemView.findViewById(R.id.tv_rss_content);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition(), true);
            return true;
        }
    }
}
