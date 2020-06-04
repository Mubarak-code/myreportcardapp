package com.recordcard.customermanagementapi.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "grade_class")
public class GradeClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grade_class_id")
	private Long id;
	@Column(name = "grade_class_name", nullable = false)
	@NotBlank
	private String gradeClassName;
	@Column(nullable = false)
	@NotBlank
	private String description;
	@OneToMany(mappedBy = "grade")
	private List<Student> students;
	
	
	public GradeClass() {}


	public GradeClass(@NotBlank String gradeClassName, @NotBlank String description) {
		super();
		this.gradeClassName = gradeClassName;
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getGradeClassName() {
		return gradeClassName;
	}


	public void setGradeClassName(String gradeClassName) {
		this.gradeClassName = gradeClassName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "GradeClass [gradeId=" + id + ", gradeClassName=" + gradeClassName + ", description=" + description
				+ ", students=" + students + "]";
	}
	
	

}
