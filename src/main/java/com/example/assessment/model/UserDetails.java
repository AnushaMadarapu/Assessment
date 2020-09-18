package com.example.assessment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message = "Name can not be null!!")
	@Size(max=2)
    private String firstName;
    
    @Column(name="lastname")
	private String lastName;
	
	@NotNull
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
    private String address2;
	
	@NotNull
	@Column(name="city")
    private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip")
    private String zip;
	
	@Column(name="country")
	private String country;

	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;

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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip){
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country= country;
	}

	public Date getDate(){
		return date;
	}

	public void setDate(Date date){
		this.date = date;
	}

	@Override
    public String toString() {
        return "UserDetails [id=" + id + ", firstname=" + firstName + 
                ", lastname=" + lastName + ", address1=" + address1  + 
                ", address2="+ address2 + ", city=" +  city + ", state=" +
                state + ", zip="+ zip+ ", country=" + country+ ", date="+ date +"]";
	}
	

}