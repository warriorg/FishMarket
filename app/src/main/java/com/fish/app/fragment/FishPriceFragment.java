package com.fish.app.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.fish.adapter.FishPortAdapter;
import com.fish.app.R;
import com.fish.entity.DummyDb;
import com.fish.entity.FishEntity;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FishPriceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FishPriceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FishPriceFragment extends Fragment implements ListView.OnItemClickListener {
    private OnFragmentInteractionListener mListener;

    private static FishPriceFragment instance = new FishPriceFragment();


    public static FishPriceFragment newInstance() {
        return instance;
    }

    private ListView mListView;
    private FishPortAdapter mAdapter;
    private int position;
    List<FishEntity> fishPort;

    private String fishName;

    private FishPriceFragment() {

    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fishPort  = DummyDb.portList(position);
        fishName = fishPort.get(0).getName();
        mAdapter = new FishPortAdapter(getActivity(), fishPort);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fish_price, container, false);

        TextView name = (TextView) view.findViewById(R.id.fish_name);
        name.setText(fishName);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.price_trend);

        layout.addView(graphicalLineChart(), new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        mListView = (ListView) view.findViewById(R.id.fish_price_list);
        mListView.setOnItemClickListener(this);
        mListView.setAdapter(mAdapter);

        return view;
    }

    private int randomInt()
    {
        return (int)(Math.random() * (100-30) + 30);
    }


    public GraphicalView graphicalLineChart() {

        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();

        Random random = new Random();
        List<double[]> xValue = new ArrayList<double[]>();
        xValue.add(new double[]{1d, 2d, 3d, 4d, 5d, 6d});
        List<double[]> yValue = new ArrayList<double[]>();
        yValue.add(new double[]{randomInt(), randomInt(), randomInt(), randomInt(), randomInt(), randomInt()});
        String[] titles = new String[]{"价格走势"};

        addXYSeries(dataset, titles, xValue, yValue, 0);

        // renderer.setBackgroundColor(Color.WHITE);
        // renderer.setApplyBackgroundColor(true);
        renderer.setChartTitle("趋势图");
        renderer.setChartTitleTextSize(20);
        renderer.setLegendTextSize(20);
        renderer.setMarginsColor(Color.WHITE);
        renderer.setAxesColor(Color.BLACK);
        renderer.setXLabelsColor(Color.BLACK);
        renderer.setYLabelsColor(0, Color.BLACK);
        renderer.setYAxisMax(100);
        renderer.setYAxisMin(30);
        renderer.setPanEnabled(false, false);

        // renderer.addXTextLabel(1, "201201");
        // renderer.addXTextLabel(2, "201201");
        // renderer.addXTextLabel(3, "201201");
        // renderer.addXTextLabel(4, "201201");
        // renderer.addXTextLabel(5, "201201");
        // renderer.addXTextLabel(6, "201201");

        XYSeriesRenderer xyRenderer = new XYSeriesRenderer();
        xyRenderer.setColor(Color.RED);
        xyRenderer.setLineWidth(3);

        xyRenderer.setPointStyle(PointStyle.POINT);
        renderer.addSeriesRenderer(xyRenderer);

        // renderer.setXLabels(12);
        // renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Paint.Align.RIGHT);
        renderer.setYLabelsAlign(Paint.Align.RIGHT);
        renderer.setZoomButtonsVisible(false);
        renderer.setZoomRate(1.05f);

        GraphicalView mChartView = ChartFactory.getLineChartView(getActivity(), dataset, renderer);
        mChartView.setBackgroundColor(Color.WHITE);
        return mChartView;
    }

    public void addXYSeries(XYMultipleSeriesDataset dataset, String[] titles, List<double[]> xValues,
                            List<double[]> yValues, int scale) {
        int length = titles.length;
        for (int i = 0; i < length; i++) {
            XYSeries series = buildXYSeries(titles[i], xValues.get(i), yValues.get(i), scale);
            dataset.addSeries(series);
        }
    }

    public XYSeries buildXYSeries(String title, double[] xValue, double[] yValus, int scale) {
        int seriesLength = xValue.length;
        XYSeries series = new XYSeries(title, scale);
        for (int k = 0; k < seriesLength; k++) {
            series.add(xValue[k], yValus[k]);
        }
        return series;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {

            mListener.onFragmentInteraction(fishPort.get(position));
        }
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(FishEntity fishPort);
    }

}
