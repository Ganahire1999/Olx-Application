package com.zensar.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.zensar.model.Advertises;
import com.zensar.model.Advertises2;

public interface AdvertisesService 
{
	Advertises postAdv1(AdvertiseDetail advdetail,String token) throws JsonMappingException, JsonProcessingException;
	Advertises updateAdv1(AdvertiseDetail ad,String token,int id);
	Advertises2 getAdvertise(int id, String token);
	Advertises getAdvertiseByUser(int advertiseid, String token) throws JsonMappingException, JsonProcessingException;
	List<Advertises> getAdvertiseList(String token) throws JsonMappingException, JsonProcessingException;
	
	boolean delAdvertiseByUser(int advertiseid, String token) throws JsonMappingException, JsonProcessingException;
	List<Advertises> findByCategory(String category);
	List<Advertises> findByText(String searchText);
	List<Advertises> findByPostedBy(String postedBy);
	List<Advertises> sortby(String sortBy);
	List<Advertises> datec(String dateCondition, String onDate, String fromDate, String toDate);
}
