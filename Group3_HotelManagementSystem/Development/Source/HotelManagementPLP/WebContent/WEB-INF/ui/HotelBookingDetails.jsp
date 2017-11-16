<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	<%@include file="../css/HotelBookingDetails.css"%>
	<%@include file="../css/exitApp.css"%>
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
<title>Insert title here</title>
</head>
<body>
 <div id="exitApp">
  <a href="logout.htm">
			Logout
		</a>
  </div>
    <h1>Hotel Management System</h1>
	<c:if test="${list eq null}">
        <br>
		<h2>No Hotel Available to Show Booking Details</h2>
	</c:if>

	<c:if test="${list ne null}">
		<div id="table1"><h3>
			Hotel List
		</h3>
		<table>

			<tr>
				<th>Hotel Id</th>
				<th>City</th>
				<th>Hotel Name</th>
				<th>Address</th>
				<th>Description</th>
				<th>Avg Rate Per Night</th>
				<th>Phone1</th>
				<th>Phone2</th>
				<th>Rating</th>
				<th>Fax</th>
			</tr>
			<c:forEach items="${list}" var="hotel">
				<tr>
					<td>${hotel.hotelId}</td>
					<td>${hotel.city}</td>
					<td>${hotel.hotelName}</td>
					<td>${hotel.address}</td>
					<td>${hotel.description}</td>
					<td>${hotel.avgRatePerNight}</td>
					<td>${hotel.phone1}</td>
					<td>${hotel.phone2}</td>
					<td>${hotel.rating}</td>
					<td>${hotel.fax}</td>
					<td><a href="viewBookingsOfHotel.htm?hotelId=${hotel.hotelId}">View
							Booking Of This Hotel</a></td>
				</tr>
			</c:forEach>
		</table>
        </div>
	</c:if>

	<c:if test="${hotelId ne 0 }">
        <div id="table2">
                <br>
		<c:if test="${list2 eq null}">
            <br>
			<h2>${message }</h2>
		</c:if>
		<c:if test="${list2 ne null}">
			<table border="2">
			<caption><h3>Booking Details for Hotel with
				Hotel ID:${hotelId }</h3></caption>
				<tr>
					<th>bookingId</th>
					<th>hotelId</th>
					<th>roomId</th>
					<th>userId</th>
					<th>bookedFrom</th>
					<th>bookedTo</th>
					<th>noOfAdults</th>
					<th>noOfChildren</th>
					<th>amount</th>

				</tr>
				<c:forEach items="${list2}" var="bkDetails">
					<tr>
						<td>${bkDetails.bookingId}</td>
						<td>${bkDetails.hotelId}</td>
						<td>${bkDetails.roomId}</td>
						<td>${bkDetails.userId}</td>
						<td>${bkDetails.bookedFrom}</td>
						<td>${bkDetails.bookedTo}</td>
						<td>${bkDetails.noOfAdults}</td>
						<td>${bkDetails.noOfChildren}</td>
						<td>${bkDetails.amount}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if></div>
	</c:if>
    <div id="continue">
	<a href="admin.htm">Continue</a>
    </div>

</body>
</html>