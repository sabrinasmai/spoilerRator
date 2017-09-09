package com.example.androidthings.simpleui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.example.androidthings.simpleui.R.id.graph;

/**
 * Created by Ridhwaan on 9/9/17.
 */

public class GraphActivity extends Activity {


    private GraphView mGraphView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        mGraphView = (GraphView) findViewById(graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        mGraphView.addSeries(series);
    }
}

