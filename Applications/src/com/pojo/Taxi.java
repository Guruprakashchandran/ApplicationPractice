package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

	private int taxiNo;
	private String taxiName;
	private char place;
	private int earnings = 0;
	private int travels;
	private List<String> travelPlaces = new ArrayList<>();

	public Taxi(int taxiNo, String taxiName, char place, int earnings) {

		this.taxiNo = taxiNo;
		this.taxiName = taxiName;
		this.place = place;
		this.earnings = earnings;
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

	public char getPlace() {
		return place;
	}

	public void setPlace(char place) {
		this.place = place;
	}

	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(int earnings) {
		this.earnings += earnings;
	}

	public int getTravels() {
		return travels;
	}

	public void setTravels() {
		this.travels += 1;
	}

	public List<String> getTravelPlaces() {
		List<String> travelList = new ArrayList<>();
		for (String list : travelPlaces) {

			travelList.add(list);
		}
		return travelList;
	}

	public void setTravelPlace(String place) {
		travelPlaces.add(place);
	}
}
