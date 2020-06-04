package com.recordcard.customermanagementapi.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class GradeSubject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grade_subject_id")
	private Long gradeSubjectId;
	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
	private Subject subject;
	@ManyToOne
	@JoinColumn(name = "grade_class")
	private GradeClass gradeClass;
	
	public GradeSubject() {}

	public Long getGradeSubjectId() {
		return gradeSubjectId;
	}

	public void setGradeSubjectId(Long gradeSubjectId) {
		this.gradeSubjectId = gradeSubjectId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public GradeClass getGradeClass() {
		return gradeClass;
	}

	public void setGradeClass(GradeClass gradeClass) {
		this.gradeClass = gradeClass;
	}

	@Override
	public String toString() {
		return "GradeSubject [gradeSubjectId=" + gradeSubjectId + ", subject=" + subject + ", gradeClass=" + gradeClass
				+ "]";
	}

	
}
