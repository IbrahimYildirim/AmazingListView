package com.example.ultraamazinglistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<ListCell> {

	LayoutInflater inflater;
	public ListAdapter(Context context, ArrayList<ListCell> items) {
		super(context, 0, items);
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		ListCell cell = getItem(position);
		
		//If the cell is a section header we inflate the header layout 
		if(cell.isSectionHeader())
		{
			v = inflater.inflate(R.layout.section_header, null);
			
			v.setClickable(false);
			
			TextView header = (TextView) v.findViewById(R.id.section_header);
			header.setText(cell.getName());
		}
		else
		{
			v = inflater.inflate(R.layout.list_item, null);
			TextView name = (TextView) v.findViewById(R.id.name);
			TextView category = (TextView) v.findViewById(R.id.category);
			
			name.setText(cell.getName());
			category.setText(cell.getCategory());
			
		}
		return v;
	}
}
