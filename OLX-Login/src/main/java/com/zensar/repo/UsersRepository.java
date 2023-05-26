package com.zensar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zensar.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>
{
	@Query ("select u from Users u where u.username = :username")
	List<Users> findByUsername(String username);

}
