package com.recordcard.customermanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recordcard.customermanagementapi.model.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

	MyUser findByUserName(String username);

}
