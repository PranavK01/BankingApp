package com.wipro.PR377825.springboot.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.repository.CustomerRepo;

@Service
public class ProfileService 
{
	@Autowired
	CustomerRepo custRepo;

//	getProfileByPhone method for Rest API to be tested from Postman
	
	public String[] getProfileByPhone(String phone) throws EntityNotFoundException
	{
		
		String fname = custRepo.findByPhone(phone).getFirstName();
		String lname = custRepo.findByPhone(phone).getLastName();
		String Phone = custRepo.findByPhone(phone).getPhone();
		String email = custRepo.findByPhone(phone).getEmail();

		String details[] = {fname, lname, Phone, email};
		
		return details;
	}
	
//	updateProfileById method for Rest API to be tested from Postman
	public Customer updateProfileById(String ID, Customer obj)
	{
		Optional<Customer> userId = custRepo.findById(ID);
		if (userId.isPresent())
		{
			obj.setUserId(ID);
			return custRepo.save(obj);
		}
		return null;
	}
	

//	non Rest API methods
	
	public String[] getProfileDetails(String ID) throws EntityNotFoundException
	{
		String fname = custRepo.getOne(ID).getFirstName();
		String lname = custRepo.getOne(ID).getLastName();
		String phone = custRepo.getOne(ID).getPhone();
		String email = custRepo.getOne(ID).getEmail();

		String detail[] = {fname, lname, phone, email};
		return detail;
	}

	public String saveDetail(String ID, String field, String res) throws EntityNotFoundException
	{
		if (field.equals("FirstName"))
		{
			Customer obj = custRepo.findById(ID).get();
			obj.setFirstName(res);
			custRepo.save(obj);
		}
		else if (field.equals("LastName"))
		{
			Customer obj = custRepo.findById(ID).get();
			obj.setLastName(res);
			custRepo.save(obj);
		}
		else if (field.equals("Email"))
		{
			Customer obj = custRepo.findById(ID).get();
			obj.setEmail(res);
			custRepo.save(obj);
		}
		else
		{
			Customer obj = custRepo.findById(ID).get();
			obj.setPhone(res);
			custRepo.save(obj);
		}
		
		String name = custRepo.getOne(ID).getFirstName() + " " + custRepo.getOne(ID).getLastName();
		return name;
	}
}