package com.assignment.first.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "Bank_Details")
@Entity
@Embeddable
//@JsonFilter("FilterByNameorAddress")
public class BankDetails {
	@Id
	@GeneratedValue
	private int id;

	@NotEmpty
	private String bank_Name;
	@NotEmpty
	private String bank_Address;

	@ElementCollection
	@JsonIgnore
	// @Column(name="service_id") // in table tbl_myentities
	private List<Integer> service_id;

	@Column(name = "service_ids")
	private String service_ids;

	public String getService_ids() {

		return service_ids;

	}

	public void setService_ids(String service_ids) {
		this.service_ids = service_ids;
	}

	public List<Integer> getService_id() {
		service_id = new ArrayList<Integer>();
		String[] integers = service_ids.split(",");
		for (String num : integers) {
			int i = Integer.parseInt(num);
			service_id.add(i);
		}
		return service_id;
	}

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

//	public BankDetails( @NotEmpty String bank_Name, @NotEmpty String bank_Address) {
//		super();
//
//		this.bank_Name = bank_Name;
//		this.bank_Address = bank_Address;
//	}

	public BankDetails(@NotEmpty String bank_Name, @NotEmpty String bank_Address, String service_ids) {
		super();
		this.bank_Name = bank_Name;
		this.bank_Address = bank_Address;
		this.service_ids = service_ids;
	}

	public BankDetails() {

	}

}
