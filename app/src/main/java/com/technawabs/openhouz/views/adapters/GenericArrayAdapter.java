package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.technawabs.openhouz.R;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayAdapter<T> extends ArrayAdapter<T> {

    private List<T> list;

    public GenericArrayAdapter(Context context, ArrayList<T> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.room_detail_card, parent, false);
            }
        }
        return convertView;
    }

}
