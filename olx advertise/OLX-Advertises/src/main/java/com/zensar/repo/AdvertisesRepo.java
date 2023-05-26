package com.zensar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.model.Advertises;

public interface AdvertisesRepo extends JpaRepository<Advertises, Integer> 
{
	List<Advertises> findByUsername(String username);
	List<Advertises> findByCategory(int category);
//	List<Advertises> findByposted_by(String posted_by);
}
