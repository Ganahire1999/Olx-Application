package com.zensar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>
{

}