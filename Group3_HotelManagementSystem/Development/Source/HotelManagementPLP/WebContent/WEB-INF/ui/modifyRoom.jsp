<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file="../css/modifyRoom.css"%>
<%@include file="../css/exitApp.css"%>
</style>
<!--<link rel="stylesheet" type="text/css" href="../css/modifyRoom.css">-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type ="text/javascript" src="javascript/validateForm.js"></script>
</head>
<body>
 <div id="exitApp">
  <a href="logout.htm">
			Logout
		</a>
  </div>
	<h1>Hotel Management System</h1>
	<a:if test="${list eq null}">
		<h2>No Room Available to Modify</h2>
	</a:if>


	<a:if test="${list ne null}">
		<h3>Modify a Room</h3>
		<br>
<div id="table1">
		<table>
			<tr>
				<th>Room Id</th>
				<th>Hotel Id</th>
				<th>Room No</th>
				<th>Room Type</th>
				<th>Per Night Rate</th>
				<th>Availability</th>
			</tr>
			<a:forEach items="${list}" var="room">
				<form action="modifyRoom.htm" method="post">
					<tr>
						<td>${room.roomId}</td>
						<td>${room.hotelId}</td>
						<td>${room.roomNo}</td>
						<td>${room.roomType}</td>
						<td>${room.perNightRate}</td>
						<td>${room.availability}</td>
						<td><input type="hidden" name="roomId" value="${room.roomId}"></td>
						<td><input type="submit" value="Modify Room"
							name="Modify Room"></td>
					</tr>
				</form>
			</a:forEach>
		</table>
</div>
	</a:if>


	<a:if test="${roomId ne 0}">
		<c:form  name="addRoom" action="modifyRoomImpl.htm" modelAttribute="room"
			method="post" onsubmit="return validateRoom()">
			<br>
			<div id="roomInfo">
			<h3>Room info is as follows::</h3>
			<br>
			<div id="table2">
			<table>
				<tr>
					<td><c:label path="roomId">Enter Room Id:</c:label></td>
					<td><c:input path="roomId" value="${room.roomId}"
							readonly="true" /></td>
				</tr>

				<tr>
					<td><c:label path="hotelId">Enter Hotel Id:</c:label></td>
					<td><c:input path="hotelId" placeholder="${room.hotelId}"
							readonly="true" /></td>
				</tr>

				<!-- this is what we are modifying -->



				<tr>
					<td><c:label path="roomNo">Enter Room No:</c:label></td>
					<td><c:input path="roomNo" pattern="[1-9]{1}[0-9]{1,}"
							title="It should be a number" placeholer="${room.roomNo}"
							required="true" /></td>
					<td style="color: RED"><c:errors path="roomNo" /></td>
				</tr>

				<!-- Here you will get the values of roomtype list from controller in list -->
				<tr>
					<td><c:label path="roomType">Room Type</c:label></td>
					<td><c:select path="roomType" 
							placeholer="${room.roomType}">
							
							<c:options items="${roomTypeList}" />
						</c:select></td>
					<td style="color: RED"><c:errors path="roomType" /></td>
				</tr>
				<tr>
					<td><c:label path="perNightRate">Enter PerNightRate:</c:label></td>
					<td><c:input path="perNightRate" pattern="[1-9]{1}[0-9]{1,}"
							title="It should be a number" placeholer="${room.perNightRate}"
							required="true" /></td>
					<td style="color: RED"><c:errors path="perNightRate" /></td>
				</tr>


				<tr>
					<td><c:label path="availability">Enter Availability:</c:label></td>
					<td><c:input path="availability" title="Enter YES/NO"
							placeholer="${room.availability}" pattern="[A-Za-z]{1,4}"
							required="true" /></td>
					<td style="color: RED"><c:errors path="availability" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" 
						value="update" name="update"></td>
				</tr>

			 </table>
	       </div>
		</c:form>
    </div>
	</a:if>
	<div id="continue">
		<a href="admin.htm">Continue</a>
	</div>
</body>
</html>