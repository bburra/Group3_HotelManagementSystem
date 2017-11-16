<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@include file="../css/bookingDetailsByDate.css"%>
	<%@include file="../css/exitApp.css"%>
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/bookingDetailsByDate.css">
<title>Insert title here</title>
</head>
<body>
 <div id="exitApp">
  <a href="logout.htm">
			Logout
		</a>
  </div>
    <h1>Hotel Management System</h1>
    <br>
	<c:if test="${list eq null}">
        <br>
		<h2>No Booking for ${message }!!!</h2>
	</c:if>
	<c:if test="${list ne null}">
		<div id="table1">
            <table>
            <caption><h3>Booking Details for ${message }</h3></caption>
			<tr>
				<th>Booking Id</th>
				<th>HotelId</th>
				<th>Room Id</th>
				<th>User Id</th>
				<th>Booked From</th>
				<th>Booked To</th>
				<th>No of Adults</th>
				<th>No of Children</th>
				<th>Amount</th>

			</tr>
			<c:forEach items="${list}" var="bkDetails">
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
        </div>
	</c:if>

	<form action="viewBookingsOnDateSpecified.htm">
		<div id="table2">
        <table>
			<tr>
				<td>Enter Date to Get Booking Details:</td>
				<td><input type="date" name="date" required></td>
			</tr>
			<tr>
				<td colspan=2 align=right><input type="submit"
					value="Get Booking Details"></td>
			</tr>
		</table>
        </div>
	</form>
    <div id="continue">
	<a href="admin.htm">Continue</a>
    </div>

</body>
</html>