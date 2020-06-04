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
@Table(name = "principal")
public class Principal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "status")
	private boolean status;
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	@NotBlank
	private MyUser user;
	
	public Principal () {}

	public Principal(String firstName, String lastName, boolean status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
	}

	public Principal(String firstName, String lastName, boolean status, @NotBlank MyUser user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Principal [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", status=" + status
				+ ", user=" + user + "]";
	}
	
	

}
