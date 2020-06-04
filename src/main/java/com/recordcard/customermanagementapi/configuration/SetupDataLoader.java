package com.recordcard.customermanagementapi.configuration;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.recordcard.customermanagementapi.model.Privilege;
import com.recordcard.customermanagementapi.model.Role;
import com.recordcard.customermanagementapi.model.MyUser;
import com.recordcard.customermanagementapi.repository.PrivilegeRepository;
import com.recordcard.customermanagementapi.repository.RoleRepository;
import com.recordcard.customermanagementapi.repository.MyUserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	boolean alreadySetup = false;
	
	@Autowired
	private MyUserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PrivilegeRepository privilegeRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		if(alreadySetup)
			return;
		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		
		List<Privilege> adminPrivilege = Arrays.asList(readPrivilege, writePrivilege);
		
		createRoleIfNotFound("ROLE_ADMIN", adminPrivilege);
		createRoleIfNotFound("ROLE_USER",Arrays.asList(readPrivilege));
		
		Role adminRole = roleRepository.findByName("ROLE_ADMIN");
		MyUser user = new MyUser();
		
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setUserName("mubby");
		user.setUserPassword(passwordEncoder.encode("test"));
		user.setEmail("test@test.com");
		user.setRole(Arrays.asList(adminRole));
		user.setEnabled(true);
		userRepository.save(user);
		
		alreadySetup = true;
		
	}


	private Role createRoleIfNotFound(String name, List<Privilege> privileges) {
		
		Role role = roleRepository.findByName(name);
		
		if (role == null) {
			role = new Role(name);
			role.setPrivileges(privileges);
			roleRepository.save(role);
	
		}
		
		return role;
		
	}
	
	@Transactional
	private Privilege createPrivilegeIfNotFound(String name) {
		
		Privilege privilege = privilegeRepository.findByName(name);
		
		if (privilege == null ) {
			privilege = new Privilege(name);
			privilegeRepository.save(privilege);
		}
		
		return privilege;
	}

}
