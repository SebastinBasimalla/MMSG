package adapter;

/**
 * Created by Sebastin on 6/5/2016.
 */

import java.util.List;

import model.PeopleInfoData;




public class ContentAdapter {

    private final List<PeopleInfoData> items;
    private final OnItemClickListener listener;

    public ContentAdapter(List<PeopleInfoData> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }
}
