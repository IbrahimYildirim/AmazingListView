package com.example.ultraamazinglistview;

public class ListCell implements Comparable<ListCell>{

	private String name;
	private String category;
	private boolean isSectionHeader;
	
	public ListCell(String name, String category)
	{
		this.name = name;
		this.category = category;
		isSectionHeader = false;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public void setToSectionHeader()
	{
		isSectionHeader = true;
	}
	
	public boolean isSectionHeader()
	{
		return isSectionHeader;
	}
	
	@Override
	public int compareTo(ListCell other) {
		return this.category.compareTo(other.category);
	}
}
