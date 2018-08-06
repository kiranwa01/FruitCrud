<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fruits Management</title>
</head>
<body>

 <div align="center">
        <h1>Add/Edit Fruit</h1>
        <form:form action="addFruit" method="post" modelAttribute="fruit">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><form:input path="color" /></td>
            </tr>
            <tr>
                <td>Shape:</td>
                <td><form:input path="shape" /></td>
            </tr>
            <tr>
                <td>Season:</td>
                <td><form:input path="season" /></td>
            </tr>
            <tr>
                <td>Taste:</td>
                <td><form:input path="taste" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
 </div>
</body>
</html>