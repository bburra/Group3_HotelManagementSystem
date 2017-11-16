package com.cg.hm.service;

import java.sql.Date;
import java.util.List;

import com.cg.hm.dto.BookingDetail;
import com.cg.hm.dto.Hotel;
import com.cg.hm.dto.RoomDetail;
import com.cg.hm.dto.UserDetail;
import com.cg.hm.exception.HotelManagementException;

/**
 * 
 * @author rohitaku
 *
 */
public interface HotelService {
	/**
	 * Adds Hotel to DataBase
	 * 
	 * @param hotelDetails
	 *            :Hotel Object which is to be Added
	 * @throws HotelManagementException
	 */
	void addHotel(Hotel hotel) throws HotelManagementException;

	/**
	 * Adds Room to DataBase
	 * 
	 * @param roomDetails
	 *            :Room Object which is to be Added
	 * @throws HotelManagementException
	 */
	void addRoom(RoomDetail rDetails) throws HotelManagementException;

	/**
	 * Deletes Hotel from DataBase
	 * 
	 * @param hotelId
	 *            :Hotel ID of Hotel which is to be Deleted
	 * @throws HotelManagementException
	 */
	void deleteHotel(int hotelID) throws HotelManagementException;

	/**
	 * Deletes Room from DataBase
	 * 
	 * @param roomId
	 *            :Room ID of Room which is to be Deleted
	 * @throws HotelManagementException
	 */
	void deleteRoom(int roomID) throws HotelManagementException;

	/**
	 * Updates Hotel Details in DataBase
	 * 
	 * @param hotelDetails
	 *            :Hotel Object which is to be Modified
	 * @throws HotelManagementException
	 */
	void updateHotel(Hotel hotel) throws HotelManagementException;

	/**
	 * Updates Room Details in DataBase
	 * 
	 * @param roomDetails
	 *            :Room Object which is to be Modified
	 * @throws HotelManagementException
	 */
	void updateRoom(RoomDetail rDetails) throws HotelManagementException;

	/**
	 * Retrieves List of hotels from DataBase
	 * 
	 * @return
	 * @throws HotelManagementException
	 */
	List<Hotel> viewAllHotels() throws HotelManagementException;

	/**
	 * Retrieves List of Rooms
	 * 
	 * @return
	 * @throws HotelManagementException
	 */
	List<RoomDetail> viewAllRooms() throws HotelManagementException;

	/**
	 * Retrieves Room by Room ID
	 * 
	 * @param roomId
	 *            :Room ID of Room which is to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	RoomDetail getRoomById(int roomId) throws HotelManagementException;

	/**
	 * Retrieves Hotel by Hotel ID
	 * 
	 * @param hotelId
	 *            :Hotel ID of Hotel which is to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	Hotel getHotelById(int hotelId) throws HotelManagementException;

	/**
	 * Retrieves List of Rooms in a Hotel
	 * 
	 * @param hotelId
	 *            :Hotel ID of Hotel for which Rooms are to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	List<RoomDetail> getRoomByHotelId(int hotelId)
			throws HotelManagementException;

	/**
	 * Retrieves Booking Details on a Date
	 * 
	 * @param date
	 *            :Date on which Booking Details are to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	List<BookingDetail> viewBookingDetailsFromDate(Date date)
			throws HotelManagementException;

	/**
	 * Retrieves Book Details of a Hotel
	 * 
	 * @param hotelId
	 *            :Hotel ID of Hotel for which Booking Details are to be
	 *            Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	List<BookingDetail> viewBookingSpecificHotel(int hotelId)
			throws HotelManagementException;

	/**
	 * Retrieves Guest List of a Hotel
	 * 
	 * @param hotelId
	 *            :Hotel ID of a Hotel for which Guest List is to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	List<UserDetail> viewGuestListSpecificHotels(int hotellId)
			throws HotelManagementException;
}
