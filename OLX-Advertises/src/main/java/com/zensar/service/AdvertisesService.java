package com.zensar.service;

public interface AdvertisesService
{

	boolean deleteAdvOnDate(String authToken, String onDate);

	boolean deleteAdvFromDate(String authToken, String fromDate);

	boolean deleteAdvLessThan(String authToken, String fromDate);

	boolean deleteAdvBetween(String authToken, String fromDate, String toDate);

}