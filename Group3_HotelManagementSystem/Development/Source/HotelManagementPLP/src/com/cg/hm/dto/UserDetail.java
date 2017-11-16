package com.cg.hm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User_Details Table
 * 
 * @author rohitaku
 *
 */
@Entity
@Table(name = "user_details")
public class UserDetail {
	/**
	 * User ID
	 */
	@Id
	@Column(name = "user_id")
	private int userId;
	/**
	 * Password
	 */
	@Column(name = "password")
	private String password;
	/**
	 * Role
	 */
	@Column(name = "role")
	private String role;
	/**
	 * User Name
	 */
	@Column(name = "user_name")
	private String userName;
	/**
	 * Mobile Number
	 */
	@Column(name = "mobile_no")
	private String mobileNo;
	/**
	 * Phone
	 */
	@Column(name = "phone")
	private String phone;
	/**
	 * Address
	 */
	@Column(name = "address")
	private String address;
	/**
	 * EMail
	 */
	@Column(name = "email")
	private String email;

	/**
	 * Default Constructor
	 */
	public UserDetail() {
		super();
	}

	/**
	 * Parameterized Constructor of UserDetail
	 * 
	 * @param userId
	 * @param password
	 * @param role
	 * @param userName
	 * @param mobileNo
	 * @param phone
	 * @param address
	 * @param email
	 */
	public UserDetail(int userId, String password, String role,
			String userName, String mobileNo, String phone, String address,
			String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	/**
	 * Gets Value of User ID
	 * 
	 * @return
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets Value of User ID
	 * 
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets Value of Password
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets Value of Password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets Value of Role
	 * 
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets Value of Role
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets Value of User Name
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets Value of User Name
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets Value of Mobile Number
	 * 
	 * @return
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Sets Value of Mobile Number
	 * 
	 * @param mobileNo
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * Gets Value of Phone
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets Value of Phone
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets Value of Address
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets Value of Address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets value of EMail
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets Valur of EMail
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Displays Details of Object
	 */
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", password=" + password
				+ ", role=" + role + ", userName=" + userName + ", mobileNo="
				+ mobileNo + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + "]";
	}
}