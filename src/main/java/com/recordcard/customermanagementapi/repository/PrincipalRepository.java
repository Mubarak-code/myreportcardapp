package com.recordcard.customermanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recordcard.customermanagementapi.model.Principal;

@Repository
public interface PrincipalRepository extends JpaRepository<Principal, Long> {

}
