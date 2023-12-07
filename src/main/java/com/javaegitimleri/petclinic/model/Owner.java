package com.javaegitimleri.petclinic.model;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="t_owner")
@XmlRootElement
public class Owner {
	@Id


	
private Long id;
	@Column(name="first_name")
private String firstName;
	@Column(name="last_name")
private String lastName;
	@OneToMany(mappedBy="owner")
	private Set<Pet> pets1=new HashSet<>();
@Override
public String toString() {
	return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +  "]";
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
@XmlTransient
@JsonIgnore
public Set<Pet> getPets() {
	return pets1;
}
public void setPets(Set<Pet> pets) {
	this.pets1 = pets;
}
private Set<Pet> pets=new HashSet<>();

}
