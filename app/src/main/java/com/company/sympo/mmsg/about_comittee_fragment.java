package com.company.sympo.mmsg;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 04-06-2015.
 */
public class about_comittee_fragment extends Fragment {

    AssetManager am;
    Typeface typeface;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.aboutcomitteelayout, container, false);

        TextView scrollableview = (TextView) view.findViewById(R.id.scrollableview);
        am = getActivity().getApplicationContext().getAssets();
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");
        scrollableview.setTypeface(typeface);

        return view;
    }
}
