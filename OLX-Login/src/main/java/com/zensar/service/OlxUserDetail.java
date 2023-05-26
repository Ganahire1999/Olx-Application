package com.zensar.service;
//Not mapped to database not an entity it is there for accepting the request body

public class OlxUserDetail
{
	private String userName;
	private String password;
	public OlxUserDetail(String userName, String password)
	{
		super();
		this.userName = userName;
		this.password = password;
	}
	public OlxUserDetail()
	{
		super();
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	@Override
	public String toString()
	{
		return "OlxUserDetail [userName=" + userName + ", password=" + password + "]";
	}
}