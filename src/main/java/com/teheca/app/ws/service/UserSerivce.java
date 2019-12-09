package com.teheca.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.teheca.app.ws.ui.shared.dto.UserDto;

public interface UserSerivce extends UserDetailsService {
	UserDto createUser(UserDto user);

}
