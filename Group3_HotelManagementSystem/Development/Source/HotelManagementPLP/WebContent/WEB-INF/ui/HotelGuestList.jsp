<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style type="text/css">
	<%@include file="../css/HotelGuestList.css"%>
	<%@include file="../css/exitApp.css"%>
	</style>
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
		<h2>No Hotel Available to Show Guest List</h2>
	</c:if>

	<c:if test="${list ne null}">
        <div id="table1">
        <h3>Hotels List</h3>
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
					<td><a href="viewGuestList.htm?hotelId=${hotel.hotelId}">View
							Guest List Of This Hotel</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>

	<div id="table2">
        <c:if test="${hotelId ne 0 }">
		<font color="Blue"><h3>Guest Details for Hotel with Hotel ID:${hotelId }</h3></font>
		<c:if test="${list2 eq null}">
			<h2>There is no Guest in this Hotel!!!</h2>
		</c:if>

		<c:if test="${list2 ne null}">
			<table border="2">
				<tr>
					<th>userId</th>
					<th>role</th>
					<th>userName</th>
					<th>mobileNo</th>
					<th>phone</th>
					<th>address</th>
					<th>email</th>
				</tr>
				<c:forEach items="${list2}" var="userDetails">
					<tr>
						<td>${userDetails.userId}</td>
						<td>${userDetails.role}</td>
						<td>${userDetails.userName}</td>
<!-- Modified -->                        <td>${userDetails.mobileNo}</td>
						<td>${userDetails.phone}</td>
						<td>${userDetails.address}</td>
						<td>${userDetails.email}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</c:if>
    </div>
    <div id="continue">
	<a href="admin.htm">Continue</a>
</div>


</body>
</html>