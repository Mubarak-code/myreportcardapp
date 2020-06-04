package com.recordcard.customermanagementapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long teacherId;
	@Column(name = "first_name")
	@NotBlank
	private String firstName;
	@Column(name = "last_name")
	@NotBlank
	private String lastName;
	private String address;
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	@NotBlank
	private MyUser user;
	
	public Teacher () {}

	public Teacher(@NotBlank String firstName, @NotBlank String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Teacher(@NotBlank String firstName, @NotBlank String lastName, @NotBlank MyUser user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", user=" + user + "]";
	}
	
	
	

}
