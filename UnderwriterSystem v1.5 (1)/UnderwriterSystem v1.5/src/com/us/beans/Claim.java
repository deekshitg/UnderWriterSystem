package com.us.beans;

import java.util.Date;

public class Claim {

	private int id; 
	private Customer customer;
	private int policyId;
	private double claimAmount;
	private Date claimDate;
	
	public Claim() {
		super();
	}

	public Claim(int id, Customer customer, int policyId, double claimAmount,
			Date claimDate) {
		super();
		this.id = id;
		this.customer = customer;
		this.policyId = policyId;
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}
	
}
