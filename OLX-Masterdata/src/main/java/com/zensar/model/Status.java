package com.zensar.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adv_status")
public class Status
{
	@Id
	private int id;
	private String status;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	@Override
	public String toString()
	{
		return "Status [id=" + id + ", status=" + status + "]";
	}
}