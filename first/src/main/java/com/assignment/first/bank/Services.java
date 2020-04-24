package com.assignment.first.bank;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "Services")
@Entity
@Embeddable
public class Services {

	@Id
	@GeneratedValue
	int service_id;

	@NotEmpty
	String service_name;

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public Services(@NotEmpty String service_name) {
		super();
		this.service_name = service_name;
	}

	public Services() {

	}

}
