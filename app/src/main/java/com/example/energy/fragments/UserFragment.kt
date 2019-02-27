package com.example.energy.fragments


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.energy.R
import kotlinx.android.synthetic.main.fragment_user.*

import com.jjoe64.graphview.series.DataPoint

import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.LineGraphSeries


class UserFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            UserFragment().apply {

            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val series1 = LineGraphSeries<DataPoint>(
            arrayOf<DataPoint>(
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 5.0),
                DataPoint(2.0, 3.0),
                DataPoint(3.0, 2.0),
                DataPoint(4.0, 6.0)
            )
        )
        series1.title = "Random Curve 1";
        series1.color = Color.GREEN;
        series1.isDrawDataPoints = true
        series1.dataPointsRadius = 10F
        series1.thickness = 8
        graph1.addSeries(series1)
        graph1.viewport.isScalable = true
        graph1.viewport.isScrollable = true
        graph1.viewport.setScalableY(true)
        graph1.viewport.setScrollableY(true)

        val series = BarGraphSeries(
            arrayOf(
                DataPoint(0.0, -1.0),
                DataPoint(1.0, 5.0),
                DataPoint(2.0, 3.0),
                DataPoint(3.0, 2.0),
                DataPoint(4.0, 6.0)
            )
        )
        graph.addSeries(series)


        series.setValueDependentColor { data ->
            Color.rgb(
                data.x.toInt() * 255 / 4,
                Math.abs(data.y * 255 / 6).toInt(),
                100
            )
        }

        series.spacing = 50
        series.isDrawValuesOnTop = true
        series.valuesOnTopColor = Color.RED


    }
}
