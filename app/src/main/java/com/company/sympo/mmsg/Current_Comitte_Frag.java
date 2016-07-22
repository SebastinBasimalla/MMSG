package com.company.sympo.mmsg;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.CurrentComitteAdapter;
import adapter.DataAdapter;
import adapter.OnItemClickListener;
import adapter.RecyclerItemClickListener;
import model.AndroidVersion;
/**
 * Created by Sebastin on 7/22/2016.
 */
public class Current_Comitte_Frag extends Fragment implements View.OnClickListener {

    AssetManager am;
    Typeface typeface;
    View view;
    private OnItemClickListener listener;
    RecyclerView recyclerView;
    ArrayList androidVersions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //view = inflater.inflate(R.layout.aboutghaneraolayout,container,false);
        view = inflater.inflate(R.layout.current_comittee_frag_layout, container, false);
     /*   TextView home_fragment_sampletext= (TextView) view.findViewById(R.id.home_fragment_sampletext);
        am = getActivity().getApplicationContext().getAssets();
        typeface= Typeface.createFromAsset(getActivity().getAssets(), "cambria.ttc");
        home_fragment_sampletext.setTypeface(typeface);*/

        initViews(view);

        return view;
    }

/*    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };*/

    private final String android_version_names[] = {
            "Shree Kanakrajji Lodha – Place",
            "Shree Kanakrajji Lodha – Place",
            "Shree Kanakrajji Lodha – Place",
            "Shree Kanakrajji Lodha – Place",
            "Shree Kanakrajji Lodha – Place",
            "Shree Kanakrajji Lodha – Place",
            "Shree Kanakrajji Lodha – Place",
            "Shree Kanakrajji Lodha – Place",
            "Shree Kanakrajji Lodha – Place",
            "Shree Kanakrajji Lodha – Place"
    };

    private final String android_image_urls[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };

    private void initViews(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.current_comittee_farg_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        androidVersions = prepareData();

        CurrentComitteAdapter adapter = new CurrentComitteAdapter(getActivity(), androidVersions, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(this);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        //  Toast.makeText(getActivity(), "Poistion is " + android_version_names[position], Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getActivity(), CurrentComitteeDetails.class);
                        intent.putExtra("TITLE", android_version_names[position]);
                        startActivity(intent);


                    }
                })
        );


    }

    private ArrayList prepareData() {

        ArrayList android_version = new ArrayList<>();
        for (int i = 0; i < android_version_names.length; i++) {
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }


    public void onItemClick(View v, int position) {


    }


    @Override
    public void onClick(View v) {
        int itemPosition = recyclerView.getChildLayoutPosition(view);
        // String item = androidVersions.get(itemPosition);
        Toast.makeText(getActivity(), "Clikc Item is " + itemPosition, Toast.LENGTH_LONG).show();
    }


}
