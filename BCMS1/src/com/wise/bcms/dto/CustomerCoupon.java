package com.wise.bcms.dto;

import java.util.Date;

import com.wise.bcms.dto.Coupon;
import com.wise.bcms.dto.Customer;

public class CustomerCoupon {
	private Coupon coupon;
	private Customer customer;
	private Date validDate;
	private int year;
	private String month;
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getValidDate() {
		return validDate;
	}
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
}
