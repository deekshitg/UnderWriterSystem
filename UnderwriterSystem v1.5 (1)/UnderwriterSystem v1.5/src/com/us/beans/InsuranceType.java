package com.us.beans;

public class InsuranceType {

	private int id;
	private String name;
	private InsuranceProduct[] insuranceProducts;
	private String status;
	
	public InsuranceType() {
		super();
	}

	public InsuranceType(int id, String name,InsuranceProduct[] insuranceProducts,String status) {
		super();
		this.id = id;
		this.name = name;
		this.insuranceProducts = insuranceProducts;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InsuranceProduct[] getInsuranceProducts() {
		return insuranceProducts;
	}

	public void setInsuranceProducts(InsuranceProduct[] insuranceProducts) {
		this.insuranceProducts = insuranceProducts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
