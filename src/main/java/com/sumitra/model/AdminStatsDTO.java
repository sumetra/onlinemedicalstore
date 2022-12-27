package com.sumitra.model;

public class AdminStatsDTO {

	private int no_of_users;
	private int no_of_orders;
	private int no_of_prodouts;
	
	
	public AdminStatsDTO() {
		super();
	}
	public AdminStatsDTO(int no_of_users, int no_of_orders, int no_of_prodouts) {
		super();
		this.no_of_users = no_of_users;
		this.no_of_orders = no_of_orders;
		this.no_of_prodouts = no_of_prodouts;
	}
	public int getNo_of_users() {
		return no_of_users;
	}
	public void setNo_of_users(int no_of_users) {
		this.no_of_users = no_of_users;
	}
	public int getNo_of_orders() {
		return no_of_orders;
	}
	public void setNo_of_orders(int no_of_orders) {
		this.no_of_orders = no_of_orders;
	}
	public int getNo_of_prodouts() {
		return no_of_prodouts;
	}
	public void setNo_of_prodouts(int no_of_prodouts) {
		this.no_of_prodouts = no_of_prodouts;
	}
	
	

}
