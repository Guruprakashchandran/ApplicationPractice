package com.taxibookingmodel;

public class TaxiBookingUtil {

	public static boolean checkCustomerName(String customerName) {

		return customerName != null ? true : false;
	}

	public static boolean checkPickupPlace(char pickupPlace) {

		return pickupPlace >= 'A' && pickupPlace <= 'F' ? true : false;
	}

	public static boolean checkDropPlace(char pickupPlace, char dropPlace) {

		return dropPlace>='A'&& dropPlace<='F' &&dropPlace!=pickupPlace?true:false;
	}

	public static boolean checkAdminName(String adminName) {

		return adminName != null ? true : false;
	}
	public static boolean checkAdminPassword(String adminPassword) {
		
		return adminPassword != null && adminPassword.length() == 8 ? true : false;
	}
}
