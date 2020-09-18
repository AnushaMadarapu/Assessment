package com.example.assessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.assessment.exception.RecordNotFoundException;
import com.example.assessment.model.UserDetails;
import com.example.assessment.repository.UserDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
	
	@Autowired
	UserDetailsRepository repository;
	
	public List<UserDetails> getAllUsers()
	{
		List<UserDetails> result = (List<UserDetails>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<UserDetails>();
		}
	}
	
	public UserDetails getUserDetailsById(Long id) throws RecordNotFoundException 
	{
		Optional<UserDetails> user = repository.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		} else {
			throw new RecordNotFoundException("No user record exist for given id");
		}
	}
	
	public UserDetails createOrUpdateUser(UserDetails entity) 
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<UserDetails> user = repository.findById(entity.getId());
			
			if(user.isPresent()) 
			{
				UserDetails newEntity = user.get();
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());
				newEntity.setAddress1(entity.getAddress1());
				newEntity.setAddress2(entity.getAddress2());
				newEntity.setCity(entity.getCity());
				newEntity.setState(entity.getState());
				newEntity.setZip(entity.getZip());
				newEntity.setCountry(entity.getCountry());
				newEntity.setDate(entity.getDate());
				

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	
}