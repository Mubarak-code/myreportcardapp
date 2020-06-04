package com.recordcard.customermanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recordcard.customermanagementapi.model.GradeClass;

@Repository
public interface GradeClassRepository extends JpaRepository<GradeClass, Long> {

}
