<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/addRoom.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
<%@include file="../css/addRoom.css"%>
<%@include file="../css/exitApp.css"%>
</style>
    
<!--
<link rel="stylesheet" type="text/css" href="../css/addRoom.css">
<title>Insert title here</title>
-->
<script type ="text/javascript" src="javascript/validateForm.js"></script>
</head>
<body>
 <div id="exitApp">
  <a href="logout.htm">
			Logout
		</a>
  </div>
	<h1>Hotel Management System</h1>
    
    <div id="container">
        <div id="header"><h2>Add Room</h2></div>
        <div id="hotelTable">
            <d:if test="${list eq null}">
                <h3>No Hotel Available to Add a Room</h3>
	        </d:if>
            <d:if test="${list ne null}">
                <h4>In Which Hotel Do You Want to Add a Room?</h4>
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
                        <d:forEach items="${list}" var="hotel">
                            <form action="addRoom.htm" method="post">
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
                                <td><input type="hidden" name="hotelId"
                                    value="${hotel.hotelId}"></td>
                                <td><input type="submit" value="Add Room" name="Add Room"></td>
                            </tr>
                            </form>
                        </d:forEach>
                    </table>
                </div>
            </d:if>
        </div>
        <div id="roomSelectForm">
            <d:if test="${hotelId ne 0 }">
		<div id="addR">
			<h2>Add rooms to this hotel</h2>
		</div>

		<c:form name="addRoom" action="addRoomImpl.htm" modelAttribute="room" method="post" onsubmit="return validateRoom()">
			<div id="table2">
				<table>

					<tr>
						<td><c:label path="hotelId">Enter HotelId:</c:label></td>
						<td><input name="hotelId" value="${hotelId}" readonly></td>
					</tr>
					<tr>
						<td><c:label path="roomNo">Enter Room No:</c:label></td>
						<td><c:input path="roomNo" pattern="[1-9]{1}[0-9]{0,}"
								required="required" title="Please Provide Valid Room Number"></c:input></td>
						<td style="color: RED"><c:errors path="roomNo" /></td>
					</tr>
					<tr>
						<td><c:label path="roomType">Room Type</c:label></td>
						<td><c:select path="roomType">
								<c:options items="${roomTypeList}" />

							</c:select></td>
						<td style="color: RED"><c:errors path="roomType" /></td>
					</tr>
					<tr>
						<td><c:label path="perNightRate">Enter  Per Night Rate for the Room:</c:label></td>
						<td><c:input path="perNightRate" pattern="[1-9]{1}[0-9]{1,}"
								required="required" title="Please Provide Valid Value"></c:input></td>
						<td style="color: RED"><c:errors path="perNightRate" /></td>
					</tr>

					<tr>
						<td><c:label path="availability">Availability:</c:label></td>
						<td><c:input path="availability" pattern="[A-Za-z]{1,}"
								placeholder="YES/NO" required="required"></c:input></td>
						<td style="color: RED"><c:errors path="availability" /></td>
					</tr>
				</table>
			</div>
			<div id="save">
				<td><button type="submit">Save</button></td>
			</div>
		</c:form>
	</d:if>
        </div>
    </div>
	<div id="continue">
		<a href="admin.htm">Continue</a>
	</div>

</body>
</html>