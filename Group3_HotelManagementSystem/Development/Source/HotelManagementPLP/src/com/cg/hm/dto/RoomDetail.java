package com.cg.hm.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Room_Details Table
 * 
 * @author rohitaku
 *
 */
@Entity
@Table(name = "room_details")
public class RoomDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Room ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "room_id")
	private Integer roomId;
	/**
	 * Hotel ID
	 */
	@NotNull
	@Column(name = "hotel_id")
	private Integer hotelId;
	/**
	 * Room Number
	 */
	@Pattern(regexp = "[1-9]{1}[0-9]{1,}", message = "It should be a number")
	@Column(name = "room_no")
	private String roomNo;
	/**
	 * Room Type
	 */
	@NotEmpty(message = "Please Select any option")
	@Column(name = "room_type")
	private String roomType;
	/**
	 * Per Night Rate
	 */
	@Column(name = "per_night_rate")
	@Min(1000)
	private Integer perNightRate;
	/**
	 * Availability
	 */
	@Pattern(regexp = "[A-Za-z]{1,}", message = "Enter YES/NO")
	@Column(name = "availability")
	private String availability;

	/**
	 * Parameterized Constructor
	 * 
	 * @param hotelId
	 * @param roomId
	 * @param roomNo
	 * @param roomType
	 * @param perNightRate
	 * @param availability
	 */
	public RoomDetail(Integer hotelId, Integer roomId, String roomNo,
			String roomType, Integer perNightRate, String availability) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.perNightRate = perNightRate;
		this.availability = availability;
	}

	/**
	 * Default Constructor
	 */
	public RoomDetail() {
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
	 * Gets Value of Room ID
	 * 
	 * @return
	 */
	public Integer getRoomId() {
		return roomId;
	}

	/**
	 * Sets Value of Room ID
	 * 
	 * @param roomId
	 */
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	/**
	 * Gets Value of Room Number
	 * 
	 * @return
	 */
	public String getRoomNo() {
		return roomNo;
	}

	/**
	 * Sets Value of Room Number
	 * 
	 * @param roomNo
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	/**
	 * Gets Value of Room Type
	 * 
	 * @return
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Sets Value of Room Type
	 * 
	 * @param roomType
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * Gets Value of Per Night Rate
	 * 
	 * @return
	 */
	public Integer getPerNightRate() {
		return perNightRate;
	}

	/**
	 * Sets Value of Per Night Rate
	 * 
	 * @param perNightRate
	 */
	public void setPerNightRate(Integer perNightRate) {
		this.perNightRate = perNightRate;
	}

	/**
	 * Gets Value of Availability
	 * 
	 * @return
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * Sets Value of Availability
	 * 
	 * @param availability
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/**
	 * Displays Details of Room Details Object
	 */
	@Override
	public String toString() {
		return "roomDetails [hotelId=" + hotelId + ", roomId=" + roomId
				+ ", roomNo=" + roomNo + ", roomType=" + roomType
				+ ", perNightRate=" + perNightRate + ", availability="
				+ availability + "]";
	}
}