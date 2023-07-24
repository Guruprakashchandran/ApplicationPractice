package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Admin;

public class AdminRepository {

	private static AdminRepository adminRepository = null;
	private List<Admin> adminList = new ArrayList<>();

	private AdminRepository() {
	
		Admin admin = new Admin("guru","guru0123");
		adminList.add(admin);
	}
	
	public static AdminRepository getInstance() {
		
		try {
			
			if(adminRepository == null) {
				adminRepository = new AdminRepository();
			}
			return adminRepository;
		} catch (Exception e) {

			System.out.println("Didnt Create Object for Repository!!!\n"+e.getMessage());
		}
		return null;
	}
	public void addAdmin(String adminName,String adminPassword) {
		
		try {
			
			Admin admin = new Admin(adminName,adminPassword);
			adminList.add(admin);
		} catch (Exception e) {

			System.out.println("Didnt Add admin!!\n"+e.getMessage());
		}
	}
	public List<Admin> getAdminDetails(){
		
		try {
			
			return adminList;
		} catch (Exception e) {

			System.out.println("Didnt get Admin Details!!!\n"+e.getMessage());
		}
		return null;
	}
}
