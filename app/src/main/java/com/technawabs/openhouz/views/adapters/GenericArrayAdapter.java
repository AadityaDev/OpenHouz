package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.models.GenericArrayItem;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayAdapter<T> extends ArrayAdapter<T> {

    private int type;
    private List<T> objects;

    public GenericArrayAdapter(Context context, List<T> objects, int type) {
        super(context, 0, objects);
        this.objects = objects;
        this.type = type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final GenericArrayItem genericArrayItem = (GenericArrayItem) objects.get(position);
        switch (type) {
            case OpenHouzConstants.APARTMENT_BUDGET:
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.apartment_type_item, parent, false);
                }
                TextView apartmentBudget = (TextView) convertView.findViewById(R.id.room_type);
                apartmentBudget.setText(genericArrayItem.getItemTitle());
                return convertView;
            case OpenHouzConstants.APARTMENT_NEIGHBOURHOODS:
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.apartment_type_item, parent, false);
                }
                TextView apartmentNeighbourhood = (TextView) convertView.findViewById(R.id.room_type);
                apartmentNeighbourhood.setText(genericArrayItem.getItemTitle());
                return convertView;
            case OpenHouzConstants.APARTMENT_TYPE:
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.apartment_type_item, parent, false);
                }
                final ToggleButton apartmentType = (ToggleButton) convertView.findViewById(R.id.room_type);
                apartmentType.setText(genericArrayItem.getItemTitle());
                apartmentType.setTextOn(genericArrayItem.getItemTitle());
                apartmentType.setTextOff(genericArrayItem.getItemTitle());
                apartmentType.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (apartmentType.isChecked() == true) {
                            genericArrayItem.setItemValue("true");
                        } else {
                            genericArrayItem.setItemValue("false");
                        }
                    }
                });
                return convertView;
            default:
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
                }
                TextView textTitle = (TextView) convertView.findViewById(R.id.item_title);
                TextView textValue = (TextView) convertView.findViewById(R.id.item_value);
                textTitle.setText(genericArrayItem.getItemTitle());
                textValue.setText(genericArrayItem.getItemValue());
                return convertView;
        }
    }

    public List<GenericArrayItem> getValues(){
        List<GenericArrayItem> list=new ArrayList<>();
        switch (type){
            case OpenHouzConstants.APARTMENT_TYPE:
                for(int i=0;i<objects.size();i++){
                    final GenericArrayItem genericArrayItem = (GenericArrayItem) objects.get(i);
                    list.add(genericArrayItem);
                }
                break;
        }
        return list;
    }

}
