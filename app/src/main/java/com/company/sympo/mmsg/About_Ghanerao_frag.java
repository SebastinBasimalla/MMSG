package com.company.sympo.mmsg;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_Ghanerao_frag extends Fragment {
    CollapsingToolbarLayout collapsingToolbar;

    public About_Ghanerao_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        // View v = inflater.inflate(R.layout.home_content_layout,container,false);
        View v = inflater.inflate(R.layout.fragment_about__ghanerao_frag,container,false);

        TextView scrollableview=(TextView)v.findViewById(R.id.scrollableview);
        collapsingToolbar = (CollapsingToolbarLayout) v.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("About Ghanerao");
        return v;
    }

}
