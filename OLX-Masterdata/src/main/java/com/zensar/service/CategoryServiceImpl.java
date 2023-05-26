package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Categories;
import com.zensar.repo.CategoriesRepository;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	CategoriesRepository catRepo;

	@Override
	public List<Categories> getCategories()
	{
		return catRepo.findAll();
	}

}