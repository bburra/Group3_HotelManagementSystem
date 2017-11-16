package com.cg.hm.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hm.dto.BookingDetail;
import com.cg.hm.dto.Hotel;
import com.cg.hm.dto.RoomDetail;
import com.cg.hm.dto.UserDetail;
import com.cg.hm.exception.HotelManagementException;
import com.cg.hm.utility.Constant;

/**
 * 
 * @author rohitaku
 *
 */
@Repository
@Transactional
public class HotelDaoImpl implements HotelDao {
	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager entityManager;
	/**
	 * 
	 */
	private static Logger logger = Logger
			.getLogger(com.cg.hm.dao.HotelDaoImpl.class);

	/**
	 * Adds Hotel to DataBase
	 * 
	 * @param hotelDetails
	 *            :Hotel Object which is to be Added
	 * @throws HotelManagementException
	 */
	@Override
	public void addHotel(Hotel hotelDetails) throws HotelManagementException {
		try {
			entityManager.persist(hotelDetails);
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
		logger.info(Constant.HOTELADDEDLOGGER + hotelDetails.getHotelId());
	}

	/**
	 * Adds Room to DataBase
	 * 
	 * @param roomDetails
	 *            :Room Object which is to be Added
	 * @throws HotelManagementException
	 */
	@Override
	public void addRoom(RoomDetail roomDetails) throws HotelManagementException {
		try {
			entityManager.persist(roomDetails);
			logger.info(Constant.ROOMADDEDLOGGER
					+ roomDetails.getRoomId());
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
	}

	/**
	 * Retrieves List of hotels from DataBase
	 * 
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public List<Hotel> viewAllHotels() throws HotelManagementException {
		try {
			TypedQuery<Hotel> query = entityManager.createQuery(
					QueryMapper.viewAllHotels, Hotel.class);
			List<Hotel> hotels = query.getResultList();
			logger.info(Constant.HOTELLISTLOGGER);
			return hotels;
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
	}

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
		try {
			RoomDetail room = entityManager.find(RoomDetail.class, roomId);
			logger.info(Constant.ROOMLISTROOMIDLOGGER
					+ roomId);
			return room;
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
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
		try {
			Hotel hotel = entityManager.find(Hotel.class, hotelId);
			logger.info(Constant.HOTELLISTHOTELIDLOGGER
					+ hotelId);
			return hotel;
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
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
		try {
			TypedQuery<RoomDetail> querry = entityManager.createQuery(
					QueryMapper.getRoomByHotelId, RoomDetail.class);
			querry.setParameter("p", hotelId);
			List<RoomDetail> rooms = querry.getResultList();
			logger.info(Constant.ROOMLISTHOTELIDLOGGER
					+ hotelId);
			return rooms;
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
	}

	/**
	 * Retrieves List of Rooms
	 * 
	 * @return
	 * @throws HotelManagementException
	 */
	@Override
	public List<RoomDetail> viewAllRooms() throws HotelManagementException {
		try {
			TypedQuery<RoomDetail> querry = entityManager.createQuery(
					QueryMapper.viewAllRooms, RoomDetail.class);
			List<RoomDetail> rooms = querry.getResultList();
			logger.info(Constant.ROOMLISTLOGGER);
			return rooms;
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
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
		try {
			Query query = entityManager.createQuery(QueryMapper.deleteRoom);
			query.setParameter("p", roomID).executeUpdate();
			logger.info(Constant.ROOMDELETELOGGER + roomID);
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
	}

	/**
	 * Deletes Hotel from DataBase
	 * 
	 * @param hotelId
	 *            :Hotel ID of Hotel which is to be Deleted
	 * @throws HotelManagementException
	 */
	@Override
	public void deleteHotel(int hId) throws HotelManagementException {
		try {
			Query query = entityManager.createQuery(QueryMapper.deleteHotel);
			query.setParameter("p", hId).executeUpdate();
			logger.info(Constant.HOTELDELETELOGGER + hId);
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
	}

	/**
	 * Updates Hotel Details in DataBase
	 * 
	 * @param hotelDetails
	 *            :Hotel Object which is to be Modified
	 * @throws HotelManagementException
	 */
	@Override
	public void updateHotel(Hotel hotelDetails) throws HotelManagementException {
		try {
			entityManager.merge(hotelDetails);
			logger.info(Constant.HOTELUPDATELOGGER + hotelDetails.getHotelId());
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
	}

	/**
	 * Updates Room Details in DataBase
	 * 
	 * @param roomDetails
	 *            :Room Object which is to be Modified
	 * @throws HotelManagementException
	 */
	@Override
	public void updateRoom(RoomDetail roomDetails)
			throws HotelManagementException {
		try {
			entityManager.merge(roomDetails);
			logger.info(Constant.ROOMUPDATELOGGER + roomDetails.getRoomId());
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
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
	public List<BookingDetail> viewBookingDetailsFromDate(Date date2)
			throws HotelManagementException {
		try {
			String date;
			date = date2.toString();
			List<BookingDetail> bookingDetails = new ArrayList<BookingDetail>();
			TypedQuery<BookingDetail> quer = entityManager
					.createQuery(QueryMapper.viewBookingDetailsFromDate,
							BookingDetail.class);
			quer.setParameter("dateS", date);
			bookingDetails = quer.getResultList();
			logger.info(Constant.BOOKINGDETAILSLOGGER + date2);
			return bookingDetails;
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
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
			throws HotelManagementException {
		try {
			TypedQuery<BookingDetail> query = entityManager.createQuery(
					QueryMapper.viewBookingSpecificHotel, BookingDetail.class);
			query.setParameter("hotelId", hotelId);
			List<BookingDetail> books = query.getResultList();
			logger.info(Constant.BOOKINGDETAILSHOTELIDLOGGER + hotelId);
			return books;
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
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
	public List<UserDetail> viewGuestListSpecificHotels(int hotelId)
			throws HotelManagementException {
		try {
			TypedQuery<Integer> query = entityManager.createQuery(
					QueryMapper.viewGuestListSpecificHotels, Integer.class);
			query.setParameter("hotelId", hotelId);
			List<Integer> uIDList = query.getResultList();
			logger.info(Constant.USERLISTHOTELIDLOGGER + hotelId);
			if (!uIDList.isEmpty()) {
				List<UserDetail> list = new ArrayList<>();
				for (int uId : uIDList) {
					TypedQuery<UserDetail> querry = entityManager.createQuery(
							QueryMapper.viewGuestListSpecificHotels2,
							UserDetail.class);
					querry.setParameter("uId", uId);
					UserDetail user = querry.getSingleResult();
					logger.info(Constant.USERLISTUSERIDLOGGER + uId);
					list.add(user);
				}
				return list;
			}
			logger.info(Constant.NOUSERLOGGER + hotelId);
			return null;
		} catch (Exception exception) {
			throw new HotelManagementException(exception.getMessage());
		}
	}
}
