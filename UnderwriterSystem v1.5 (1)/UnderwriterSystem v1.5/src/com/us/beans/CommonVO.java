package com.us.beans;

import java.util.Date;

public class CommonVO {

	private int crtUser;
	private Date crtDate;
	private int updtUser;
	private Date updtDate;
	
	public CommonVO() {
		super();
	}

	public CommonVO(int crtUser, Date crtDate, int updtUser, Date updtDate) {
		super();
		this.crtUser = crtUser;
		this.crtDate = crtDate;
		this.updtUser = updtUser;
		this.updtDate = updtDate;
	}

	public int getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(int crtUser) {
		this.crtUser = crtUser;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public int getUpdtUser() {
		return updtUser;
	}

	public void setUpdtUser(int updtUser) {
		this.updtUser = updtUser;
	}

	public Date getUpdtDate() {
		return updtDate;
	}

	public void setUpdtDate(Date updtDate) {
		this.updtDate = updtDate;
	}
}
