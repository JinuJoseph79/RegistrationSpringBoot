package com.example.hackon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "registered_user")

public class RegisteredUser  {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//Set the identification specification to yes for the Id field. To save table goto Tools_>designer-> uncheck "prevant saving changes..."
	//Make id as primary key
	//curdrepository should also be Long if Id is Long
	private Long id ;
	
	private String firstname;
    private String lastname;

    private String address;
    private int pincode;
    private String city;
    private String country;
    
    
    @NotNull
    @Email
    private String email;
    
    @NotEmpty(message = "Please enter your password.")
  
    private String password;
    
    
    private int phonenumber;
    public String getFirst_name() {
		return firstname;
	}
	public void setFirst_name(String firstName) {
		this.firstname = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
		this.password = password;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phoneNumber) {
		this.phonenumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "RegisteredUser [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address="
				+ address + ", pincode=" + pincode + ", city=" + city + ", country=" + country + ", email=" + email
				+ ", password=" + password + ", phonenumber=" + phonenumber + "]";
	}
	
	
	
}
