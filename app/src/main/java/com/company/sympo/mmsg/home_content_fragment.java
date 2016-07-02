package com.company.sympo.mmsg;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 04-06-2015.
 */
public class home_content_fragment extends Fragment {
    CollapsingToolbarLayout collapsingToolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // View v = inflater.inflate(R.layout.home_content_layout,container,false);
        View v = inflater.inflate(R.layout.new_home_flexible_layout,container,false);

        TextView scrollableview=(TextView)v.findViewById(R.id.scrollableview);
        Typeface typeface= Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Regular.ttf");
        scrollableview.setTypeface(typeface);
        //collapsingToolbar = (CollapsingToolbarLayout) v.findViewById(R.id.collapsing_toolbar);
        //collapsingToolbar.setTitle("Ghanerao");
        return v;
    }
}
