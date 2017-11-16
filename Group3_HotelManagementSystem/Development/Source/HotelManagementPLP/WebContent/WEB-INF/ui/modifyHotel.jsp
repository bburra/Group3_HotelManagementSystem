<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	<%@include file="../css/modifyHotel.css"%>
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
	<d:if test="${list eq null}">
        <br>
        <br>
		<h2>No Hotel Available to Modify</h2>
	</d:if>
	<d:if test="${list ne null}">
		<h3>Modify a Hotel</h3>
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
					<th>Email</th>
				</tr>
				<d:forEach items="${list}" var="hotel">
				<form action="modifyHotel.htm" method="post">
	
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
						<td>${hotel.email}</td>
						<td><input type="hidden" name="hotelId"
							value="${hotel.hotelId}"></td>
						<td><input type="submit" value="Modify Hotel"
							name="Modify Hotel"></td>
					</tr>
		
					</form>
				</d:forEach>
			</table>
		</div>
	</d:if>

	<d:if test="${hotelId ne 0 }">
		<c:form action="modifyHotelImpl.htm" modelAttribute="hotel"
			method="post">
            <br>
            <div id="hotelInfo">
			<h3>Hotel info is as follows::</h3>
			</div>
            <div id="table2">
			<table>
				<tr>
					<td><c:label path="hotelId">Enter Hotel Id:</c:label></td>
					<td><input name="hotelId" value="${hotelId}" readonly></td>
				</tr>

				<tr>
					<td><c:label path="city">Enter City:</c:label></td>
					<td><c:input path="city" placeholder="${hotel.city}"
							title="Enter valid Pattern ex:tajHotel" required="true"></c:input></td>
					<td style="color: RED"><c:errors path="city" /></td>
				</tr>

				<tr>
					<td><c:label path="hotelName">Enter Hotel Name:</c:label></td>
					<td><c:input path="hotelName" placeholder="${hotel.hotelName}"
							pattern="[A-Za-z ]{1,}" title="Enter valid Pattern ex:tajHotel"
							required="true"/></td>
					<td style="color: RED"><c:errors path="hotelName" /></td>
				</tr>

				<tr>
					<td><c:label path="address">Enter Address:</c:label></td>
					<td><c:input path="address" placeholder="${hotel.address}"
							 required="true"/></td>
					<td style="color: RED"><c:errors path="address" /></td>
				</tr>
				<tr>
					<td><c:label path="description">Enter Description of Hotel:</c:label></td>
					<td><c:input path="description"
							placeholder="${hotel.description}"
							title="Enter valid Pattern ex:AC" pattern="[A-Za-z ]{1,}"
							required="true"/></td>
					<td style="color: RED"><c:errors path="description" /></td>
				</tr>


				<tr>
					<td><c:label path="avgRatePerNight">Enter Average Rate Per Night :</c:label></td>
					<td><c:input path="avgRatePerNight"
							placeholder="${hotel.avgRatePerNight}"
							pattern="[1-9]{1}[0-9]{1,}" title="It should be a number"
							required="true"/></td>
					<td style="color: RED"><c:errors path="avgRatePerNight" /></td>
				</tr>

				<tr>
					<td><c:label path="phone1">Enter Contact Number:</c:label></td>
					<td><c:input path="phone1" placeholder="${hotel.phone1}"
							title="Phone no. must be 10 digits" pattern="[1-9]{1}[0-9]{9}"
							required="true"/></td>
					<td style="color: RED"><c:errors path="phone1" /></td>
				</tr>
				<tr>
					<td><c:label path="phone2">Enter Contact Number 2:</c:label></td>
					<td><c:input path="phone2" placeholder="${hotel.phone2}"
							required="true"/></td>
					<td style="color: RED"><c:errors path="phone2" /></td>
				</tr>
				<tr>
					<td><c:label path="rating">Enter Rating Out of 5:</c:label></td>
					<td><c:input path="rating" placeholder="${hotel.rating}"
							title="Range is 1-5" pattern="[1-5]{1}" required="true"/></td>
					<td style="color: RED"><c:errors path="rating" /></td>
				</tr>

				<tr>
					<td><c:label path="fax">Enter Fax:</c:label></td>
					<td><c:input path="fax" placeholder="${hotel.fax}"
							title="It Should have five digits only"
							pattern="[1-9]{1}[0-9]{4}" required="true"/></td>
					<td style="color: RED"><c:errors path="email" /></td>
				</tr>
				<tr>
					<td><c:label path="email">Enter Email:</c:label></td>
					<td><c:input path="email" placeholder="${hotel.email }"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
							title="Enter valid Email Ex:abc@gmail.com" required="true" /></td>
					<td style="color: RED"><c:errors path="email" /></td>
				</tr>
				<tr>
                    <td></td>
					<td><input type="submit" value="Update"
						name="Update"></td>
				</tr>
			</table>
            </div>
		</c:form>

	</d:if>
    <div id="continue">
	<a href="admin.htm">Continue</a>
        </div>
</body>
</html>