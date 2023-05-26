package com.zensar.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Advertises2 {
	private int id;
	private String title;
	@JsonIgnore
	private int category;
	private String category1;
	@JsonIgnore
	private int status;
	private String status1;
	private double price;
	private String description;
	private Date created_date;
	private Date modified_date;
	@JsonIgnore
	private String active;
	private String posted_by;
	@JsonIgnore
	private String username;

	public Advertises2(int id, String title, String category1, String status1, double price,
			String description, Date created_date, Date modified_date, String posted_by) {
		super();
		this.id = id;
		this.title = title;
		this.category1 = category1;
		this.status1 = status1;
		this.price = price;
		this.description = description;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.posted_by = posted_by;
	}


	public Advertises2() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getPosted_by() {
		return posted_by;
	}

	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getCategory1() {
		return category1;
	}


	public void setCategory1(String category1) {
		this.category1 = category1;
	}


	public String getStatus1() {
		return status1;
	}


	public void setStatus1(String status1) {
		this.status1 = status1;
	}


	@Override
	public String toString() {
		return "Advertises [id=" + id + ", title=" + title + ", category=" + category1 + ", status=" + status1
				+ ", price=" + price + ", description=" + description + ", created_date=" + created_date
				+ ", modified_date=" + modified_date + ", active=" + active + ", posted_by=" + posted_by + ", username="
				+ username + "]";
	}
}