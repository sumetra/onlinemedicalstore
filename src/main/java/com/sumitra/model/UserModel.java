package com.sumitra.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="user_details")
	
	public class UserModel {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private Integer uId;
		private String uName;
		private String uPassword;
		@Column(unique=true)		
		private String uEmail;
		private String uAddress;
		private String uPhone;
		private String uActive;
		
	@OneToOne(mappedBy = "userModel",cascade = CascadeType.ALL)
	 private UserroleModel userroleModel	;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	 private List<CartModel> cartList;
	
	private LocalDate regDate;   
	
		public UserModel() {
			super();
			
		}
		
		


		public UserModel(Integer uId, String uName, String uPassword, String uEmail, String uAddress, String uPhone,
				String uActive) {
			super();
			this.uId = uId;
			this.uName = uName;
			this.uPassword = uPassword;
			this.uEmail = uEmail;
			this.uAddress = uAddress;
			this.uPhone = uPhone;
			this.uActive = uActive;
			this.cartList = cartList;
		}




		public UserModel(Integer uId, String uName, String uPassword, String uEmail, String uAddress, String uPhone,
				String uActive, UserroleModel userroleModel) {
			super();
			this.uId = uId;
			this.uName = uName;
			this.uPassword = uPassword;
			this.uEmail = uEmail;
			this.uAddress = uAddress;
			this.uPhone = uPhone;
			this.uActive = uActive;
			this.userroleModel = userroleModel;
		}


		
		
		public UserModel(Integer uId, String uName, String uPassword, String uEmail, String uAddress, String uPhone,
				String uActive, UserroleModel userroleModel, List<CartModel> cartList) {
			super();
			this.uId = uId;
			this.uName = uName;
			this.uPassword = uPassword;
			this.uEmail = uEmail;
			this.uAddress = uAddress;
			this.uPhone = uPhone;
			this.uActive = uActive;
			this.userroleModel = userroleModel;
			this.cartList = cartList;
		}




		public UserModel(Integer uId, String uName, String uPassword, String uEmail, String uAddress, String uPhone,
				String uActive, UserroleModel userroleModel, List<CartModel> cartList, LocalDate regDate) {
			super();
			this.uId = uId;
			this.uName = uName;
			this.uPassword = uPassword;
			this.uEmail = uEmail;
			this.uAddress = uAddress;
			this.uPhone = uPhone;
			this.uActive = uActive;
			this.userroleModel = userroleModel;
			this.cartList = cartList;
			this.regDate = regDate;
		}




		public Integer getuId() {
			return uId;
		}


		public void setuId(Integer uId) {
			this.uId = uId;
		}


		public String getuName() {
			return uName;
		}


		public void setuName(String uName) {
			this.uName = uName;
		}


		public String getuPassword() {
			return uPassword;
		}


		public void setuPassword(String uPassword) {
			this.uPassword = uPassword;
		}


		public String getuEmail() {
			return uEmail;
		}


		public void setuEmail(String uEmail) {
			this.uEmail = uEmail;
		}


		public String getuAddress() {
			return uAddress;
		}


		public void setuAddress(String uAddress) {
			this.uAddress = uAddress;
		}


		public String getuPhone() {
			return uPhone;
		}


		public void setuPhone(String uPhone) {
			this.uPhone = uPhone;
		}


		public String getuActive() {
			return uActive;
		}


		public void setuActive(String uActive) {
			this.uActive = uActive;
		}


		public UserroleModel getUserroleModel() {
			return userroleModel;
		}


		public void setUserroleModel(UserroleModel userroleModel) {
			this.userroleModel = userroleModel;
		}




		public List<CartModel> getCartList() {
			return cartList;
		}




		public void setCartList(List<CartModel> cartList) {
			this.cartList = cartList;
		}




		public LocalDate getRegDate() {
			return regDate;
		}




		public void setRegDate(LocalDate regDate) {
			this.regDate = regDate;
		}




	

		

}
