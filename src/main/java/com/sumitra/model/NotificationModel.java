package com.sumitra.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="notification")

public class NotificationModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer nId;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	private UserModel userModel;
	
	@OneToOne
	@JoinColumn(name= "oid")
	private OrderModel orderModel;
	
	private String notice;
	private String viewed;
	private LocalDate date;

	public NotificationModel() {
		
		
	}

	public NotificationModel(Integer nId, UserModel userModel, OrderModel orderModel, String notice, String viewed,
			LocalDate date) {
		super();
		this.nId = nId;
		this.userModel = userModel;
		this.orderModel = orderModel;
		this.notice = notice;
		this.viewed = viewed;
		this.date = date;
	}

	public Integer getnId() {
		return nId;
	}

	public void setnId(Integer nId) {
		this.nId = nId;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public OrderModel getOrderModel() {
		return orderModel;
	}

	public void setOrderModel(OrderModel orderModel) {
		this.orderModel = orderModel;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getViewed() {
		return viewed;
	}

	public void setViewed(String viewed) {
		this.viewed = viewed;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
