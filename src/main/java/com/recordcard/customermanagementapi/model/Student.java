package com.recordcard.customermanagementapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private Long studentId;
	@Column(name = "first_name", nullable = false)
	@NotBlank
	private String firsttName;
	@Column(name = "last_name", nullable = false)
	@NotBlank
	private String lastName;
	@Column(name = "student_father_name", nullable = false)
	@NotBlank
	private String studentFatherName;
	@Column(name = "gender", nullable = false)
	@NotBlank
	private Character gender;
	@ManyToOne
	@NotBlank
	@JoinColumn(name = "grade_class_id", nullable = false)
	private GradeClass grade;
	@NotBlank
	@Column(nullable = false)
	private Boolean status;
	@Column(name = "phone_no", nullable = true)
	private Long phone;
	@Column(nullable = false)
	@NotBlank
	private String email;
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	@NotBlank
	private MyUser user;
	@OneToMany(mappedBy = "student")
	@Column(name = "result")
	private List<Result> results;
	
	
	public Student() {}


	public Student(@NotBlank String firsttName, @NotBlank String lastName, @NotBlank String studentFatherName,
			@NotBlank Character gender, @NotBlank Boolean status, Long phone, @NotBlank String email) {
		super();
		this.firsttName = firsttName;
		this.lastName = lastName;
		this.studentFatherName = studentFatherName;
		this.gender = gender;
		this.status = status;
		this.phone = phone;
		this.email = email;
	}


	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public String getFirsttName() {
		return firsttName;
	}


	public void setFirsttName(String firsttName) {
		this.firsttName = firsttName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getStudentFatherName() {
		return studentFatherName;
	}


	public void setStudentFatherName(String studentFatherName) {
		this.studentFatherName = studentFatherName;
	}


	public Character getGender() {
		return gender;
	}


	public void setGender(Character gender) {
		this.gender = gender;
	}


	public GradeClass getGrade() {
		return grade;
	}


	public void setGrade(GradeClass grade) {
		this.grade = grade;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public Long getPhone() {
		return phone;
	}


	public void setPhone(Long phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public MyUser getUser() {
		return user;
	}


	public void setUser(MyUser user) {
		this.user = user;
	}


	public List<Result> getResults() {
		return results;
	}


	public void setResults(List<Result> results) {
		this.results = results;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firsttName=" + firsttName + ", lastName=" + lastName
				+ ", studentFatherName=" + studentFatherName + ", gender=" + gender + ", grade=" + grade + ", status="
				+ status + ", phone=" + phone + ", email=" + email + ", user=" + user + ", results=" + results + "]";
	}
	
	

}
