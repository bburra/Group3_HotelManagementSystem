package com.cg.hm.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Hotel Table
 * 
 * @author rohitaku
 *
 */
@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Hotel ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hotel_id")
	private Integer hotelId;
	/**
	 * City
	 */
	@Pattern(regexp = "[A-Za-z ]{1,}", message = "City Should not have digits")
	@Column(name = "city")
	private String city;
	/**
	 * Hotel Name
	 */
	@Pattern(regexp = "[A-Za-z ]{1,}", message = "Hotel Name Should not have digits")
	@Column(name = "hotel_name")
	private String hotelName;
	/**
	 * Address
	 */
	@NotEmpty
	@Column(name = "address")
	private String address;
	/**
	 * Description
	 */
	@Pattern(regexp = "[A-Za-z ]{1,}", message = "Enter valid Pattern ex:AC")
	@Column(name = "description")
	private String description;
	/**
	 * Average Rate per Night
	 */
	@Min(1000)
	@Column(name = "avg_rate_per_night")
	private Integer avgRatePerNight;
	/**
	 * Phone1
	 */
	@Pattern(regexp = "[1-9]{1}[0-9]{9}", message = "Phone no. must be 10 digits")
	@Column(name = "phone_no1")
	private String phone1;
	/**
	 * Phone2
	 */
	@Pattern(regexp = "[1-9]{1}[0-9]{9}", message = "Phone no. must be 10 digits")
	@Column(name = "phone_no2")
	private String phone2;
	/**
	 * Rating
	 */
	@Min(1)
	@Max(5)
	@Column(name = "rating")
	private Integer rating;

	/**
	 * Fax
	 */
	@Pattern(regexp = "[1-9]{1}[0-9]{4}", message = "It Should have Five digits only")
	@Column(name = "fax")
	private String fax;

	/**
	 * Email
	 */
	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}", message = "Enter valid Email Ex:abc@gmail.com")
	@Column(name = "email")
	private String email;

	/**
	 * Gets Value of Email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets Value of Email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets Value of Hotel ID
	 * 
	 * @return
	 */
	public Integer getHotelId() {
		return hotelId;
	}

	/**
	 * Sets Value of Hotel ID
	 * 
	 * @param hotelId
	 */
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * Gets Value of City
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets Value of City
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets Value of Hotel Name
	 * 
	 * @return
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * Sets Value of Hotel Name
	 * 
	 * @param hotelName
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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
	 * Gets Value of Description
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets Value of Description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets Value of AvgRatePerNight
	 * 
	 * @return
	 */
	public Integer getAvgRatePerNight() {
		return avgRatePerNight;
	}

	/**
	 * Sets Value of AvgRatePerNight
	 * 
	 * @param avgRatePerNight
	 */
	public void setAvgRatePerNight(Integer avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}

	/**
	 * Gets Value of Phone1
	 * 
	 * @return
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * Sets Value of Phone1
	 * 
	 * @param phone1
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	/**
	 * Gets Value of Phone2
	 * 
	 * @return
	 */
	public String getPhone2() {
		return phone2;
	}

	/**
	 * Sets Value of Phone2
	 * 
	 * @param phone2
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	/**
	 * Gets Value of Rating
	 * 
	 * @return
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * Sets Value of Rating
	 * 
	 * @param rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Gets Value of Fax
	 * 
	 * @return
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Sets Value of Fax
	 * 
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Displays Details of Hotel Object
	 */
	@Override
	public String toString() {
		return "Hotels [hotelId=" + hotelId + ", city=" + city + ", hotelName="
				+ hotelName + ", address=" + address + ", description="
				+ description + ", avgRatePerNight=" + avgRatePerNight
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", rating="
				+ rating + ", fax=" + fax + ", email=" + email + "]";
	}
}
