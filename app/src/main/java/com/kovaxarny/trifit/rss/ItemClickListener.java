package com.kovaxarny.trifit.rss;

import android.view.View;

/**
 * Created by kovax on 2018-02-20.
 */

public interface ItemClickListener {
    void onClick(View view, int position, boolean isLongClick);
}
