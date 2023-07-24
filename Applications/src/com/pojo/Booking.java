package com.pojo;

public class Booking {

	private int customerId;
	private String customerName;
	private int taxiNo;
	private String taxiName;
	private char pickupPlace;
	private char dropPlace;
	private int earning;

	public Booking(int customerId, String customerName,int taxiNo, String taxiName, char pickupPlace, char dropPlace, int earning) {

		this.customerId = customerId;
		this.customerName = customerName;
		this.taxiNo = taxiNo;
		this.taxiName = taxiName;
		this.pickupPlace = pickupPlace;
		this.dropPlace = dropPlace;
		this.earning = earning;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getTaxiNo() {
		return taxiNo;
	}

	public void setTaxiNo(int taxiNo) {
		this.taxiNo = taxiNo;
	}

	public String getTaxiName() {
		return taxiName;
	}

	public void setTaxiName(String taxiName) {
		this.taxiName = taxiName;
	}

	public char getPickupPlace() {
		return pickupPlace;
	}

	public void setPickupPlace(char pickupPlace) {
		this.pickupPlace = pickupPlace;
	}

	public char getDropPlace() {
		return dropPlace;
	}

	public void setDropPlace(char dropPlace) {
		this.dropPlace = dropPlace;
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}

}
