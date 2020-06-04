package com.recordcard.customermanagementapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.recordcard.customermanagementapi.configuration.MyUserDetailsService;
import com.recordcard.customermanagementapi.model.MyUser;
import com.recordcard.customermanagementapi.repository.MyUserRepository;
import com.recordcard.customermanagementapi.service.IUserService;

public class UserService implements IUserService {
	
	@Autowired
	private MyUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder pwd;
	
	@Override
	public void registerNewUserAccount(MyUser input) {
		
		MyUser user = new MyUser();
		
		user.setFirstName(input.getFirstName());
		user.setEmail(input.getEmail());
		user.setLastName(input.getLastName());
		user.setUserName(input.getUserName());
		user.setUserPassword(pwd.encode(input.getUserPassword()));
		
		userRepository.save(user);
		System.out.println("Persisted into the DB");
		
		
	}

}
