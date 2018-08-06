<%@page import="com.example.fruit.model.Fruit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

   <%-- <form action="addFruit">
    Id <input type="text" name="id"><br>
    Name <input type="text" name="name"><br>
    Shape<input type="text" name="shape"><br>
    Season<input type="text" name="season"><br>
    Color <input type="text" name="color"><br>
    Taste<input type="text" name="taste"><br>
     <input type="submit"><br>
   </form>
   
   <b>Get Fruit by Id </b><br>
   <form action="getFruit">
    Id <input type="text" name="id"><br>
     <input type="submit"><br>
   </form>
   
   
   <br>
   <br><br> --%>
   
   
   
   
   <div align="center">
		<h1>Fruits</h1>
		<h3>
			<a href="newFruit">Add Fruit</a>
		</h3>
		<table border="1">
      <tr>
			<th>Name</th>
			<th>Color</th>
			<th>Season</th>
			<th>Taste</th>
			<th>Shape</th>
			<th>Action</th>
      </tr>
			<% java.util.List<Fruit> fruits = (java.util.ArrayList<Fruit>) request.getAttribute("listFruits");%>
				<% for(Fruit fruit:fruits){%>
				<tr>

					<td><%=fruit.getName()%></td>
					<td><%=fruit.getColor()%></td>
					<td><%=fruit.getSeason()%></td>
					<td><%=fruit.getTaste()%></td>
					<td><%=fruit.getShape()%></td>
					<td><a href="editFruit?id=<%=fruit.getId() %>">Edit</a> <a
						href="deleteFruit?id=<%=fruit.getId() %>">Delete</a></td>

				</tr>
				<% }%>
			
		</table>
	</div>
</body>
</html>