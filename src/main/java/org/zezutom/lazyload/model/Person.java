package org.zezutom.lazyload.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="people")
@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = -869313365640539096L;

	@Id
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToMany(mappedBy="person")
	private Collection<Address> addresses;

	public Long getId() {
		return id;
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

	public Collection<Address> getAddresses() {
		return addresses == null ? null : Collections.unmodifiableCollection(addresses);
	}

	public void addAddress(Address address) {
		if (addresses == null) {
			addresses = new ArrayList<Address>();
		}
		addresses.add(address);
	}
	
}
