package com.us.beans;

public class Proposal {

	private int id;     
	private Customer customer;        
	private InsuranceType insuranceType;
	private double sumInsured;
	private int noOfYears;
	private Broker refeBroker;
	private String proposalStatus;
	private String quoteStatus;
	private int policyId;
	
	public Proposal() {
		super();
	}

	public Proposal(int id, Customer customer, InsuranceType insuranceType,
			double sumInsured, int noOfYears, Broker refeBroker,
			String proposalStatus, String quoteStatus,int policyId) {
		super();
		this.id = id;
		this.customer = customer;
		this.insuranceType = insuranceType;
		this.sumInsured = sumInsured;
		this.noOfYears = noOfYears;
		this.refeBroker = refeBroker;
		this.proposalStatus = proposalStatus;
		this.quoteStatus = quoteStatus;
		this.setPolicyId(policyId);
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

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	public double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public int getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

	public Broker getRefeBroker() {
		return refeBroker;
	}

	public void setRefeBroker(Broker refeBroker) {
		this.refeBroker = refeBroker;
	}

	public String getProposalStatus() {
		return proposalStatus;
	}

	public void setProposalStatus(String proposalStatus) {
		this.proposalStatus = proposalStatus;
	}

	public String getQuoteStatus() {
		return quoteStatus;
	}

	public void setQuoteStatus(String quoteStatus) {
		this.quoteStatus = quoteStatus;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
}
