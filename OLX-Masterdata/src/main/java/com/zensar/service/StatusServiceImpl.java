package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Status;
import com.zensar.repo.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService
{
	@Autowired
	StatusRepository catRepo;

	@Override
	public List<Status> getStatusValues()
	{
		return catRepo.findAll();
	}

}