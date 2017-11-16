<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	<%@include file="../css/deleteHotel.css"%>
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
	<c:if test="${list eq null}"><br><br>
		<h3>No hotel Available</h3>
	</c:if>

	<c:if test="${list ne null}">

		<div id="table1">
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
				<form action="deleteHotelConfirm.htm" method="post">
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
						<td><input type="hidden" name="hiddenHotelId"
							value="${hotel.hotelId}"></td>
						<td><input type="submit" value="Delete Hotel"
							name="Delete Hotel"></td>
							
					</tr>
					</form>
				</c:forEach>
			</table>
			</div>
		
	</c:if>

	<c:if test="${hotel ne null }">
        <br>
            <br>
		<h2>Do You Want to Delete the Hotel?</h2>
        <br>
		<form action="deleteHotelImpl.htm" method="post">
		<div id="table2">
			<table>
				<tr>
					<th>hotelId</th>
					<th>city</th>
					<th>hotelName</th>
					<th>address</th>
					<th>description</th>
					<th>avgRatePerNight</th>
					<th>phone1</th>
					<th>phone2</th>
					<th>rating</th>
					<th>fax</th>
				</tr>
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
					<td><input type="hidden" name="hiddenHotelId"
						value="${hotel.hotelId}"></td>

				</tr>
				<tr>
                    <td></td>
                    <td></td>
                    <td></td>
                     <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                     <td></td>
                    <td></td>
					<td  align=right><input type="submit" value="Yes" name="Delete Hotel"></td>
				</tr>
			</table>
			</div>
		</form>
	</c:if>
    <div id="continue">
	<a href="admin.htm">Continue</a>
    </div>
</body>
</html>