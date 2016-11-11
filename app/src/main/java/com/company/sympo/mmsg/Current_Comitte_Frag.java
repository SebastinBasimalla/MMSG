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

import adapter.DataAdapter;
import adapter.OnItemClickListener;
import adapter.RecyclerItemClickListener;
import model.PeopleInfoData;

/**
 * Created by Sebastin on 7/22/2016.
 */
public class Current_Comitte_Frag extends Fragment implements View.OnClickListener {

      private final String name_people[] = {
            "Shree Kanakrajji Lodha",
            "Shree Sureshji Punmiya",
            "Shree Nirmalji Hingad",
            "Shree Rajubhai Khichiya",
            "Shree Arvindji Kothari",
            "Shree Prakashji Lodha",
            "Shree Devendraji",
            "Shree Rajendraji Khich",
            "Shree Rajendraji Khich",
            "Shree Rajendraji Khich"
    };
    private final Integer peopleImages[] = {
            R.drawable.imageone,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle

    };
    private final Integer peopleImageLarge[] = {
            R.drawable.imageonelarge,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle,
            R.drawable.ic_action_account_circle

    };
    AssetManager am;
    Typeface typeface;
    View view;
    RecyclerView recyclerView;
    ArrayList androidVersions;

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
    ArrayList peopleData;
    private OnItemClickListener listener;

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

    private void initViews(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.current_comittee_farg_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        peopleData = prepareData();
        DataAdapter adapter = new DataAdapter(getActivity(), peopleData, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(this);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        //           Toast.makeText(getActivity(), "Poistion is " + peopleData.get(position), Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(getActivity(), Current_comitte_detail.class);
                        intent.putExtra("Name", ((PeopleInfoData) peopleData.get(position)).getPeopleName());
                        intent.putExtra("LargeImageUrl", String.valueOf(((PeopleInfoData) peopleData.get(position)).getPeopleLargeURL()));
                        startActivity(intent);


                        ;


                    }
                })
        );


    }

    private ArrayList prepareData() {

        ArrayList peopleData = new ArrayList<>();
        for (int i = 0; i < name_people.length; i++) {
            PeopleInfoData peopleInfo = new PeopleInfoData();
            peopleInfo.setPeopleName(name_people[i]);
            peopleInfo.setPeopleUrl(peopleImages[i]);
            peopleInfo.setPeopleLargeURL(peopleImageLarge[i]);
            peopleData.add(peopleInfo);
        }
        return peopleData;
    }


    public void onItemClick(View v, int position) {


    }


    @Override
    public void onClick(View v) {
        int itemPosition = recyclerView.getChildLayoutPosition(view);
        // String item = peopleData.get(itemPosition);
        Toast.makeText(getActivity(), "Clikc Item is " + itemPosition, Toast.LENGTH_LONG).show();
    }

}
