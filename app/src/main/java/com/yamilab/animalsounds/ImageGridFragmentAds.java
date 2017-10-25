package com.yamilab.animalsounds;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.R.attr.screenSize;
import static com.yamilab.animalsounds.R.id.recyclerView;

/**
 * Created by Misha on 28.03.2017.
 */
public class ImageGridFragmentAds extends Fragment {


    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 40;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }
    protected LayoutManagerType mCurrentLayoutManagerType;
    private int gridCount = 2;
    protected RecyclerView mRecyclerView;
    protected CustomLinkAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<LinkItem> mDataset;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = rootView.findViewById(recyclerView);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;
        if (screenSize>=Configuration.SCREENLAYOUT_SIZE_LARGE) gridCount=3;
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(gridCount, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gaggeredGridLayoutManager);


        mAdapter = new CustomLinkAdapter(mDataset);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)



        return rootView;
    }


    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {

        mDataset = new ArrayList<>();

        mDataset.add(new LinkItem(
                getString(R.string.fromdottodot),
                R.drawable.fromdottodot,
                "market://details?id=xyz.yapapa.fromdottodot"));

        mDataset.add(new LinkItem(
                getString(R.string.draw),
                R.drawable.promodraw,
                "market://details?id=xyz.yapapa.draw"));

        mDataset.add(new LinkItem(
                getString(R.string.lullaby),
                R.drawable.lullababy,
                "market://details?id=com.yamilab.lullababy"));

        mDataset.add(new LinkItem(
                getString(R.string.recipe),
                R.drawable.recipe,
                "market://details?id=xyz.yapapa.recipe"));

        mDataset.add(new LinkItem(
                getString(R.string.rebuses),
                R.drawable.rebuses,
                "market://details?id=xyz.yapapa.rebuses"));

        mDataset.add(new LinkItem(
                getString(R.string.recipeabc),
                R.drawable.promoabc,
                "market://details?id=xyz.yapapa.recipeabc"));

    }
}
