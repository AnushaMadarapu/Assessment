package com.example.assessment.repository;

import com.example.assessment.model.UserDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository 
			extends CrudRepository<UserDetails, Long> {

}
