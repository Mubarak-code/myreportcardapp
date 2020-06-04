package com.recordcard.customermanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recordcard.customermanagementapi.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
