<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--<link rel="stylesheet" type="text/css" href="../css/addHotel.css">-->
    
<style type="text/css">
	<%@include file="../css/addHotel.css"%>
	<%@include file="../css/exitApp.css"%>
	</style>

</head>
<body>
 <div id="exitApp">
  <a href="logout.htm">
			Logout
		</a>
  </div>
	<h1>Hotel Management System</h1>
	<br>
    <div id="box1">
        <h2>Add Hotel</h2>
	   <c:form action="addHotelImpl.htm" modelAttribute="hotel" method="post">
			<table>
				<tr>
					<td><c:label path="city">Enter City:</c:label></td>
					<td><c:input path="city"  pattern="[A-Za-z ]{1,}"
					title="Enter valid Pattern ex:tajHotel" required="required"></c:input></td>
				<td style="color: RED"><c:errors path="city" /></td>
				</tr>
				<tr>
					<td><c:label path="hotelName">Enter Hotel Name:</c:label></td>
					<td><c:input path="hotelName" pattern="[A-Za-z ]{1,}"
							title="Enter valid Pattern ex:tajHotel" required="required"></c:input></td>
				<td style="color: RED"><c:errors path="hotelName" /></td>
				</tr>
				<tr>
					<td><c:label path="address">Enter Address:</c:label></td>
					<td><c:input path="address" required="required"></c:input></td>
				<td style="color: RED"><c:errors path="address" /></td>
				</tr>
				<tr>
					<td><c:label path="description">Enter Description of Hotel:</c:label></td>
					<td><c:input path="description" pattern="[A-Za-z ]{1,}"
							title="Enter valid Pattern ex:AC" required="required"></c:input></td>
				<td style="color: RED"><c:errors path="description" /></td>
				</tr>

				<tr>
					<td><c:label path="avgRatePerNight">Enter Averate Rate Per Night for the Hotel:</c:label></td>
					<td><c:input path="avgRatePerNight"
							pattern="[1-9]{1}[0-9]{1,}" required="required"
							title="It should be a number"></c:input></td>
				<td style="color: RED"><c:errors path="avgRatePerNight" /></td>
				</tr>

				<tr>
					<td><c:label path="phone1">Enter Contact Number:</c:label></td>
					<td><c:input path="phone1" pattern="[1-9]{1}[0-9]{9}"
							title="Phone no. must be 10 digits" required="required"></c:input></td>
				<td style="color: RED"><c:errors path="phone1" /></td>
				</tr>

				<tr>
					<td><c:label path="phone2">Enter Contact Number 2:</c:label></td>
					<td><c:input path="phone2" pattern="[1-9]{1}[0-9]{9}"
							title="Phone no. must be 10 digits" required="required"></c:input></td>
				<td style="color: RED"><c:errors path="phone2" /></td>
				</tr>

				<tr>
					<td><c:label path="rating">Enter Rating Out of 5:</c:label></td>
					<td><c:input path="rating" pattern="[1-5]{1}" 
					title="Range is 1-5"required="required"></c:input></td>
				<td style="color: RED"><c:errors path="rating" /></td>
				</tr>

				<tr>
					<td><c:label path="fax">Enter Fax:</c:label></td>
					<td><c:input path="fax" pattern="[1-9]{1}[0-9]{4}" title="It Should have five digits only"required="required"></c:input></td>
				</tr>

				<tr>
					<td><c:label path="email">Enter Email:</c:label></td>
					<td><c:input path="email"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
							title="Enter valid Email Ex:abc@gmail.com" required="required"></c:input></td>
				<td style="color: RED"><c:errors path="email" /></td>
				</tr>
			</table>
		
        <button type="submit" id="btn">Save</button>
	</c:form>
        </div>
    <div id="logout">
	<a href="admin.htm">Continue</a>
        </div>
</body>
</html>