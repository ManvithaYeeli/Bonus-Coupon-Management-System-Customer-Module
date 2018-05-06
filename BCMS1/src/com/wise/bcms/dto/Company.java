package com.wise.bcms.dto;

import java.util.Date;

public class Company {
		private int id;
		private String name;
		private	Date doe;
		private	Date dor;
		private	int surveyNo;
		private	String email;
		private	String password;
		private String landmark;
		private String location;
		private String city;
		private String state;
		private String country;
		private int pincode;
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
		public Date getDoe() {
			return doe;
		}
		public void setDoe(Date doe) {
			this.doe = doe;
		}
		public Date getDor() {
			return dor;
		}
		public void setDor(Date dor) {
			this.dor = dor;
		}
		public int getSurveyNo() {
			return surveyNo;
		}
		public void setSurveyNo(int surveyNo) {
			this.surveyNo = surveyNo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLandmark() {
			return landmark;
		}
		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
		

}
