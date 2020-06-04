package com.recordcard.customermanagementapi.configuration;

import java.util.ArrayList;


import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.recordcard.customermanagementapi.model.MyUser;
import com.recordcard.customermanagementapi.model.Privilege;
import com.recordcard.customermanagementapi.model.Role;
import com.recordcard.customermanagementapi.repository.MyUserRepository;

//import com.recordcard.customermanagementapi.service.IUserService;


@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MyUserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser user = userRepository.findByUserName(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not Found!");
			
//			return new User(" ", " ", true, true, true, true,
//					getAuthorities(Arrays.asList(
//							roleRepository.findByName("ROLE_USER"))));
		}
				
				
		return new User(user.getEmail(), user.getUserPassword(), user.isEnabled(), true, true, true, getAuthorities(user.getRole()));
	}
	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles){
		
		return GetGrantedAuthorities(getPrivileges(roles));
	}

	private Collection<? extends GrantedAuthority> GetGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		
		return authorities;
	}
	private List<String> getPrivileges (List<Role> roles) {
		
		List<String> privileges = new ArrayList<String>();
		List<Privilege> collection = new ArrayList<>();
		
		for (Role role : roles ) {
			collection.addAll(role.getPrivileges());
		}
		for (Privilege item : collection) {
			privileges.add(item.getName());
		}
		
		return privileges;
	}

	

}
