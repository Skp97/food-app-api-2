package com.ty.foodappapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappapi.dto.User;
import com.ty.foodappapi.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			User user1 = optional.get();
			return user1;
		} else
			return null;
	}

	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

	public User validateUser(String email,String password) {
			return userRepository.findByEmailAndPassword(email,password) ;
	}
	public Optional updateUserById(int id) {
		
		return userRepository.findById(id);
		
	}

}
