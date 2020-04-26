package com.microservices.currencyconversionservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="currency_conversion" )
public class CurrencyConversionBean {
	
	
	@Id
	private Long id ;
	@Column(name = "currency_from")
	private String from ;
	@Column(name = "currency_to")
	private String to ;
	
	@Column(name= "conversion_multiple")
	private BigDecimal conversionMultiple ;
	
	@Column(name= "quantity")
	private BigDecimal quantity  ;
	
	@Column(name= "total_amount")
	private BigDecimal totalAmount  ;
	
	@Column(name= "port")
	private int port;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public CurrencyConversionBean() {
		
	}

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.port = port;
	}
	
	
	

}
