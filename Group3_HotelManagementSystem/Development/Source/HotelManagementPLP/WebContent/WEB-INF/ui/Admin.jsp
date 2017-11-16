<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Admin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<%@ include file="../css/Admin.css"%>
<%@ include file="../css/exitApp.css"%>
</style>
</head>
<body>
	<div id="logoutBox">
		<jsp:include page="Header.jsp"></jsp:include>
	</div>

	<h1>Hotel Management System</h1>
	<h2>Logged in as ADMIN</h2>
	<div id="successmsg">
	<h3>${message}</h3>
	</div>
	<div id="tableContainer">
		<table>
			<tr>
				<th>Hotel Management</th>
				<th>Room Management</th>
				<th>View Reports</th>
			</tr>
			<tr>
				<td><a href="addHotel.htm">Add</a></td>
				<td><a href="addRoom.htm?hotelId=0">Add</a></td>
				<td><a href="viewHotels.htm">View List of Hotels</a></td>

			</tr>
			<tr>
				<td><a href="deleteHotel.htm">Delete</a></td>
				<td><a href="deleteRoom.htm">Delete</a></td>
				<td><a href="viewBookingsOfHotel.htm?hotelId=0">View
						Booking Details of Specific Hotel </a></td>
			</tr>
			<tr>
				<td><a href="modifyHotel.htm?hotelId=0">Update</a></td>
				<td><a href="modifyRoom.htm?roomId=0">Update</a></td>
				<td><a href="viewGuestList.htm?hotelId=0">View Guest List
						of Specific Hotel</a></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><a href="viewBookingsOnDate.htm">View Booking Details
						for Specified Date</a></td>
			</tr>
		</table>
	</div>
</body>
</html>