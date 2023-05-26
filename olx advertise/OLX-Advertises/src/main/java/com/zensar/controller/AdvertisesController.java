package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.zensar.model.Advertises;
import com.zensar.model.Advertises2;
import com.zensar.service.AdvertiseDetail;
import com.zensar.service.AdvertisesService;

@RestController
public class AdvertisesController 
{
	@Autowired
	AdvertisesService as;

	//8
	@PostMapping(path="/advertise",consumes="application/json")
	public Advertises postAdv(@RequestBody AdvertiseDetail ad,@RequestHeader("Authorization") String token) throws JsonMappingException, JsonProcessingException {
		Advertises a1 = as.postAdv1(ad,token);
		return a1;

	}
	//9
	@PutMapping(path="/advertise/{id}",consumes="application/json")
	public Advertises updateAdv(@PathVariable("id") int id,@RequestHeader("Authorization") String token,
			@RequestBody AdvertiseDetail ad) {
		Advertises a1 = as.updateAdv1(ad, token,id);
		return a1;
	}


	//10
	@GetMapping("/user/advertise")
	public List<Advertises> getAdvList(@RequestHeader("Authorization") String token) throws JsonMappingException, JsonProcessingException {
		List<Advertises> a1 =as.getAdvertiseList(token);
		return a1;
	}


	//11
	@GetMapping("/user/advertise/{advertiseid}")
	public Advertises getAdvUser(@PathVariable("advertiseid") int advertiseid,@RequestHeader("Authorization") String token) throws JsonMappingException, JsonProcessingException {
		Advertises a1 =as.getAdvertiseByUser(advertiseid,token);
		return a1;
	}

	//12
	@DeleteMapping("/user/advertise/{advertiseid}")
	public boolean delAdvUser(@PathVariable("advertiseid") int advertiseid,@RequestHeader("Authorization") String token) throws JsonMappingException, JsonProcessingException{
		boolean a1 =as.delAdvertiseByUser(advertiseid,token);
		return a1;
	}

	//13
	@GetMapping("/advertise/search/filtercriteria")
	public List<Advertises> getAllMatchingAdvertises(
			@RequestParam(name="searchText",required=false) String searchText,
			@RequestParam(name="category",required=false) String category,
			@RequestParam(name="postedBy",required=false) String postedBy,
			@RequestParam(name="dateCondition",required=false) String dateCondition,
			@RequestParam(name="onDate",required=false) String onDate,
			@RequestParam(name="fromDate",required=false) String fromDate,
			@RequestParam(name="toDate",required=false) String toDate,
			@RequestParam(name="sortBy",required=false) String sortBy,
			@RequestParam(name="startIndex",required=false) String startIndex,
			@RequestParam(name="records",required=false) String records
			){
		if(category != null) {
			List<Advertises> list = as.findByCategory(category);
			return list;
		}else if(searchText!= null) {
			List<Advertises> list = as.findByText(searchText);
			return list;
		}else if(postedBy != null) {
			List<Advertises> list = as.findByPostedBy(postedBy);
			return list;
		}else if(dateCondition!=null) {
			List<Advertises> list = as.datec(dateCondition,onDate,fromDate,toDate);
			return list;
		}else if(sortBy!=null) {
			List<Advertises> list = as.sortby(sortBy);
			return list;
		}else if(startIndex!=null) {

		}else if(records!=null) {

		}else {
			return null;
		}
		//		System.out.println("Ram Ram");
		return null;
	}

	//14
	@GetMapping("/advertise/search")
	public List<Advertises> getByText(@RequestParam("searchText") String searchText){
		List<Advertises> list = as.findByText(searchText);
		return list;

	}
	//15
	@GetMapping("/advertise/{advertiseid}")
	public Advertises2 getAdv(@PathVariable("advertiseid") int advertiseid,@RequestHeader("Authorization") String token) {
		Advertises2 a1 =as.getAdvertise(advertiseid,token);
		return a1;
	}
	
	@GetMapping("/info")
	public String getInfo()
	{
		return "Advertise app is running";
	}

}
