package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> listaU = service.getAllUsuarios();
		return new ResponseEntity<>(listaU, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> createUsers(@RequestBody User user) {
		User findedUser = service.createUsuario(user);
		return new ResponseEntity<>(findedUser, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		user.setId(id);
		User updatedUser = service.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		service.deleteUsuario(id);
		return new ResponseEntity<>("Usuario Eliminado Con Id" + id , HttpStatus.OK);
	}

}
