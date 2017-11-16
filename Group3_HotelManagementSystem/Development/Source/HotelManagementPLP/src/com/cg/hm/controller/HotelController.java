package com.cg.hm.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.cg.hm.dto.Admin;
import com.cg.hm.dto.BookingDetail;
import com.cg.hm.dto.Hotel;
import com.cg.hm.dto.RoomDetail;
import com.cg.hm.dto.UserDetail;
import com.cg.hm.exception.HotelManagementException;
import com.cg.hm.service.HotelService;
import com.cg.hm.utility.Constant;

/**
 * controller
 * 
 * @author rohitaku
 *
 */
@Controller
@SessionAttributes("admin")
public class HotelController {
	@Autowired
	HotelService hotelService;

	/**
	 * Redirects to Home.jsp
	 * 
	 * @return
	 */
	@RequestMapping(Constant.HOME)
	public String redirectToHome() {
		return Constant.HOMEPAGE;
	}

	/**
	 * Redirects to Admin.jsp
	 * 
	 * @return
	 */
	@RequestMapping(Constant.ADMIN)
	public String redirectToAdmin() {
		return Constant.ADMINPAGE;
	}

	/**
	 * Redirects to Login.jsp
	 * 
	 * @return
	 */
	@RequestMapping(Constant.LOGIN)
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		return Constant.LOGINPAGE;
	}

	/**
	 * Validates Login Credentials
	 * 
	 * @param id
	 *            : Login ID
	 * @param password
	 *            :Login Password
	 * @param model
	 *            :Contains Invalid Login Message
	 * @return
	 */
	@RequestMapping(value = Constant.CHECKLOGIN, method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("admin") Admin admin, Model model,
			BindingResult resultl) {
		if (Constant.ADMINID.equals(admin.getId())
				&& Constant.ADMINPASS.equals(admin.getPassword()))
			return Constant.ADMINPAGE;
		model.addAttribute("message", Constant.INVALID);
		model.addAttribute("admin", new Admin());
		return Constant.LOGINPAGE;
	}

	/**
	 * Logout
	 * 
	 * @param model
	 * @param status
	 * @return
	 */
	@RequestMapping(Constant.LOGOUT)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		return Constant.HOMEPAGE;
	}

	/**
	 * Redirects to addHotel.jsp
	 * 
	 * @param model
	 *            : Contains Empty Hotel Object
	 * @return
	 */
	@RequestMapping(Constant.ADDHOTEL)
	public String addHotel(Model model) {
		Hotel hotel = new Hotel();
		model.addAttribute("hotel", hotel);
		return Constant.ADDHOTELPAGE;
	}

	/**
	 * Adds Hotel to DataBase and Redirects to Admin.jsp
	 * 
	 * @param model
	 *            : Contains addHotel Success Message
	 * @param hotel
	 *            : Hotel Object to be Added
	 * @param result
	 * @return
	 */
	@RequestMapping(value = Constant.ADDHOTELIMPL, method = RequestMethod.POST)
	public String addHotelImpl(Model model,
			@ModelAttribute("hotel") @Valid Hotel hotel, BindingResult result) {
		try {
			if (result.hasErrors())
				return Constant.ADDHOTELPAGE;
			hotelService.addHotel(hotel);
			model.addAttribute("message", Constant.HOTELADDED);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.ADMINPAGE;
	}

	/**
	 * Redirects to addRoom.jsp
	 * 
	 * @param hotelId
	 *            : Hotel ID of Room
	 * @param model
	 *            : Contains Hotel List and Hotel Id in which Room is to be
	 *            Added
	 * @param model2
	 *            : Contains Empty Room Object and Room Type List
	 * @return
	 */
	@RequestMapping(Constant.ADDROOM)
	public String addRoom(@RequestParam("hotelId") int hotelId, Model model,
			Model model2) {
		List<Hotel> list = null;
		try {
			list = hotelService.viewAllHotels();
			model2.addAttribute("list", list);
			model2.addAttribute("hotelId", hotelId);
			RoomDetail room = new RoomDetail();
			model.addAttribute("room", room);
			model.addAttribute("roomTypeList", Constant.DROPDOWNLIST);

		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.ADDROOMPAGE;
	}

	/**
	 * Adds Room to DataBase
	 * 
	 * @param hotelId
	 *            :Hotel ID of Room
	 * @param model
	 *            :Contains addRoom Success Message and Room Type List
	 * @param model2
	 *            :Contains Hotel List and Hotel ID in which Room is to be Added
	 * @param room
	 *            :Room Object Which is to be Added
	 * @param result
	 * @return
	 */
	@RequestMapping(value = Constant.ADDROOMIMPL, method = RequestMethod.POST)
	public String addRoomImpl(@RequestParam("hotelId") int hotelId,
			Model model, Model model2,
			@ModelAttribute("room") @Valid RoomDetail room, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<Hotel> list = null;
				list = hotelService.viewAllHotels();
				if (list.isEmpty())
					list = null;
				model2.addAttribute("list", list);
				model2.addAttribute("hotelId", hotelId);
				model.addAttribute("room", room);
				model.addAttribute("roomTypeList", Constant.DROPDOWNLIST);
				return Constant.ADDROOMPAGE;
			}
			hotelService.addRoom(room);
			model.addAttribute("message", Constant.ROOMADDED);
		} catch (HotelManagementException e) {
			System.out.println("Exception Put Details Properly");
		}
		return Constant.ADMINPAGE;
	}

	/**
	 * Retrieves List of Hotels
	 * 
	 * @param model
	 *            : Contains List of Hotels
	 * @return
	 */
	@RequestMapping(Constant.VIEWHOTELS)
	public String viewHotels(Model model) {
		List<Hotel> list = null;
		try {
			list = hotelService.viewAllHotels();
			model.addAttribute("hotelId", 0);
			model.addAttribute("list", list);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.HOTELLISTPAGE;
	}

	/**
	 * Retrieve List of Rooms for a Particular Hotel
	 * 
	 * @param hotelId
	 *            : Hotel ID For Retrieving Room List
	 * @param model
	 *            :Contains Hotel List and Room List
	 * @return
	 */
	@RequestMapping(Constant.VIEWROOM)
	public String viewRoom(@RequestParam("hotelId") int hotelId, Model model) {
		List<Hotel> list = null;
		List<RoomDetail> list2 = null;
		try {
			list = hotelService.viewAllHotels();
			model.addAttribute("list", list);
			String msg = new String("Rooms in Hotel with Hotel ID: " + hotelId);
			list2 = hotelService.getRoomByHotelId(hotelId);
			model.addAttribute("hotelId", hotelId);
			if (list2.isEmpty()) {
				list2 = null;
				model.addAttribute("message2", Constant.NOROOM);
			}
			model.addAttribute("list2", list2);
			model.addAttribute("message", msg);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.HOTELLISTPAGE;
	}

	/**
	 * Retrieves Room List and Redirects to deleteRoom.jsp
	 * 
	 * @param model
	 *            : Contains List of Hotels
	 * @return
	 */
	@RequestMapping(Constant.DELETEROOM)
	public String deleteRoom(Model model) {
		List<RoomDetail> list = null;
		try {
			list = hotelService.viewAllRooms();
			if (list.isEmpty())
				list = null;
			model.addAttribute("list", list);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.DELETEROOMPAGE;
	}

	/**
	 * Confirms Delete Room Operation
	 * 
	 * @param roomId
	 *            : Room ID of Room which is to be Deleted
	 * @param model
	 *            : Contains List of Rooms
	 * @param model2
	 *            : Contains Room Details which is to be Deleted
	 * @return
	 */
	@RequestMapping(Constant.DELETEROOMCONFIRM)
	public String deleteRoomConfirm(@RequestParam("hiddenRoomId") int roomId,
			Model model, Model model2) {
		List<RoomDetail> list = null;
		RoomDetail room = null;
		try {
			list = hotelService.viewAllRooms();
			model.addAttribute("list", list);
			room = hotelService.getRoomById(roomId);
			model2.addAttribute("room", room);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.DELETEROOMPAGE;
	}

	/**
	 * Deletes Room from DataBase
	 * 
	 * @param roomId
	 *            :Room ID of Room which is to be Deleted
	 * @param model
	 *            : Contains Successful Deletion Message
	 * @return
	 */
	@RequestMapping(Constant.DELETEROOMIMPL)
	public String deleteRoomImpl(@RequestParam("hiddenRoomId") int roomId,
			Model model) {
		try {
			hotelService.deleteRoom(roomId);
			model.addAttribute("message", Constant.ROOMDELETED);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.ADMINPAGE;
	}

	/**
	 * Retrieves List of Hotels and Redirects to deleteHotel.jsp
	 * 
	 * @param model
	 *            : Contains List of Hotels
	 * @return
	 */
	@RequestMapping(Constant.DELETEHOTEL)
	public String deleteHotel(Model model) {
		List<Hotel> list = null;
		try {
			list = hotelService.viewAllHotels();
			if (list.isEmpty())
				list = null;
			model.addAttribute("list", list);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.DELETEHOTELPAGE;
	}

	/**
	 * Confirms Deletion Operation
	 * 
	 * @param hotelId
	 *            : Hotel ID of Hotel which is to be Deleted
	 * @param model
	 *            : Contains List of Hotels
	 * @param model2
	 *            : Contains Details of Hotel which is to be Deleted
	 * @return
	 */
	@RequestMapping(Constant.DELETEHOTELCONFIRM)
	public String deleteHotelConfirm(
			@RequestParam("hiddenHotelId") int hotelId, Model model,
			Model model2) {
		List<Hotel> list = null;
		Hotel hotel = null;
		try {
			list = hotelService.viewAllHotels();
			hotel = hotelService.getHotelById(hotelId);
			model.addAttribute("list", list);
			model2.addAttribute("hotel", hotel);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.DELETEHOTELPAGE;
	}

	/**
	 * Deletes Hotel from DataBase
	 * 
	 * @param hotelId
	 *            : Hotel ID of Hotel which is to be Deleted
	 * @param model
	 *            : Contains Successful Deletion Message
	 * @return
	 */
	@RequestMapping(Constant.DELETEHOTELIMPL)
	public String deleteHotelImpl(@RequestParam("hiddenHotelId") int hotelId,
			Model model) {
		try {
			hotelService.deleteHotel(hotelId);
			model.addAttribute("message", Constant.HOTELDELETED);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.ADMINPAGE;
	}

	/**
	 * Retrieves List of Hotels and Details of Hotel which is to be Modified
	 * 
	 * @param hotelId
	 *            : Hotel ID of Hotel which is to be Modified
	 * @param model
	 *            : Contains List of Hotels and Details of Hotel which is to be
	 *            Modified
	 * @return
	 */
	@RequestMapping(Constant.MODIFYHOTEL)
	public String modifyHotel(@RequestParam("hotelId") int hotelId, Model model) {
		List<Hotel> list = null;
		try {
			list = hotelService.viewAllHotels();
			Hotel hotel = new Hotel();
			if (hotelId != 0)
				hotel = hotelService.getHotelById(hotelId);
			model.addAttribute("hotel", hotel);
			if (list.isEmpty())
				list = null;
			model.addAttribute("hotelId", hotelId);
			model.addAttribute("list", list);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.MODIFYHOTELPAGE;
	}

	/**
	 * Modifies Hotel Details in DataBase
	 * 
	 * @param hotelId
	 *            : Hotel ID of Hotel which is to be Modified
	 * @param model
	 *            : Contains List of Hotels and Successful Modification Message
	 * @param hotel
	 *            : Hotel Object which is to be Modified
	 * @param result
	 * @return
	 */
	@RequestMapping(value =Constant.MODIFYHOTELIMPL, method = RequestMethod.POST)
	public String modifyHotelImpl(@RequestParam("hotelId") int hotelId,
			Model model, @ModelAttribute("hotel") @Valid Hotel hotel,
			BindingResult result) {
		if (result.hasErrors()) {
			List<Hotel> list = null;
			try {
				list = hotelService.viewAllHotels();
				model.addAttribute("hotel", hotel);
				if (list.isEmpty())
					list = null;
				model.addAttribute("hotelId", hotelId);
				model.addAttribute("list", list);
				return Constant.MODIFYHOTELPAGE;
			} catch (HotelManagementException e) {

				model.addAttribute("exceptionMessage", e.getMessage());
			}
		}
		try {
			hotelService.updateHotel(hotel);
			model.addAttribute("message", Constant.HOTELMODIFIED);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.ADMINPAGE;
	}

	/**
	 * Retrieves List of Rooms and Redirects to modifyRoom.jsp
	 * 
	 * @param roomId
	 *            : Room ID of Room which is to be Modified
	 * @param model
	 *            : Contains List of Rooms and Details of Rooms which is to be
	 *            Modified
	 * @return
	 */
	@RequestMapping(Constant.MODIFYROOM)
	public String modifyRoom(@RequestParam("roomId") int roomId, Model model) {
		List<RoomDetail> list = null;
		try {
			list = hotelService.viewAllRooms();
			if (list.isEmpty())
				list = null;
			RoomDetail room = new RoomDetail();
			if (roomId != 0)
				room = hotelService.getRoomById(roomId);
			model.addAttribute("room", room);
			model.addAttribute("roomId", roomId);
			model.addAttribute("list", list);
			model.addAttribute("roomTypeList", Constant.DROPDOWNLIST);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.MODIFYROOMPAGE;
	}

	/**
	 * Modifies Room Details in DataBase
	 * 
	 * @param roomId
	 *            : Room ID of Room which is to be Modified
	 * @param model
	 *            : Contains List of Rooms and Details of Room which is to be
	 *            Modified
	 * @param room
	 *            :Room Object which is to be Modified
	 * @param result
	 * @return
	 */
	@RequestMapping(value =Constant.MODIFYROOMIMPL, method = RequestMethod.POST)
	public String modifyRoomImpl(@RequestParam("roomId") int roomId,
			Model model, @ModelAttribute("room") @Valid RoomDetail room,
			BindingResult result) {
		if (result.hasErrors()) {
			List<RoomDetail> list = null;
			try {
				list = hotelService.viewAllRooms();
				if (list.isEmpty())
					list = null;
				model.addAttribute("room", room);
				model.addAttribute("roomId", roomId);
				model.addAttribute("list", list);
				model.addAttribute("roomTypeList", Constant.DROPDOWNLIST);
				return Constant.MODIFYROOMPAGE;
			} catch (HotelManagementException e) {

				model.addAttribute("exceptionMessage", e.getMessage());
			}
		}
		try {
			hotelService.updateRoom(room);
			model.addAttribute("message", Constant.ROOMMODIFIED);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.ADMINPAGE;
	}

	/**
	 * Retrieves Booking Details for Today
	 * 
	 * @param model
	 *            : Contains List of Booking Details for Today
	 * @return
	 */
	@RequestMapping(Constant.VIEWBOOKINGSONDATE)
	public String viewBookingsOnDate(Model model) {
		List<BookingDetail> list = null;
		try {
			LocalDate today = LocalDate.now();
			Date date = Date.valueOf(today);
			list = hotelService.viewBookingDetailsFromDate(date);
			if (list.isEmpty())
				list = null;
			model.addAttribute("message", "Today");
			model.addAttribute("list", list);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.BOOKINGDETAILSBYDATEPAGE;
	}

	/**
	 * Retrieves Booking Details for a Given Date
	 * 
	 * @param date
	 *            : Date on which Booking Details are to be Retrieved
	 * @param model
	 *            : Contains List of Booking Details on a Specific Date
	 * @return
	 */
	@RequestMapping(Constant.VIEWBOOKINGSONDATESPECIFIED)
	public String viewBookingsOnDateSpecified(@RequestParam("date") Date date,
			Model model) {
		List<BookingDetail> list = null;
		try {
			list = hotelService.viewBookingDetailsFromDate(date);
			if (list.isEmpty())
				list = null;
			model.addAttribute("item", "hi");
			model.addAttribute("message", date);
			model.addAttribute("list", list);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.BOOKINGDETAILSBYDATEPAGE;
	}

	/**
	 * Retrieves Booking Details for a Hotel
	 * 
	 * @param hotelId
	 *            : Hotel ID of Hotel for which Booking Details are to be
	 *            Retrieved
	 * @param model
	 *            : Contains List of Booking Details for a Hotel
	 * @return
	 */
	@RequestMapping(Constant.VIEWBOOKINGSOFHOTEL)
	public String viewBookingsOfHotel(@RequestParam("hotelId") int hotelId,
			Model model) {
		List<Hotel> list = null;
		List<BookingDetail> list2 = null;
		try {
			list = hotelService.viewAllHotels();
			if (list.isEmpty())
				list = null;
			list2 = hotelService.viewBookingSpecificHotel(hotelId);
			if (list2.isEmpty()) {
				list2 = null;
				model.addAttribute("message", Constant.NOROOMBOOKED);
			}
			model.addAttribute("hotelId", hotelId);
			model.addAttribute("list", list);
			model.addAttribute("list2", list2);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.HOTELBOOKINGDETAILSPAGE;
	}

	/**
	 * Retrieves Guest List of a Hotel
	 * 
	 * @param hotelId
	 *            : Hotel ID of a Hotel for which Guest List is to be Retrieved
	 * @param model
	 *            : Contains Guest List of the Hotel
	 * @return
	 */
	@RequestMapping(Constant.VIEWGUESTLIST)
	public String viewGuestList(@RequestParam("hotelId") int hotelId,
			Model model) {
		List<Hotel> list = null;
		List<UserDetail> list2 = null;
		try {
			list = hotelService.viewAllHotels();
			if (list.isEmpty())
				list = null;
			list2 = hotelService.viewGuestListSpecificHotels(hotelId);
			model.addAttribute("list", list);
			model.addAttribute("list2", list2);
			model.addAttribute("hotelId", hotelId);
		} catch (HotelManagementException e) {

			model.addAttribute("exceptionMessage", e.getMessage());
		}
		return Constant.HOTELGUESTLISTPAGE;
	}

}
