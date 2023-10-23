package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repo;

	@Override
	public User createUsuario(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> getAllUsuarios() {
		return (List<User>) repo.findAll();
	}

	@Override
	public User getUsuarioById(Long usuarioId) {
		Optional<User> usr = repo.findById(usuarioId);
		return usr.get();
	}

	@Override
	public void deleteUsuario(Long usuarioId) {
		repo.deleteById(usuarioId);
	}

	@Override
	public User updateUser(User usuarios) {
		User existingUser = repo.findById(usuarios.getId()).get();
		existingUser.setNombre(usuarios.getNombre());
		existingUser.setEmail(usuarios.getEmail());
		User updatedUser = repo.save(existingUser);
		return updatedUser;
	}

}
