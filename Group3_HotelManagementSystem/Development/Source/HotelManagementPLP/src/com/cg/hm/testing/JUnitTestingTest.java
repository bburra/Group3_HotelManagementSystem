package com.cg.hm.testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import com.cg.hm.dao.HotelDao;
import com.cg.hm.dto.Hotel;
import com.cg.hm.dto.RoomDetail;
import com.cg.hm.exception.HotelManagementException;
import com.cg.hm.service.HotelService;
import com.cg.hm.service.HotelServiceImpl;

/**
 * @author bburra
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class JUnitTestingTest {
	/**
	 * 
	 */
	@Mock
	private HotelDao dao;
	/**
	 * 
	 */
	@InjectMocks
	private HotelService hotelServiceImpl = new HotelServiceImpl();
	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * 
	 */
	private Hotel hotel1;
	/**
	 * 
	 */
	private RoomDetail room1;
	/**
	 * Creates Hotel Object
	 * 
	 * @return
	 */
	private Hotel createHotel() {

		hotel1 = new Hotel();
		hotel1.setCity("Italy");
		hotel1.setAddress("StarHills");
		hotel1.setDescription("ACDouble");
		hotel1.setAvgRatePerNight(5000);
		hotel1.setEmail("bhu@gmail.com");
		hotel1.setFax("98563");
		hotel1.setHotelName("StarHills");
		hotel1.setPhone1("9845632147");
		hotel1.setPhone2("9745632815");
		hotel1.setRating(3); 
		return hotel1;
}	/**
	 * Creates RoomDetail Object
	 * 
	 * @return
	 */
	private RoomDetail createRoom() {
		room1 = new RoomDetail();
		room1.setAvailability("YES");
		room1.setHotelId(123);
		room1.setPerNightRate(4500);
		room1.setRoomNo("556");
		room1.setRoomType("Standard A/C room");
		return room1;
	}
	/**
	 * Tests getRoomByID method of DAO
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetRoomkById() throws Exception {
		int roomId = 11;
		RoomDetail room2 = new RoomDetail();
		room2.setRoomId(roomId);
		stub(dao.getRoomById(roomId)).toReturn(room2);
		assertEquals(room2, hotelServiceImpl.getRoomById(roomId));
		verify(dao).getRoomById(roomId);
	}
	/**
	 * Tests GetHotelById method of DAO
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetHotelById() throws Exception {
		int hotelId = 123;
		Hotel hotelObj = new Hotel();
		hotelObj.setHotelId(hotelId);
		stub(dao.getHotelById(hotelId)).toReturn(hotelObj);
		assertEquals(hotelObj, hotelServiceImpl.getHotelById(hotelId));
		verify(dao).getHotelById(hotelId);
	}
	/**
	 * Tests ViewAllHotels method of DAO
	 * 
	 * @throws HotelManagementException
	 */
	@Test
	public void testViewAllHotels() throws HotelManagementException {

		Hotel hotel = createHotel();
		hotel.setHotelId(123);
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(hotel);
		stub(dao.viewAllHotels()).toReturn(hotels);
		assertEquals(hotels, hotelServiceImpl.viewAllHotels());
		verify(dao).viewAllHotels();
	}

	/**
	 * Tests ViewAllRooms method of DAO
	 * 
	 * @throws HotelManagementException
	 */
	
	@Test
	public void testViewAllRooms() throws HotelManagementException {

		RoomDetail room = createRoom();
		room.setRoomId(456);
		List<RoomDetail> rooms = new ArrayList<RoomDetail>();
		rooms.add(room);
		stub(dao.viewAllRooms()).toReturn(rooms);
		assertEquals(rooms, hotelServiceImpl.viewAllRooms());
		verify(dao).viewAllRooms();
	}

	/**
	 * Tests GetRoomsByHotelId method of DAO
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetRoomsByHotelId() throws Exception {

		int hotelId = 123;
		RoomDetail room = createRoom();
		room.setRoomId(456);
		List<RoomDetail> rooms = new ArrayList<RoomDetail>();
		rooms.add(room);
		stub(dao.getRoomByHotelId(hotelId)).toReturn(rooms);
		assertEquals(rooms, hotelServiceImpl.getRoomByHotelId(hotelId));
		verify(dao).getRoomByHotelId(hotelId);
	}

}
