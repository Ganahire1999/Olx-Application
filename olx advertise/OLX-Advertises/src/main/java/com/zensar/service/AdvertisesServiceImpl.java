package com.zensar.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.controller.MasterdataFeignClient;
import com.zensar.controller.UserFeignClient;
import com.zensar.model.Advertises;
import com.zensar.model.Advertises2;
import com.zensar.repo.AdvertisesRepo;

@Service
public class AdvertisesServiceImpl implements AdvertisesService
{
	@Autowired
	AdvertisesRepo ar;

	@Autowired
	UserFeignClient uf;

	@Autowired
	MasterdataFeignClient mf;
	String u1  ="userName";
	//8
	@Override
	@Transactional
	public Advertises postAdv1(AdvertiseDetail ad, String token) throws JsonProcessingException 
	{
		int d =ad.getCategoryId();

		boolean validation = uf.validateToken(token);
		if(validation) 
		{

			String user = uf.getUser(token);
			Map<String, String> mapping = new ObjectMapper().readValue(user, HashMap.class);
			String username = mapping.get(u1);

			String name = mapping.get("firstName")+" "+mapping.get("lastName");

			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis); 

			Advertises a1 = new Advertises(0,ad.getTitle() ,d, 1, ad.getPrice(), ad.getDescription(),
					date, date, "1", name, username);
			ar.save(a1);
			a1.setCategory1(mf.getCategory(a1.getCategory()));
			a1.setStatus1(mf.getStatusid(a1.getStatus()));
			return a1;
		}else {

			return null;
		}
	}

	//9
	@Override
	@Transactional
	public Advertises updateAdv1(AdvertiseDetail ad, String token,int id) 
	{
		boolean val = uf.validateToken(token);
		if(val)
		{
			Advertises a = ar.findById(id).orElse(null);
			if(a!=null)
			{
				a.setTitle(ad.getTitle());
				a.setPrice(ad.getPrice());
				a.setCategory(ad.getCategoryId());
				a.setStatus(ad.getStatusId());
				a.setDescription(ad.getDescription());
				long millis=System.currentTimeMillis();  
				java.sql.Date date=new java.sql.Date(millis); 
				a.setModified_date(date);
				if(a.getStatus()==2) {
					a.setActive("0");
				}
				ar.save(a);
				a.setCategory1(mf.getCategory(a.getCategory()));
				a.setStatus1(mf.getStatusid(a.getStatus()));
				return a;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	//15
	@Override
	public Advertises2 getAdvertise(int id, String token) 
	{
		boolean val = uf.validateToken(token);
		if(val) 
		{
			Advertises a = ar.findById(id).orElse(null);
			if(a!=null) 
			{
				a.setCategory1(mf.getCategory(a.getCategory()));
				a.setStatus1(mf.getStatusid(a.getStatus()));
				return new Advertises2(a.getId(), a.getTitle(), a.getCategory1(), a.getStatus1(),
						a.getPrice(), a.getDescription(), a.getCreated_date(), a.getModified_date(), a.getPosted_by());
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	//11
	@Override
	public Advertises getAdvertiseByUser(int advertiseid, String token) throws JsonProcessingException 
	{
		boolean val = uf.validateToken(token);
		if(val) 
		{
			Advertises a = null;
			List<Advertises> list =  getAdvertiseList(token);
			for(Advertises u : list) {
				if(u.getId()==advertiseid) {
					a =u;
					break;
				}
			}
			a.setCategory1(mf.getCategory(a.getCategory()));
			a.setStatus1(mf.getStatusid(a.getStatus()));
			return a;
		}else {
			return null;
		}
	}

	//10
	@Override
	public List<Advertises> getAdvertiseList(String token) throws JsonProcessingException 
	{
		boolean val = uf.validateToken(token);
		String user = uf.getUser(token);
		Map<String, String> mapping = new ObjectMapper().readValue(user, HashMap.class);
		String username = mapping.get(u1);
		if(val) 
		{
			List<Advertises> list = ar.findByUsername(username);
			for(Advertises u : list) {
				u.setCategory1(mf.getCategory(u.getCategory()));
				u.setStatus1(mf.getStatusid(u.getStatus()));
			}
			return list;
		}else {
			return Collections.emptyList();
		}
	}

	//12
	@Override
	@Transactional
	public boolean delAdvertiseByUser(int advertiseid, String token) throws JsonMappingException, JsonProcessingException 
	{
		boolean val = uf.validateToken(token);
		String user = uf.getUser(token);
		Map<String, String> mapping = new ObjectMapper().readValue(user, HashMap.class);
		String username = mapping.get(u1);
		if(val) 
		{
			boolean t = false;
			List<Advertises> list = ar.findByUsername(username);
			for(Advertises u : list) {
				if(u.getId()==advertiseid) {
					ar.delete(u);
					t=true;
					break;
				}
			}
			return t;
		}else {
			return false;
		}
	}

	//13
	@Override
	public List<Advertises> findByCategory(String category) 
	{
		int id = mf.getCatName(category);
		List<Advertises> list = ar.findByCategory(id);
		for(Advertises u : list) {
			u.setCategory1(mf.getCategory(u.getCategory()));
			u.setStatus1(mf.getStatusid(u.getStatus()));
		}
		return list;
	}
	
	//13 & 14
	@Override
	public List<Advertises> findByText(String searchText) 
	{
		List<Advertises> list1 = new ArrayList<>();
		List<Advertises> list = ar.findAll();
		for(Advertises u :list) {
			String a = u.toString();
			if(a.contains(searchText)) {
				u.setCategory1(mf.getCategory(u.getCategory()));
				u.setStatus1(mf.getStatusid(u.getStatus()));
				list1.add(u);
			}
		}
		return list1;
	}

	@Override
	public List<Advertises> findByPostedBy(String postedBy)
	{
		List<Advertises> list1 = new ArrayList<>();
		List<Advertises> list = ar.findAll();
		for(Advertises u :list) {
			String a = u.toString();
			if(a.contains(postedBy)) {
				u.setCategory1(mf.getCategory(u.getCategory()));
				u.setStatus1(mf.getStatusid(u.getStatus()));
				list1.add(u);
			}
		}
		return list1;
	}
	
	//13
	@Override
	public List<Advertises> sortby(String sortBy) 
	{
		List<Advertises> list = ar.findAll();
		for(Advertises u : list) {
			u.setCategory1(mf.getCategory(u.getCategory()));
			u.setStatus1(mf.getStatusid(u.getStatus()));
		}
		if(sortBy.equals("id")) {
			Collections.sort(list, (o1, o2)->o1.getId()-o2.getId());
			return list;
		}else if(sortBy.equals("title")){
			Collections.sort(list, (o1, o2)->o1.getTitle().compareTo(o2.getTitle()));
			return list;
		}else if(sortBy.equals("category")){
			Collections.sort(list, (o1, o2)->o1.getCategory()-o2.getCategory());
			return list;
		}else if(sortBy.equals("status")){
			Collections.sort(list, (o1, o2)->o1.getStatus()-o2.getStatus());
			return list;
		}else if(sortBy.equals("price")){
			Collections.sort(list, (o1, o2)->Double.compare(o1.getPrice(),o2.getPrice()));
			return list;
		}else if(sortBy.equals("description")){
			Collections.sort(list, (o1, o2)->o1.getDescription().compareTo(o2.getDescription()));
			return list;
		}else if(sortBy.equals("cdate")){
			Collections.sort(list, (o1, o2)->o1.getCreated_date().compareTo(o2.getCreated_date()));
			return list;
		}else if(sortBy.equals("mdate")){
			Collections.sort(list, (o1, o2)->o1.getModified_date().compareTo(o2.getModified_date()));
			return list;
		}else if(sortBy.equals("active")){
			Collections.sort(list, (o1, o2)->o1.getActive().compareTo(o2.getActive()));
			return list;
		}else if(sortBy.equals("postedby")){
			Collections.sort(list, (o1, o2)->o1.getPosted_by().compareTo(o2.getPosted_by()));
			return list;
		}else if(sortBy.equals("username")){
			Collections.sort(list, (o1, o2)->o1.getUsername().compareTo(o2.getUsername()));
			return list;
		}else {
			return Collections.emptyList();
		}
	}

	@Override
	public List<Advertises> datec(String dateCondition,String onDate,String fromDate, String toDate) 
	{
		List<Advertises> list1 = new ArrayList<>();
		List<Advertises> list = ar.findAll();
		for(Advertises u : list) {
			u.setCategory1(mf.getCategory(u.getCategory()));
			u.setStatus1(mf.getStatusid(u.getStatus()));
		}
		if(dateCondition.equals("equals")){
			Date d = Date.valueOf(onDate);
			for(Advertises u :list) {
				if(u.getCreated_date().compareTo(d)==0) {
					list1.add(u);
				}
			}
		}else if(dateCondition.equals("greaterthan")) {
			Date d1 = Date.valueOf(fromDate);
			for(Advertises u :list) {
				if(u.getCreated_date().compareTo(d1)>0) {
					list1.add(u);
				}
			}
		}else if(dateCondition.equals("lessthan")) {
			Date d2 = Date.valueOf(fromDate);
			for(Advertises u :list) {
				if(u.getCreated_date().compareTo(d2)<0) {
					list1.add(u);
				}
			}
		}else if(dateCondition.equals("between")) {
			Date d3 = Date.valueOf(fromDate);
			Date d4 = Date.valueOf(toDate);
			for(Advertises u :list) {
				if(0<=u.getCreated_date().compareTo(d3) && u.getCreated_date().compareTo(d4)<=0 ) {
					list1.add(u);
				}
			}
		}			
		return list1;
	}
}