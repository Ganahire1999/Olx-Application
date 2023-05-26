package com.zensar.service;

public class AdvertiseDetail
{
	String title;
	double price;
	int categoryId;
	int statusId;
	String description;

	public AdvertiseDetail(String title, double price, int categoryId, int statusId, String description) 
	{
		super();
		this.title = title;
		this.price = price;
		this.categoryId = categoryId;
		this.statusId = statusId;
		this.description = description;
	}
	public AdvertiseDetail(String title, double price, int categoryId, String description) 
	{
		super();
		this.title = title;
		this.price = price;
		this.categoryId = categoryId;
		this.description = description;
	}
	public AdvertiseDetail() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public double getPrice() {
		return price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public String getDescription() {
		return description;
	}
	public int getStatusId() {
		return statusId;
	}	
}