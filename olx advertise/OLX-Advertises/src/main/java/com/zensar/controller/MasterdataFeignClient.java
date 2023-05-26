package com.zensar.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="OLX-MASTERDATA")
public interface MasterdataFeignClient {

	@GetMapping(path="/advertise/status")
	public String getStatus();

	@GetMapping(path="/advertise/category/{category}")
	public int getCatName(@PathVariable("category") String category);

	@GetMapping(path="/advertise/getcategory/{id}")
	public String getCategory(@PathVariable("id") int id);

	@GetMapping(path="/advertise/getstatus/{id}")
	public String getStatusid(@PathVariable("id") int id);
}
