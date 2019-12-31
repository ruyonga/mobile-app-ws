package com.teheca.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.teheca.app.ws.ui.shared.dto.UserDto;

public interface UserService extends UserDetailsService {
	UserDto createUser(UserDto user);
	UserDto getUser(String email);

}
