
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
	<%@include file="../css/deleteRoom.css"%>
	</style>
    <link rel="stylesheet" type="text/css" href="../css/deleteRoom.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>Insert title here</title>
</head>
<body>
    <h1>Hotel Management System</h1>
	<c:if test="${list eq null}">
        <br>
		<h3>No Room Available</h3>
	</c:if>

	<c:if test="${list ne null}">
        <br>
		<h2>Delete a room</h2>
        <br>
		<div id="box1">
			<table>
				<tr>
					<th>Room Id</th>
					<th>Hotel Id</th>
					<th>Room No</th>
					<th>Room Type</th>
					<th>Per Night Rate</th>
					<th>Availability</th>
				</tr>
				<c:forEach items="${list}" var="room">
			<form action="deleteRoomConfirm.htm" method="post">
					<tr>
						<td>${room.roomId}</td>
						<td>${room.hotelId}</td>
						<td>${room.roomNo}</td>
						<td>${room.roomType}</td>
						<td>${room.perNightRate}</td>
						<td>${room.availability}</td>
						<td><input type="hidden" name="hiddenRoomId"
							value="${room.roomId}"></td>
						<td><input type="submit" value="Delete room"
							name="Delete room"></td>
					</tr>
					</form>

				</c:forEach>
			</table>
        </div>
            <br>
		
	</c:if>

	<c:if test="${room ne null }">
        <div id="deleteSure">
		<h2>Do you want to delete the room?</h2>
        </div>
        <br>
		<form action="deleteRoomImpl.htm" method="post">
            <div id="box2">
			<table>
				<tr>
					<th>Room Id</th>
					<th>Hotel Id</th>
					<th>Room No</th>
					<th>Room Type</th>
					<th>Per Night Rate</th>
					<th>Availability</th>
				</tr>
				<tr>
					<td>${room.roomId}</td>
					<td>${room.hotelId}</td>
					<td>${room.roomNo}</td>
					<td>${room.roomType}</td>
					<td>${room.perNightRate}</td>
					<td>${room.availability}</td>
					<td><input type="hidden" name="hiddenRoomId"
						value="${room.roomId}"></td>
				</tr>
				<tr>
                    <td></td><td></td><td></td><td></td><td></td>
				<td><input type="submit" value="Yes"
						name="Delete room"></td>
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