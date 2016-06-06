package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.models.GenericArrayItem;

import java.util.List;

public class GenericArrayAdapter<T> extends ArrayAdapter<T> {

    private final int SPACE_DETAILS = 0;
    private final int BUILDING_SPECS = 1;
    private List<T> objects;

    public GenericArrayAdapter(Context context, List<T> objects) {
        super(context, 0, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView textTitle = (TextView) convertView.findViewById(R.id.item_title);
        TextView textValue = (TextView) convertView.findViewById(R.id.item_value);
        final GenericArrayItem genericArrayItem = (GenericArrayItem) objects.get(position);
        textTitle.setText(genericArrayItem.getItemTitle());
        textValue.setText(genericArrayItem.getItemValue());
        return convertView;
    }

}
