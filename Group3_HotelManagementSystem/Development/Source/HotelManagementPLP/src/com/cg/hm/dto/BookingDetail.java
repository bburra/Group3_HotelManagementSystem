package com.cg.hm.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Booking_Details Table
 * 
 * @author rohitaku
 *
 */
@Entity
@Table(name = "booking_details")
public class BookingDetail {
	/**
	 * Booking ID
	 */
	@Id
	@Column(name = "booking_id")
	private int bookingId;
	/**
	 * Hotel ID
	 */
	@Column(name = "hotel_id")
	private int hotelId;
	/**
	 * Room ID
	 */
	@Column(name = "room_id")
	private int roomId;
	/**
	 * User ID
	 */
	@Column(name = "user_id")
	private int userId;
	/**
	 * BookedFrom
	 */
	@Column(name = "booked_from")
	private Date bookedFrom;
	/**
	 * BookedTo
	 */
	@Column(name = "booked_to")
	private Date bookedTo;
	/**
	 * Number of Adults
	 */
	@Column(name = "no_of_adults")
	private int noOfAdults;
	/**
	 * Number of Children
	 */
	@Column(name = "no_of_children")
	private int noOfChildren;
	/**
	 * Amount
	 */
	@Column(name = "amount")
	private int amount;

	/**
	 * Default Constructor
	 */
	public BookingDetail() {
		super();
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param bookingId
	 * @param hotelId
	 * @param roomId
	 * @param userId
	 * @param bookedFrom
	 * @param bookedTo
	 * @param noOfAdults
	 * @param noOfChildren
	 * @param amount
	 */
	public BookingDetail(int bookingId, int hotelId, int roomId, int userId,
			Date bookedFrom, Date bookedTo, int noOfAdults, int noOfChildren,
			int amount) {
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
	}

	/**
	 * Gets Value of Booking ID
	 * 
	 * @return
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * Sets Value of Booking ID
	 * 
	 * @param bookingId
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * Gets Value of Hotel ID
	 * 
	 * @return
	 */
	public int getHotelId() {
		return hotelId;
	}

	/**
	 * Sets Value of Hotel ID
	 * 
	 * @param hotelId
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * Gets Value of Room ID
	 * 
	 * @return
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * Sets Value of Room ID
	 * 
	 * @param roomId
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
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
	 * Gets Value of BookedFrom
	 * 
	 * @return
	 */
	public Date getBookedFrom() {
		return bookedFrom;
	}

	/**
	 * Sets Value of BookedFrom
	 * 
	 * @param bookedFrom
	 */
	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	/**
	 * Gets Value of BookedTo
	 * 
	 * @return
	 */
	public Date getBookedTo() {
		return bookedTo;
	}

	/**
	 * Sets Value of BookedTo
	 * 
	 * @param bookedTo
	 */
	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	/**
	 * Gets Value of Number of Adults
	 * 
	 * @return
	 */
	public int getNoOfAdults() {
		return noOfAdults;
	}

	/**
	 * Sets Value of Number of Adults
	 * 
	 * @param noOfAdults
	 */
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	/**
	 * Gets Value of Number of Children
	 * 
	 * @return
	 */
	public int getNoOfChildren() {
		return noOfChildren;
	}

	/**
	 * Sets Value of Number of Children
	 * 
	 * @param noOfChildren
	 */
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	/**
	 * Gets Value of Amount
	 * 
	 * @return
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets Value of Amount
	 * 
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Displays Value of BookingDetails Object
	 */
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", hotelId="
				+ hotelId + ", roomId=" + roomId + ", userId=" + userId
				+ ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo
				+ ", noOfAdults=" + noOfAdults + ", noOfChildren="
				+ noOfChildren + ", amount=" + amount + "]";
	}
}
