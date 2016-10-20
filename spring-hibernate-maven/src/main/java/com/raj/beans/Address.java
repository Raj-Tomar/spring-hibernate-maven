package com.raj.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="address")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="streetname")
	private String streetName;
	
	@Column(name="city")
	private String city;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="employee_id")
	private EmployeeBean employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}
}
