
package com.zensar.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.service.AdvertisesService;

@RestController
public class AdvertisesController
{
	private static final Logger log = LoggerFactory.getLogger(AdvertisesController.class);

	@Autowired
	AdvertisesService service;
	@DeleteMapping("/user/advertise/{advertiseId}")
	Boolean deleteSpedfiedAdv(@RequestHeader("Authorization") String authToken,
			@RequestParam(name="datcondition", required = false) String datecondition,
			@RequestParam(name = "onDate", required = false) String onDate,
			@RequestParam(name = "fromDate", required = false) String fromDate,
			@RequestParam(name = "toDate", required = false) String toDate
			) throws ParseException
	{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		Date toDatedt = sf.parse(toDate);

		boolean done = false;
		switch(datecondition)
		{
		case "equals":
			log.info("equals date condition");
			done = service.deleteAdvOnDate(authToken, onDate);
			break;
		case "greatethan":
			log.info("equals date condition");
			done = service.deleteAdvFromDate(authToken, fromDate);
			break;
		case "lessthan":
			log.info("equals date condition");
			done = service.deleteAdvLessThan(authToken, fromDate);
			break;
		case "between":
			log.info("equals date condition");
			done = service.deleteAdvBetween(authToken, fromDate, toDate);
			break;


		}
		return done;
		/*
		 * datcondition=equals&onDate=2021-10-17
datcondition=greatethan&fromDate=2021-11-08
datcondition=lessthan&fromDate=2021-11-08
datcondition=between&fromDate=2021-10-17&toDate=2021-11-08

		 */


	}
	@DeleteMapping("/user/advertise/{advertiseId}")
	Boolean deleteSpedfiedAdv2(@RequestHeader("Authorization") String authToken,
			HttpServletRequest request	)
	{
		String datecondition = request.getParameter("datcondition");
		boolean done = false;
		switch(datecondition)
		{
		case "equals":
			log.info("equals date condition");
			String onDate = request.getParameter("onDate");
			done = service.deleteAdvOnDate(authToken, onDate);
			break;
		case "greatethan":
			log.info("equals date condition");
			String fromDate = request.getParameter("fromDate");
			done = service.deleteAdvFromDate(authToken, fromDate);
			break;
		case "lessthan":
			log.info("equals date condition");
			String fromDate2 = request.getParameter("fromDate");
			done = service.deleteAdvLessThan(authToken, fromDate2);
			break;
		case "between":
			log.info("equals date condition");
			String fromDate3 = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			done = service.deleteAdvBetween(authToken, fromDate3, toDate);
			break;


		}
		return done;

	}
}