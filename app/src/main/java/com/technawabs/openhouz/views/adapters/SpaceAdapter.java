package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.models.GenericArrayItem;

import java.util.ArrayList;

/**
 * Created by Myrefers on 6/7/2016.
 */
public class SpaceAdapter extends ArrayAdapter<GenericArrayItem>{
    public SpaceAdapter(Context context, ArrayList<GenericArrayItem>genericArrayItems) {
        super(context, 0,genericArrayItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final GenericArrayItem genericArrayItem = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView itemTitle = (TextView) convertView.findViewById(R.id.item_title);
        TextView itemValue = (TextView) convertView.findViewById(R.id.item_value);
        itemTitle.setText(genericArrayItem.getItemTitle());
        itemValue.setText(genericArrayItem.getItemValue());
        return convertView;
    }
}
