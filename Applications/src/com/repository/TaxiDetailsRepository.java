package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Taxi;

public class TaxiDetailsRepository {

	private int taxiNo = 1;
	private static TaxiDetailsRepository taxiDetailsRepository = null;
	private List<Taxi> taxiList = new ArrayList<>();

	private TaxiDetailsRepository() {
	}

	public static TaxiDetailsRepository getInstance() {

		if (taxiDetailsRepository == null) {

			taxiDetailsRepository = new TaxiDetailsRepository();
		}
		return taxiDetailsRepository;
	}

	public String createTaxis(int n) {

		try {

			for (int i = 0; i < n; ++i) {

				Taxi taxi = new Taxi(taxiNo, "Taxi " + taxiNo, 'A', 0);
				taxiNo++;
				taxiList.add(taxi);
			}
		} catch (Exception e) {

			System.out.println("Index Reached in create Taxis block!!!" + e.getMessage());
		}
		return "Success";
	}

	public List<Taxi> getTaxiDetails() {

		try {

			return taxiList;
		} catch (Exception e) {

			System.out.println("Wrong Details in getTaxiDetails block" + e.getMessage());
		}
		return null;
	}

	public void setTaxiDetail(int index, char place, int earning, char pickupPlace) {

		try {

			taxiList.get(index).setEarnings(earning);
			taxiList.get(index).setTravelPlace(pickupPlace + " to " + place);
			taxiList.get(index).setPlace(place);
			taxiList.get(index).setTravels();
		} catch (Exception e) {

			System.out.println("Index Reached in getTaxiDetails block!!!" + e.getMessage());
		}
	}
}
