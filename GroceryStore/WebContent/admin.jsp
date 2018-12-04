<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin List</title>
<style>
/* CSS Coding */
body  {
	text-align: center;
    background: url(https://boygeniusreport.files.wordpress.com/2015/06/grocery-store.jpg) no-repeat center center fixed;
	background-size: cover;
}
h1 {
	color: white;
	text-shadow: 2px 2px #FF0000;
	font-size: 250%;
	text-align: center;
}
table {
    font-size: 125%;
    color:white;
    text-shadow: 2px 2px #000000;
}
p {
    text-align: center;
    font-size: 125%;
    text-shadow: 2px 2px #FF0000;
}
/* unvisited link */
a:link {
    color: white;
    font-weight: bold;
    text-decoration: none;
}

/* visited link */
a:visited {
    color: white;
    font-weight: bold;
    text-decoration: none;
}

/* mouse over link */
a:hover {
    color: orange;
    font-weight: bold;
    text-decoration: none;
}

/* selected link */
a:active {
    color: orange;
    font-weight: bold;
    text-decoration: none;
}
</style>
</head>
<body>
<h1>Complete List</h1>
<form action = "editListServlet" method="post">
<table align="center">
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
   <td align="left"><input type="radio" name="itemID" value="${currentitem.itemID}"></td>
   <td align="left">${currentitem.item}</td>
   <td align="left">${currentitem.deptID}</td>
   <td align="left">${currentitem.department}</td>
   <td align="left">${currentitem.price}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "Edit Selected Item" name="doThisToItem">
<input type = "submit" value = "Delete Selected Item" name="doThisToItem">
<input type = "submit" value = "Add New Item" name = "doThisToItem"><br />
</form>
<p>
<a href = "startPage.html">Back to login</a><br />
</p>
</body>
</html>

