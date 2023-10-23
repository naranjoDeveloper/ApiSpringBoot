package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {

	User createUsuario(User usuarios);

	List<User> getAllUsuarios();

	User getUsuarioById(Long usuarioId);

	void deleteUsuario(Long usuarioId);

	User updateUser(User usuarios);

}
