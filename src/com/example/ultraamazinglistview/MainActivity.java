package com.example.ultraamazinglistview;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayList<ListCell> items = new ArrayList<ListCell>();
		
		//Add fake data to our list - notice unsorted order
		items.add(new ListCell("Apple", "Electronics"));
		items.add(new ListCell("BMW", "Cars"));
		items.add(new ListCell("Samsung", "Electronics"));
		items.add(new ListCell("Audi", "Cars"));
		items.add(new ListCell("Brazil", "Countries"));
		items.add(new ListCell("Sony", "Electronics"));
		items.add(new ListCell("Turkey", "Countries"));
		items.add(new ListCell("LG", "Electronics"));
		items.add(new ListCell("Denmark", "Countries"));
		
		ListView list = (ListView) findViewById(R.id.awesome_list);
		
		items = sortAndAddSections(items);
		
		ListAdapter adapter = new ListAdapter(this, items);
		list.setAdapter(adapter);
	}
	
	private ArrayList<ListCell> sortAndAddSections(ArrayList<ListCell> itemList)
	{
		
		ArrayList<ListCell> tempList = new ArrayList<ListCell>();
		//First we sort the array
		Collections.sort(itemList);
		
		//Loops thorugh the list and add a section before each sectioncell start
		String header = "";
		for(int i = 0; i < itemList.size(); i++)
		{
			//If it is the start of a new section we create a new listcell and add it to our array
			if(header != itemList.get(i).getCategory()){
				ListCell sectionCell = new ListCell(itemList.get(i).getCategory(), null);
				sectionCell.setToSectionHeader();
				tempList.add(sectionCell);
				header = itemList.get(i).getCategory();
			}
			tempList.add(itemList.get(i));
		}
		
		return tempList;
	}
}
