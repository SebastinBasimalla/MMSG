package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.sympo.mmsg.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.PeopleInfoData;


/**
 * Created by Sebastin on 6/5/2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements View.OnClickListener{
    private ArrayList<PeopleInfoData> peopleInfo;
    private Context context;
    private OnItemClickListener listener=null;

    public DataAdapter(Context context, ArrayList<PeopleInfoData> peopleInfo, OnItemClickListener listener) {
        this.context = context;
        this. peopleInfo = peopleInfo;
        this.listener=listener;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pastcomitte_row_new, viewGroup, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.title.setText( peopleInfo.get(i).getPeopleName());
      //  viewHolder.bind(android_versions.get(i), listener,i,viewHolder);
        Picasso.with(context).load(peopleInfo.get(i).getPeopleUrl()).into(viewHolder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return  peopleInfo.size();
    }

    @Override
    public void onClick(View v) {
      //  Toast.makeText(v.getContext(), "position = "+v.getId() , Toast.LENGTH_SHORT).show();
        v.getRootView();

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView thumbnail;
        public ViewHolder(View view) {
            super(view);

            title = (TextView)view.findViewById(R.id.title);
            thumbnail = (ImageView)view.findViewById(R.id.thumbnail);
        }


    }




}
