package com.assignment.first.bank;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Table(name ="Bank_Details" )
@Entity
@Embeddable
//@JsonFilter("FilterByNameorAddress")
public class BankDetails {
	
	@Id
	@GeneratedValue
	private int id ;
	
	@NotEmpty
	private String bank_Name ;
	@NotEmpty
	private String bank_Address ;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	public String getBank_Name() {
		return bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		this.bank_Name = bank_Name;
	}
	public String getBank_Address() {
		return bank_Address;
	}
	public void setBank_Address(String bank_Address) {
		this.bank_Address = bank_Address;
	}
	
	
	
	public BankDetails( @NotEmpty String bank_Name, @NotEmpty String bank_Address) {
		super();

		this.bank_Name = bank_Name;
		this.bank_Address = bank_Address;
	}
	public BankDetails() {
		
	}
	

}
