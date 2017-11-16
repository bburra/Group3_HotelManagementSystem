package com.cg.hm.dao;

public interface QueryMapper {
	
	public static String viewAllHotels="SELECT hotels FROM Hotel hotels";
	public static String getRoomByHotelId="SELECT r from RoomDetail r where r.hotelId=:p";
	public static String viewAllRooms="SELECT r from RoomDetail r";
	public static String deleteRoom="DELETE FROM RoomDetail h WHERE h.roomId =:p";
	public static String deleteHotel="DELETE FROM Hotel h WHERE h.hotelId =:p";
	public static String viewBookingDetailsFromDate="SELECT bkd FROM BookingDetail bkd WHERE bkd.bookedFrom <=TO_DATE(:dateS,'yyyy-mm-dd') and bkd.bookedTo>=TO_DATE(:dateS,'yyyy-mm-dd')";
	public static String viewBookingSpecificHotel="SELECT bdetails FROM BookingDetail bdetails WHERE bdetails.hotelId=:hotelId";
	public static String viewGuestListSpecificHotels="SELECT guestList.userId FROM BookingDetail guestList WHERE hotelId =:hotelId";
	public static String  viewGuestListSpecificHotels2="SELECT gList FROM UserDetail gList WHERE userId=:uId";
}
