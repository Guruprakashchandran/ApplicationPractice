package com.taxibookingmodel;

import java.util.List;

import com.pojo.Admin;
import com.pojo.Booking;
import com.pojo.Taxi;
import com.repository.AdminRepository;
import com.repository.BookingRepository;
import com.repository.TaxiDetailsRepository;

public class TaxiBookingModel implements TaxiBookingControllerToModelCall {

	private TaxiBookingModelToControllerCall taxiBookingModelToControllerCall;
	private int customerId = 0;

	public TaxiBookingModel(TaxiBookingController taxiBookingController) {

		taxiBookingModelToControllerCall = taxiBookingController;
	}

	@Override
	public String addBookingDetails(Booking booking) {

		try {

			List<Taxi> taxiDetails = TaxiDetailsRepository.getInstance().getTaxiDetails();
			Taxi taxi = null;
			int newDistance = 0;
			int oldDistance = Integer.MAX_VALUE;
			for (int i = 0; i < taxiDetails.size(); ++i) {

				newDistance = taxiDetails.get(i).getPlace() > booking.getPickupPlace()
						? taxiDetails.get(i).getPlace() - booking.getPickupPlace()
						: booking.getPickupPlace() - taxiDetails.get(i).getPlace();
				taxi = newDistance < oldDistance || taxi == null ? taxiDetails.get(i)
						: (newDistance == oldDistance
								? (taxiDetails.get(i).getEarnings() > taxi.getEarnings() ? taxiDetails.get(i) : taxi)
								: taxi);
				oldDistance = newDistance < oldDistance ? newDistance : oldDistance;
			}
			Booking book = new Booking(++customerId, booking.getCustomerName(), taxi.getTaxiNo(), taxi.getTaxiName(),
					booking.getPickupPlace(), booking.getDropPlace(), booking.getEarning());
			TaxiDetailsRepository.getInstance().setTaxiDetail(taxi.getTaxiNo() - 1, booking.getDropPlace(),
					booking.getEarning(), book.getPickupPlace());
			BookingRepository.getInstance().setbookingDeatils(book);
			return taxi.getTaxiName();

		} catch (Exception e) {

			System.out.println("Taxi Not Allocated!!!\n" + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean checkAdminDetail(Admin admin) {

		try {

			List<Admin> adminList = AdminRepository.getInstance().getAdminDetails();
			for (Admin list : adminList) {

				if (list.getAdminName().equals(admin.getAdminName())) {

					return true;
				}
			}
		} catch (Exception e) {

			System.out.println("Admin Not In List!!!\n" + e.getMessage());
		}
		return false;
	}

	@Override
	public void createTaxis(int count) {

		try {

			TaxiDetailsRepository.getInstance().createTaxis(count);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}
