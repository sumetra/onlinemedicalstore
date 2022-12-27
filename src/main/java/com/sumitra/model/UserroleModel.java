package com.sumitra.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_role")

public class UserroleModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer rId;
	private String rRole;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uId")
	 private UserModel userModel;
	
	
	public UserroleModel() {
		super();
		
	}


	public UserroleModel(Integer rId, String rRole, UserModel userModel) {
		super();
		this.rId = rId;
		this.rRole = rRole;
		this.userModel = userModel;
	}


	public Integer getrId() {
		return rId;
	}


	public void setrId(Integer rId) {
		this.rId = rId;
	}


	public String getrRole() {
		return rRole;
	}


	public void setrRole(String rRole) {
		this.rRole = rRole;
	}


	public UserModel getUserModel() {
		return userModel;
	}


	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	
	

}
