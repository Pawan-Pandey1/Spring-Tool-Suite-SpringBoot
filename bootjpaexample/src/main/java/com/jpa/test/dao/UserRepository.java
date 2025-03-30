package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	//Creating Custom Finder Method 
	
	public List<User> findByName(String name);
	//Here the syntax is findBy-->It is Introducer and Name is Criteria it can be changed it is property city/status/etc.
	//Spring data JPA will automatically implement it by own no need to give body
	
	public List<User> findByNameAndCity(String name, String city);
	
	@Query("select u from User u")
	public List<User> getAllUser();
	
	//Query --.JPQL query
	@Query("select u From User u WHERE u.name =:n")
	public List<User> getUserByName(@Param("n") String name);
	//Using Param we have bind the string with n so whatever we pass in method it will be replaced and used in query
	// We can use the AND operator example u.name =:n and u.city =:c" and pass it also as Param("c")
	
	//Query-->Native Query
	
	@Query(value="select* from user",nativeQuery =true)
	public List<User> getUsers();
	
}
