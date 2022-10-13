package com.ty.foodappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappapi.dao.UserDao;
import com.ty.foodappapi.dto.User;
import com.ty.foodappapi.dto.UserLogin;
import com.ty.foodappapi.exceptions.IdNotFoundException;
import com.ty.foodappapi.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		User user1=userDao.saveUser(user);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCESSFULL");
		responseStructure.setData(user1);
		return new ResponseEntity<>(responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<User>> getUser(int id){
		User user1=userDao.getUser(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCESSFULL");
		responseStructure.setData(user1);
		return new ResponseEntity<>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> getUsers(){
		List<User> users=userDao.getUsers();
		ResponseStructure<List<User>> responseStructure=new ResponseStructure<List<User>>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCESSFULL");
		responseStructure.setData(users);
		return new ResponseEntity (responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<User>> validateUser(UserLogin userLogin){
		User user=userDao.validateUser(userLogin.getEmail(),userLogin.getPassword());
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		if(user!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFUL");
			responseStructure.setData(user);
			return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Invalid Credentials");
			responseStructure.setData(user);
			return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		}
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(int id,User user){
		Optional<User>optional=userDao.updateUserById(id);
		
		if(optional.isPresent()) {
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFUL");
			User reuser=optional.get();
			reuser.setEmail(user.getEmail());
			reuser.setName(user.getName());
			responseStructure.setData(userDao.saveUser(reuser));
			return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("The asked Id "+ id +" does not exists");
		}
	}
	
}
