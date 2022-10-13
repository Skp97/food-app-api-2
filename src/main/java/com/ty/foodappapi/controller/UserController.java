package com.ty.foodappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappapi.dto.User;
import com.ty.foodappapi.dto.UserLogin;
import com.ty.foodappapi.service.UserService;
import com.ty.foodappapi.util.ResponseStructure;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> getUser(@PathVariable int id ){
		return userService.getUser(id);
	}
	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<User>> getUsers(){
		return userService.getUsers();
	}
	@PostMapping("/users/login")
	public ResponseEntity<ResponseStructure<User>> validateUser(@RequestBody UserLogin login){
		return userService.validateUser(login);
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> validateUser(@PathVariable int id,@RequestBody User user){
		return userService.updateUser(id,user);
	}
	
}
