package com.taxibookingmodel;

import java.util.Scanner;

import com.pojo.Admin;
import com.pojo.Booking;

public class TaxiBookingView implements TaxiBookingControllerToViewCall {

	private Scanner scanner = new Scanner(System.in);
	private TaxiBookingViewToControllerCall taxiBookingViewToControllerCall;

	public TaxiBookingView() {

		taxiBookingViewToControllerCall = new TaxiBookingController(this);
	}

	public static void main(String[] args) {

		new TaxiBookingView().getInputs();
	}

	private void getInputs() {

		try {

			boolean isIterate = true;
			System.out.println("*************TAXI BOOKING**************\n");
			while (isIterate) {

				System.out.println("1) Booking");
				System.out.println("2) Admin");
				System.out.println("3) Exit\n");

				System.out.print("Enter Input : ");
				int input = scanner.nextInt();
				scanner.nextLine();
				switch (input) {

				case 1:
					bookingPage();
					break;
				case 2:
					adminPage();
					break;
				case 3:
					isIterate = false;
					System.out.println("Exitted!!!");
					break;
				default:
					System.out.println("Wrong Input!!!\nRe Enter the Input!!!");
				}
			}
		} catch (Exception e) {

			System.out.println("Wrong Input!!!\n" + e.getMessage());
		}
	}

	private void bookingPage() {

		try {

			String customerName = getCustomerName();
			char pickupPlace = getPickupPlace();
			char dropPlace = getDropPlace(pickupPlace);
			String taxiName = taxiBookingViewToControllerCall.addBookingDetails(new Booking(0,customerName,0,null,pickupPlace,dropPlace,0));
			System.out.println("Details Added!!!");
			System.out.println("Allocated Taxi Name: "+taxiName);
			int amount = calculateAmount(pickupPlace,dropPlace);
			System.out.println("Amount: "+amount+"\n");
			
		} catch (Exception e) {
			System.out.println("Wrong Input!!!\n" + e.getMessage());
		}
	}

	private int calculateAmount(char pickupPlace, char dropPlace) {

		try {
			
			int distance = (pickupPlace < dropPlace ? dropPlace - pickupPlace: pickupPlace - dropPlace) * 15;
			return ((distance - 5) * 5 + 100);
			
		} catch (Exception e) {

			System.out.println("Something Wrong !!!\n"+e.getMessage());
		}
		return 0;
	}

	private char getDropPlace(char pickupPlace) {

		try {
			
			System.out.print("Enter Drop Place: ");
			char dropPlace = scanner.next().charAt(0);
			if(!TaxiBookingUtil.checkDropPlace(pickupPlace,dropPlace)) {
				
				System.out.println("Wrong Drop Place!!!");
				System.out.println("Re enter Drop Place!!!");
				dropPlace = getDropPlace(pickupPlace);
			}
			return dropPlace;
		} catch (Exception e) {

			System.out.println("Wrong Input!!!\n"+e.getMessage());
		}
		return 0;
	}

	private char getPickupPlace() {

		try {

			System.out.print("Enter Pickup Place : ");
			char pickupPlace = scanner.next().charAt(0);
			if (!TaxiBookingUtil.checkPickupPlace(pickupPlace)) {

				System.out.println("Wrong PickupPlace!!!");
				System.out.println("Re enter PickupPlace!!!");
				pickupPlace = getPickupPlace();
			}
			return pickupPlace;
		} catch (Exception e) {

			System.out.println("Wrong Input!!!\n" + e.getMessage());
		}
		return '\0';
	}

	private String getCustomerName() {

		try {

			System.out.print("Enter Customer Name : ");
			String customerName = scanner.nextLine();
			if (!TaxiBookingUtil.checkCustomerName(customerName)) {

				System.out.println("Wrong Customer name!!!");
				System.out.println("Re enter the Customer Name!!!");
				customerName = getCustomerName();
			}
			return customerName;
		} catch (Exception e) {

			System.out.println("Wrong Input!!!\n" + e.getMessage());
		}
		return null;
	}

	private void adminPage() {

		try {
			
			System.out.println("Welcome!!! Admin Page!!!");
			String adminName = getAdminName();
			String adminPassword = getAdminPassword();
			Admin admin= new Admin(adminName,adminPassword);
			if(taxiBookingViewToControllerCall.checkAdminDetail(admin)) {
				
				System.out.println("Login Successfully!!!\n");
				adminPage(admin);
			}
		} catch (Exception e) {

			System.out.println("Wrong Input!!\n" + e.getMessage());
		}
	}

	private void adminPage(Admin admin) {

		try {
			
			boolean isIterate = true;
			while(isIterate) {
				
				System.out.println("1) Create Taxis");
				System.out.println("2) show Booking Details");
				System.out.println("3) show Taxi Details");
				System.out.println("4) Add Admin");
				System.out.println("5) Exit");
				
				System.out.print("Enter Input: ");
				int input= scanner.nextInt();
				scanner.nextLine();
				switch(input) {
				
				case 1:
					createTaxis();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					isIterate = false;
					System.out.println("LogOut!!!\n");
					break;
				default:
					System.out.println("Wrong Input!!!");
					System.out.println("Re enter Input!!!");
				}
			}
		} catch (Exception e) {

			System.out.println("Wrong Input!!!\n"+e.getMessage());
		}
	}

	private void createTaxis() {

		try {
			
			System.out.print("Enter Taxi Count: ");
			int count = scanner.nextInt();
			taxiBookingViewToControllerCall.createTaxis(count);
		} catch (Exception e) {

			System.out.println("Wrong Input!!!\n"+e.getMessage());
		}
	}

	private String getAdminPassword() {

		try {
			
			System.out.print("Enter Admin Password(Length must be 8 characters): ");
			String adminPassword = scanner.next();
			if(!TaxiBookingUtil.checkAdminPassword(adminPassword)) {
				
				adminPassword = getAdminPassword();
			}
			return adminPassword;
		} catch (Exception e) {

			System.out.println("Wrong Input!!\n"+e.getMessage());
		}
		return null;
	}

	private String getAdminName() {

		try {
			
			System.out.print("Enter Admin Name: ");
			String adminName = scanner.next();
			if(!TaxiBookingUtil.checkAdminName(adminName)) {
				
				adminName = getAdminName();
			}
			return adminName;
		} catch (Exception e) {

			System.out.println("Wrong Input!!!\n"+e.getMessage());
		}
		return null;
	}
}
