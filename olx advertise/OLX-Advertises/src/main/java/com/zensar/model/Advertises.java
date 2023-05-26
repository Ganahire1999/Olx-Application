package com.zensar.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Advertises {
	@SequenceGenerator(name="advidgen",allocationSize=1,initialValue=2)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="advidgen")
	private int id;
	private String title;
	@JsonIgnore
	private int category;
	@Transient
	private String category1;
	//	@OneToOne
	//	@JoinColumn(name="category",referencedColumnName ="id")
	//	private Categories category;
	@JsonIgnore
	private int status;
	@Transient
	private String status1;
	//	@OneToOne
	//	@JoinColumn(name="status",referencedColumnName ="id")
	//	private Adv_status status;
	private double price;
	private String description;
	private Date created_date;
	private Date modified_date;
	@JsonIgnore
	private String active;
	@JsonIgnore
	private String posted_by;
	private String username;

	public Advertises(int id, String title, int category, int status, double price, String description,
			Date created_date, Date modified_date, String active, String posted_by, String username) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.status = status;
		this.price = price;
		this.description = description;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.active = active;
		this.posted_by = posted_by;
		this.username = username;
	}


	public Advertises(int id, String title, int category, String category1, int status, String status1, double price,
			String description, Date created_date, Date modified_date, String active, String posted_by,
			String username) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.category1 = category1;
		this.status = status;
		this.status1 = status1;
		this.price = price;
		this.description = description;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.active = active;
		this.posted_by = posted_by;
		this.username = username;
	}


	public Advertises() {
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
		return "Advertises [id=" + id + ", title=" + title + ", category1=" + category1 + ", status=" + status1
				+ ", price=" + price + ", description=" + description + ", created_date=" + created_date
				+ ", modified_date=" + modified_date + ", active=" + active + ", posted_by=" + posted_by + ", username="
				+ username + "]";
	}
}
