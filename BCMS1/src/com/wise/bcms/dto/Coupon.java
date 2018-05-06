package com.wise.bcms.dto;

import com.wise.bcms.dto.Denomination;

public class Coupon {
	private int id;
	private String validity;
	private Denomination denomination;
	private int activate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public Denomination getDenomination() {
		return denomination;
	}
	public void setDenomination(Denomination denomination) {
		this.denomination = denomination;
	}
	public int getActivate() {
		return activate;
	}
	public void setActivate(int activate) {
		this.activate = activate;
	}

}
