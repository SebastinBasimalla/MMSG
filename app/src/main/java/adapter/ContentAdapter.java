package adapter;

/**
 * Created by Sebastin on 6/5/2016.
 */

import java.util.List;

import model.AndroidVersion;




public class ContentAdapter {

    private final List<AndroidVersion> items;
    private final OnItemClickListener listener;

    public ContentAdapter(List<AndroidVersion> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }
}
