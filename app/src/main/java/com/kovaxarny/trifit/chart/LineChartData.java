package com.kovaxarny.trifit.chart;

import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.bodystats.BodyStatsOperations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by kovax on 2018-04-04.
 */

public class LineChartData {
    private static final String TAG = "LineChartData";

    public static void fillChartWithData(LineChart lineChart,BodyStatsOperations bodyStatsOperations) {
        //Data init
        ArrayList<Entry> yValues = new ArrayList<Entry>();
        yValues = bodyStatsOperations.getLastTenEntry();

        //Reference Timestamp

        float referenceTimeStampInFloat = yValues.get(0).getX();
        Date date = new Date((long)referenceTimeStampInFloat);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1); //minus number would decrement the days
        date = cal.getTime();

        for (Entry entry : yValues) {
            entry.setX(entry.getX() - referenceTimeStampInFloat);
            Log.d(TAG, "fillChartWithData: entry " + entry.getX());
        }

        //Chart Design
        LineDataSet set1 = new LineDataSet(yValues, "Weight Over Time");
        set1.setFillAlpha(R.color.accent);
        set1.setColor(R.color.accent);
        set1.setLineWidth(3f);
        set1.setCircleColor(R.color.accent);

        IAxisValueFormatter xAxisFormatter = new DateAxisValueFormatter(date.getTime());
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(xAxisFormatter);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        data.notifyDataChanged(); // let the data know a dataSet changed
        lineChart.notifyDataSetChanged(); // let the chart know it's data changed
        lineChart.invalidate(); // refresh

        lineChart.setScaleEnabled(false);
        lineChart.setData(data);
    }

}
