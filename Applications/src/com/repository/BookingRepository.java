package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Booking;

public class BookingRepository {

	private int customerId = 1;
	private List<Booking> bookingList = new ArrayList<>();
	private static BookingRepository bookingRepository = null;

	private BookingRepository() {
	}

	public static BookingRepository getInstance() {

		if (bookingRepository == null) {

			bookingRepository = new BookingRepository();
		}
		return bookingRepository;
	}

	public void setBookingDetails(Booking booking) {

		try {

			Booking detailsBooking = new Booking(customerId, booking.getCustomerName(),
					booking.getTaxiNo(), booking.getTaxiName(), booking.getPickupPlace(),
					booking.getDropPlace(), booking.getEarning());
			bookingList.add(detailsBooking);
		} catch (Exception e) {

			System.out.println("Wrong Details in setBookingDeatils block" + e.getMessage());
		}
	}
	public List<Booking> getBookingDetails(){
		
		try {
			
			return bookingList;
		} catch (Exception e) {

			System.out.println("Wrong Details in getBookingDetails block"+e.getMessage());
		}
		return null;
	}

	public void setbookingDeatils(Booking book) {

		try {
			
			Booking booking = new Booking(book.getCustomerId(),book.getCustomerName(),book.getTaxiNo(),book.getTaxiName(),book.getPickupPlace(),book.getDropPlace(),book.getEarning());
			bookingList.add(booking);
		} catch (Exception e) {

			System.out.println("Something Adding Problem!!\n"+e.getMessage());
		}
	}
}
