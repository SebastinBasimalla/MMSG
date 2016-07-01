package com.company.sympo.mmsg;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 04-06-2015.
 */
public class current_comitte_fragment extends Fragment {

    AssetManager am;
    Typeface typeface;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.currentcomitteelayout,container,false);
     /*   TextView home_fragment_sampletext= (TextView) view.findViewById(R.id.home_fragment_sampletext);
        am = getActivity().getApplicationContext().getAssets();
        typeface= Typeface.createFromAsset(getActivity().getAssets(), "cambria.ttc");
        home_fragment_sampletext.setTypeface(typeface);*/

        return view;
    }
}
