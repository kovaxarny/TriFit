package com.kovaxarny.trifit.rss;

/**
 * Created by kovax on 2018-02-20.
 */

public class RSSEnclosure
{
    public String link;

    public RSSEnclosure(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}