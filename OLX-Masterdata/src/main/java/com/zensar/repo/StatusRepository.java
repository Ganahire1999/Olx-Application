package com.zensar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>
{

}
