package com.assignment.first.bank;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "Bank_Branch_Details")
@Entity
@Embeddable
public class BankBranchDetails {

	@Id
	@GeneratedValue
	private int branch_id;

	@NotNull
	private int bank_id;

	@NotEmpty
	private String branch_name;

	@NotEmpty
	private String branch_location;

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_location() {
		return branch_location;
	}

	public void setBranch_location(String branch_location) {
		this.branch_location = branch_location;
	}

	public BankBranchDetails(@NotNull int bank_id, @NotEmpty String branch_name, @NotEmpty String branch_location) {
		super();
		this.bank_id = bank_id;
		this.branch_name = branch_name;
		this.branch_location = branch_location;
	}

	public BankBranchDetails() {

	}

}
