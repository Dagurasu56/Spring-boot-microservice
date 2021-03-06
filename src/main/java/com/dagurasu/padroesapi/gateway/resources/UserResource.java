package com.dagurasu.padroesapi.gateway.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dagurasu.padroesapi.entity.UserEntity;
import com.dagurasu.padroesapi.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping("/api/users/")
	public ResponseEntity findUsers() {

		UserEntity user = new UserEntity();
		user.setId(1L);
		user.setName("Douglas");

		List<UserEntity> users = new ArrayList<UserEntity>();
		users.add(user);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/api/users/")
	public ResponseEntity createUser(@RequestBody UserEntity user) {
		System.out.println("Hello " + user.getName());

		service.createUser(user);

		return new ResponseEntity<UserEntity>(user, HttpStatus.CREATED);
	}

	@PutMapping("/api/users/{id}")
	public ResponseEntity updateUser(@RequestBody UserEntity user, @PathVariable("id") String id) {
		System.out.println("The user with the id " + user.getId() + " will be changed to: " + user.getName());

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@DeleteMapping("/api/users/{id}")
	public ResponseEntity deleteUser(@RequestBody UserEntity user, @PathVariable("id") String id) {
		System.out.println("The user with the id " + user.getId() + " will be deleted!");

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

}
