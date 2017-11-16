package com.cg.hm.utility;

/**
 * Constant Values
 * 
 * @author rohitaku
 *
 */
public interface Constant {
	String ADMINID = "System";
	String ADMINPASS = "Capgemini123";
	String message = "message";
	String message2 = "message2";
	String INVALID = "Invalid Id or Password!!!";
	String HOTELADDED = "Hotel Added Successfully!!!";
	String ROOMADDED = "Room Added Successfully!!!";
	String NOROOM = "No Room Available in This Hotel";
	String ROOMDELETED = "Room Deleted Successfully!!!";
	String HOTELDELETED = "Hotel Deleted Successfully!!!";
	String HOTELMODIFIED = "Hotel Modified Successfully!!!";
	String ROOMMODIFIED = "Room Modified Successfully!!!";
	String NOROOMBOOKED = "No Room Booked in This Hotel";
	String[] DROPDOWNLIST = { "Select", "Standard non A/C room",
			"Standard A/C room", "Executive A/C room", "Deluxe A/C room" };
	String HOMEPAGE="Home";
	String ADMINPAGE="Admin";
	String LOGINPAGE="Login";
	String ADDHOTELPAGE="addHotel";
	String ADDROOMPAGE="addRoom";
	String HOTELLISTPAGE="HotelList";
	String DELETEROOMPAGE="deleteRoom";
	String DELETEHOTELPAGE="deleteHotel";
	String MODIFYROOMPAGE="modifyRoom";
	String MODIFYHOTELPAGE="modifyHotel";
	String BOOKINGDETAILSBYDATEPAGE="BookingDetailsByDate";
	String HOTELBOOKINGDETAILSPAGE="HotelBookingDetails";
	String HOTELGUESTLISTPAGE="HotelGuestList";
	
	String HOTELADDEDLOGGER="HotelDetails inserted successfully with Id-->";
	String ROOMADDEDLOGGER="RoomDetails inserted successfully with Id-->";
	String HOTELLISTLOGGER="Hotel list is retrieved successfully";
	String ROOMLISTROOMIDLOGGER="Room Details retrieved successfully for RoomID->>>>>";
	String HOTELLISTHOTELIDLOGGER="Hotel Details retrieved successfully for HotelID->>>>>";
	String ROOMLISTHOTELIDLOGGER="Room List retrieved successfully for HotelID->>>>>";
	String ROOMLISTLOGGER="Room List retrieved successfully ";
	String ROOMDELETELOGGER="Room Deleted successfully with ID ->>>>";
	String HOTELDELETELOGGER="Hotel Deleted successfully with ID ->>>>";
	String HOTELUPDATELOGGER="Hotel details updated successfully for HotelID->>>";
	String ROOMUPDATELOGGER="Room details updated successfully for RoomID->>>";
	String BOOKINGDETAILSLOGGER="Booking Details retrieved successfully for Date->>>>>";
	String BOOKINGDETAILSHOTELIDLOGGER="Booking Details retrieved successfully for HotelID->>>>>";
	String USERLISTHOTELIDLOGGER="USER List Details retrieved successfully for HotelID->>>>>";
	String USERLISTUSERIDLOGGER="USER Details retrieved successfully for UserID->>>>>";
	String NOUSERLOGGER="No Users for hotel with hotelID->>>>";
	
	String HOME="/home.htm";
	String ADMIN="/admin.htm";
	String LOGIN="/login.htm";
	String CHECKLOGIN="/checkLogin.htm";
	String LOGOUT="/logout.htm";
	String ADDHOTEL="/addHotel.htm";
	String ADDHOTELIMPL="/addHotelImpl.htm";
	String ADDROOM="/addRoom.htm";
	String ADDROOMIMPL="/addRoomImpl.htm";
	String VIEWHOTELS="/viewHotels.htm";
	String VIEWROOM="/viewRoom.htm";
	String DELETEROOM="/deleteRoom.htm";
	String DELETEROOMCONFIRM="/deleteRoomConfirm.htm";
	String DELETEROOMIMPL="/deleteRoomImpl.htm";
	String DELETEHOTEL="/deleteHotel.htm";
	String DELETEHOTELCONFIRM="/deleteHotelConfirm.htm";
	String DELETEHOTELIMPL="/deleteHotelImpl.htm";
	String MODIFYHOTEL="/modifyHotel.htm";
	String MODIFYHOTELIMPL="/modifyHotelImpl.htm";
	String MODIFYROOM="/modifyRoom.htm";
	String MODIFYROOMIMPL="/modifyRoomImpl.htm";
	String VIEWBOOKINGSONDATE="/viewBookingsOnDate.htm";
	String VIEWBOOKINGSONDATESPECIFIED="/viewBookingsOnDateSpecified.htm";
	String VIEWBOOKINGSOFHOTEL="/viewBookingsOfHotel";
	String VIEWGUESTLIST="/viewGuestList.htm";
	
	
}
