package com.recordcard.customermanagementapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Id;

@Entity
public class Privilege {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long Id;
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "privileges", cascade = CascadeType.ALL)
	private List<Role> roles;
	
	public Privilege() {}

	public Privilege(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Privilege [Id=" + Id + ", name=" + name + ", roles=" + roles + "]";
	}

	
	
	
}
