package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.sympo.mmsg.R;

import java.util.ArrayList;

import model.PeopleInfoData;

/**
 * Created by Sebastin on 7/22/2016.
 */
public class CurrentComitteAdapter extends RecyclerView.Adapter<CurrentComitteAdapter.ViewHolder> implements View.OnClickListener {
    private ArrayList<PeopleInfoData> android_versions;
    private Context context;
    private OnItemClickListener listener=null;

    public CurrentComitteAdapter(Context context, ArrayList<PeopleInfoData> android_versions, OnItemClickListener listener) {
        this.context = context;
        this.android_versions = android_versions;
        this.listener=listener;
    }

    @Override
    public CurrentComitteAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(android_versions.get(i).getPeopleName());
        //  viewHolder.bind(android_versions.get(i), listener,i,viewHolder);
        //  Picasso.with(context).load(android_versions.get(i).getPeopleUrl()).resize(120, 60).into(viewHolder.img_android);

    }

    @Override
    public int getItemCount() {
        return android_versions.size();
    }

    @Override
    public void onClick(View v) {
        //  Toast.makeText(v.getContext(), "position = "+v.getId() , Toast.LENGTH_SHORT).show();
        v.getRootView();

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_android;
        ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView)view.findViewById(R.id.img_android);
        }


    }




}
