package com.recordcard.customermanagementapi.service;

import org.springframework.stereotype.Service;


import com.recordcard.customermanagementapi.model.MyUser;


@Service
public interface IUserService {
	
	void registerNewUserAccount (MyUser user) ;

}
