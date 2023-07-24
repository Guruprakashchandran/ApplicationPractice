package com.taxibookingmodel;

import com.pojo.Admin;
import com.pojo.Booking;

public interface TaxiBookingControllerToModelCall {

	String addBookingDetails(Booking booking);

	boolean checkAdminDetail(Admin admin);

	void createTaxis(int count);

}
