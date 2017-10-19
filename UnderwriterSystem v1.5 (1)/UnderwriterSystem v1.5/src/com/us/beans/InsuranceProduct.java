package com.us.beans;

public class InsuranceProduct {

	private int id;
	private String name;
	private String status;
	private Coverage[] coverage;
	
	public InsuranceProduct() {
		super();
	}
	
	public InsuranceProduct(int id, String name, String status,
			Coverage[] coverage) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.coverage = coverage;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Coverage[] getCoverage() {
		return coverage;
	}

	public void setCoverage(Coverage[] coverage) {
		this.coverage = coverage;
	}
}
