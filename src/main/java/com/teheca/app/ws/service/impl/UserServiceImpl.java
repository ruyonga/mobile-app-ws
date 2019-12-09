package com.teheca.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teheca.app.ws.UserRepository;
import com.teheca.app.ws.io.entity.UserEntity;
import com.teheca.app.ws.service.UserSerivce;
import com.teheca.app.ws.ui.shared.Utils;
import com.teheca.app.ws.ui.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserSerivce {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		
		if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record alread exisit");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword() ));
		userEntity.setUserId(utils.generatedUserId(30));
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		UserDto returnValue = new UserDto();

		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
