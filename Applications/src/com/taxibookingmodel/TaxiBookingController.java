package com.taxibookingmodel;

import com.pojo.Admin;
import com.pojo.Booking;

public class TaxiBookingController implements TaxiBookingViewToControllerCall, TaxiBookingModelToControllerCall {

	private TaxiBookingControllerToViewCall taxiBookingControllerToViewCall;
	private TaxiBookingControllerToModelCall taxiBookingControllerToModelCall;

	public TaxiBookingController(TaxiBookingView taxiBookingView) {

		this.taxiBookingControllerToViewCall = taxiBookingView;
		taxiBookingControllerToModelCall = new TaxiBookingModel(this);
	}

	@Override
	public String addBookingDetails(Booking booking) {

		String taxiName = taxiBookingControllerToModelCall.addBookingDetails(booking);
		return taxiName;
	}

	@Override
	public boolean checkAdminDetail(Admin admin) {

		return taxiBookingControllerToModelCall.checkAdminDetail(admin);
	}

	@Override
	public void createTaxis(int count) {

		taxiBookingControllerToModelCall.createTaxis(count);
	}
}
