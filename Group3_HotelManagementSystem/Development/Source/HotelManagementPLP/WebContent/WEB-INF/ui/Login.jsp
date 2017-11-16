
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <style type="text/css">
	<%@include file="../css/Login.css"%>
	</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFF0">

	<h1>Hotel Management System</h1>
    <div id="loginDiv">
        <h2>Admin Login Page</h2>
		<h3 id="errorMessage">${message }</h3>
        <c:form action="checkLogin.htm" modelAttribute="admin" method="post">
            <p>
                <c:label path="id">Admin ID
				</c:label>
                <c:input path="id" required="required"></c:input>
            </p>
            <p>
                <c:label path="password">Password</c:label>
                <c:input path="password" type="password" required="required"></c:input>
            </p>
           <p class="button">
					<input type="submit" value="Login">
            </p>
        </c:form>
    </div>
<!--
	<div id="box1">
		<h2>Admin Login Page</h2>
		<h3>${message }</h3>
		
            <div id="formContainer">
                <c:form action="checkLogin.htm" modelAttribute="admin" method="post">
                <table>
				<tr>
					<td>
						<div id="aid">
							<c:label path="id">Admin ID
				</c:label>
						</div>
					</td>
					<td><div id="aidBox">
							<c:input path="id" required="required"></c:input>
						</div></td>
				</tr>
				<tr>
					<td>
						<div id="pass">
							<c:label path="password">Password</c:label>
						</div>
					</td>
					<td>
						<div id="passBox">
							<c:input path="password" type="password" required="required"></c:input>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan=2 align=right>
					<p class="button">
					<input type="submit" value="Login">
					</p>
					</td>
				</tr>
			</table>
		</c:form>
            </div>
	</div>
-->
	<!--
    <div id="box1">
    <h2>Admin Login Page</h2>
	<form action="checkLogin.htm">
		<table>
			<tr>
				<td><div id="aid">Admin ID</div></td>
				<td><div id="aidBox">
                    <input type="text" name="id" value="System" required/>
                    </div></td>
			</tr>
			<tr>
                <td><div id="pass">Password</div></td>
				<td>
                    <div id="passBox">
                    <input type="password" name="password" id="password" value="Capgemini123" required />
                        </div>
                </td>
			</tr>
			<tr>
                
				<td colspan=2 align=right>
                    <p class="button">
                    <input type="submit" value="Login" />
                    </p>
                </td>
			</tr>
		</table>
	</form>
    </div>
-->
	<!--
	<h3>
		<div id="errorMessage"><font color="red">${message }</font>
        </div>
	</h3>
-->

</body>
</html>