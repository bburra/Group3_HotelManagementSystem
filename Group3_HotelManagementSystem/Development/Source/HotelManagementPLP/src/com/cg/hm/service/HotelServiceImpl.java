package com.cg.hm.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hm.dao.HotelDao;
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
@Service
public class HotelServiceImpl implements HotelService {
	/**
	 * 
	 */
	@Autowired
	HotelDao hotelDao;

	/**
	 * Retrieves Room by Room ID
	 * 
	 * @param roomId
	 *            :Room ID of Room which is to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public RoomDetail getRoomById(int roomId) throws HotelManagementException {
		return hotelDao.getRoomById(roomId);
	}

	/**
	 * Retrieves Hotel by Hotel ID
	 * 
	 * @param hotelId
	 *            :Hotel ID of Hotel which is to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public Hotel getHotelById(int hotelId) throws HotelManagementException {
		return hotelDao.getHotelById(hotelId);
	}

	/**
	 * Retrieves List of Rooms in a Hotel
	 * 
	 * @param hotelId
	 *            :Hotel ID of Hotel for which Rooms are to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public List<RoomDetail> getRoomByHotelId(int hotelId)
			throws HotelManagementException {
		return hotelDao.getRoomByHotelId(hotelId);
	}

	/**
	 * Retrieves List of hotels from DataBase
	 * 
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public List<Hotel> viewAllHotels() throws HotelManagementException {
		return hotelDao.viewAllHotels();
	}

	/**
	 * Adds Hotel to DataBase
	 * 
	 * @param hotelDetails
	 *            :Hotel Object which is to be Added
	 * @throws HotelManagementException
	 */
	@Override
	public void addHotel(Hotel hotel) throws HotelManagementException {
		hotelDao.addHotel(hotel);
	}

	/**
	 * Deletes Hotel from DataBase
	 * 
	 * @param hotelId
	 *            :Hotel ID of Hotel which is to be Deleted
	 * @throws HotelManagementException
	 */
	@Override
	public void deleteHotel(int hotelID) throws HotelManagementException {
		hotelDao.deleteHotel(hotelID);
	}

	/**
	 * Deletes Room from DataBase
	 * 
	 * @param roomId
	 *            :Room ID of Room which is to be Deleted
	 * @throws HotelManagementException
	 */
	@Override
	public void deleteRoom(int roomID) throws HotelManagementException {
		hotelDao.deleteRoom(roomID);
	}

	/**
	 * Adds Room to DataBase
	 * 
	 * @param roomDetails
	 *            :Room Object which is to be Added
	 * @throws HotelManagementException
	 */
	@Override
	public void addRoom(RoomDetail rDetails) throws HotelManagementException {
		hotelDao.addRoom(rDetails);
	}

	/**
	 * Retrieves List of Rooms
	 * 
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public List<RoomDetail> viewAllRooms() throws HotelManagementException {
		return hotelDao.viewAllRooms();
	}

	/**
	 * Retrieves Booking Details on a Date
	 * 
	 * @param date
	 *            :Date on which Booking Details are to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public List<BookingDetail> viewBookingDetailsFromDate(Date date)
			throws HotelManagementException {
		return hotelDao.viewBookingDetailsFromDate(date);
	}

	/**
	 * Updates Hotel Details in DataBase
	 * 
	 * @param hotelDetails
	 *            :Hotel Object which is to be Modified
	 * @throws HotelManagementException
	 */
	@Override
	public void updateHotel(Hotel hotel) throws HotelManagementException {
		hotelDao.updateHotel(hotel);
	}

	/**
	 * Updates Room Details in DataBase
	 * 
	 * @param roomDetails
	 *            :Room Object which is to be Modified
	 * @throws HotelManagementException
	 */
	@Override
	public void updateRoom(RoomDetail rDetails) throws HotelManagementException {
		hotelDao.updateRoom(rDetails);
	}

	/**
	 * Retrieves Book Details of a Hotel
	 * 
	 * @param hotelId
	 *            :Hotel ID of Hotel for which Booking Details are to be
	 *            Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public List<BookingDetail> viewBookingSpecificHotel(int hotelId)
			throws HotelManagementException { // neha
		return hotelDao.viewBookingSpecificHotel(hotelId);
	}

	/**
	 * Retrieves Guest List of a Hotel
	 * 
	 * @param hotelId
	 *            :Hotel ID of a Hotel for which Guest List is to be Retrieved
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public List<UserDetail> viewGuestListSpecificHotels(int hotellId)
			throws HotelManagementException { // neha
		return hotelDao.viewGuestListSpecificHotels(hotellId);
	}
}
