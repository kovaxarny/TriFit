package com.kovaxarny.trifit.rss;

import java.util.List;

/**
 * Created by kovax on 2018-02-20.
 */
    public class RSSObject
    {
        public String status;
        public RSSFeed feed;
        public List<RSSItem> items;

        public RSSObject(String status, RSSFeed feed, List<RSSItem> items) {
            this.status = status;
            this.feed = feed;
            this.items = items;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public RSSFeed getFeed() {
            return feed;
        }

        public void setFeed(RSSFeed feed) {
            this.feed = feed;
        }

        public List<RSSItem> getItems() {
            return items;
        }

        public void setItems(List<RSSItem> items) {
            this.items = items;
        }
    }

