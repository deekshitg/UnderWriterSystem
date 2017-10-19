package com.us.beans;

public class Rule {
	
	private int occu_others_perc;
	private int occu_min_nuc_perc;
	private int gender_female;
	private int gender_male_perc;
	private int gov_tax_perc;
	private int age_below_40_yrs_perc;
	private int age_bet_60_to_40_yrs_perc;
	private int age_bet_80_to_60_yrs_perc;
	private int age_above_80_yrs_perc;
	private int insurance_type_id;
	
	
	public Rule() {
		super();
	}


	public Rule(int occu_others_perc, int occu_min_nuc_perc, int gender_female,
			int gender_male_perc, int gov_tax_perc, int age_below_40_yrs_perc,
			int age_bet_60_to_40_yrs_perc, int age_bet_80_to_60_yrs_perc,
			int age_above_80_yrs_perc, int insurance_type_id) {
		super();
		this.occu_others_perc = occu_others_perc;
		this.occu_min_nuc_perc = occu_min_nuc_perc;
		this.gender_female = gender_female;
		this.gender_male_perc = gender_male_perc;
		this.gov_tax_perc = gov_tax_perc;
		this.age_below_40_yrs_perc = age_below_40_yrs_perc;
		this.age_bet_60_to_40_yrs_perc = age_bet_60_to_40_yrs_perc;
		this.age_bet_80_to_60_yrs_perc = age_bet_80_to_60_yrs_perc;
		this.age_above_80_yrs_perc = age_above_80_yrs_perc;
		this.insurance_type_id = insurance_type_id;
	}
	
	
	public int getOccu_others_perc() {
		return occu_others_perc;
	}
	public void setOccu_others_perc(int occu_others_perc) {
		this.occu_others_perc = occu_others_perc;
	}
	public int getOccu_min_nuc_perc() {
		return occu_min_nuc_perc;
	}
	public void setOccu_min_nuc_perc(int occu_min_nuc_perc) {
		this.occu_min_nuc_perc = occu_min_nuc_perc;
	}
	public int getGender_female() {
		return gender_female;
	}
	public void setGender_female(int gender_female) {
		this.gender_female = gender_female;
	}
	public int getGender_male_perc() {
		return gender_male_perc;
	}
	public void setGender_male_perc(int gender_male_perc) {
		this.gender_male_perc = gender_male_perc;
	}
	public int getGov_tax_perc() {
		return gov_tax_perc;
	}
	public void setGov_tax_perc(int gov_tax_perc) {
		this.gov_tax_perc = gov_tax_perc;
	}
	public int getAge_below_40_yrs_perc() {
		return age_below_40_yrs_perc;
	}
	public void setAge_below_40_yrs_perc(int age_below_40_yrs_perc) {
		this.age_below_40_yrs_perc = age_below_40_yrs_perc;
	}
	public int getAge_bet_60_to_40_yrs_perc() {
		return age_bet_60_to_40_yrs_perc;
	}
	public void setAge_bet_60_to_40_yrs_perc(int age_bet_60_to_40_yrs_perc) {
		this.age_bet_60_to_40_yrs_perc = age_bet_60_to_40_yrs_perc;
	}
	public int getAge_bet_80_to_60_yrs_perc() {
		return age_bet_80_to_60_yrs_perc;
	}
	public void setAge_bet_80_to_60_yrs_perc(int age_bet_80_to_60_yrs_perc) {
		this.age_bet_80_to_60_yrs_perc = age_bet_80_to_60_yrs_perc;
	}
	public int getAge_above_80_yrs_perc() {
		return age_above_80_yrs_perc;
	}
	public void setAge_above_80_yrs_perc(int age_above_80_yrs_perc) {
		this.age_above_80_yrs_perc = age_above_80_yrs_perc;
	}
	public int getInsurance_type_id() {
		return insurance_type_id;
	}
	public void setInsurance_type_id(int insurance_type_id) {
		this.insurance_type_id = insurance_type_id;
	}

}
