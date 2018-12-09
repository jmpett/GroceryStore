<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body  {
	background: darkblue;
    background: url(https://boygeniusreport.files.wordpress.com/2015/06/grocery-store.jpg) no-repeat center center fixed;
	background-size: cover;
}
form {
	text-align: center;
	color:white;
	font-weight: bold;
	font-size: 125%;
	text-shadow: 2px 2px #FF0000;
}
p {
	text-align: center;
	font-size: 150%;
	text-shadow: 2px 2px #00008B;
}
/* unvisited link */
a:link {
    color: orange;
    font-weight: bold;
    text-decoration: none;
}

/* visited link */
a:visited {
    color: orange;
    font-weight: bold;
    text-decoration: none;
}

/* mouse over link */
a:hover {
    color: white;
    font-weight: bold;
    text-decoration: none;
}

/* selected link */
a:active {
    color: white;
    font-weight: bold;
    text-decoration: none;
}
</style>
<script>
function validateForm() {
    var w = document.forms["editItem"]["item"].value;
    var x = document.forms["editItem"]["deptID"].value;
    var y = document.forms["editItem"]["department"].value;
    var z = document.forms["editItem"]["price"].value;
    if (w == "") {
        alert("Item must be filled out");
        return false;
    }
    else if (x == "") {
        alert("DeptID must be filled out");
        return false;
    }
    else if (y == "") {
        alert("Department must be filled out");
        return false;
    }
    else if (z == "") {
        alert("Price must be filled out");
        return false;
    }
} 
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Item</title>
</head>
<body>
<form name="editProduce" action = "editProduceServlet" method="post" onsubmit="return validateForm()">
Item: <input type ="text" name = "item" value= "${itemToEdit.item}">
DeptID: <input type = "text" name = "deptID" value= "${itemToEdit.deptID}">
Department: <input type = "text" name = "department" value= "${itemToEdit.department}">
Price: <input type = "text" name = "price" value= "${itemToEdit.price}">
<input type = "hidden" name = "itemID" value = "${itemToEdit.itemID}">
<input type = "submit" value="Save Edited Item">
</form>
<p>
<a href = "viewAllProduce">View complete list</a><br />
<a href = "startPage.html">Back to login</a><br />
</p>
</body>
</html>