<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="https://gdm-catalog-fmapi-prod.imgix.net/ProductLogo/6565bd61-0fe6-459e-9ae4-69ead84c1fc4.png">
</head>
<body>
<%ResultSet rs=(ResultSet)session.getAttribute("empdetails"); %>
<table cellpadding="20px" border="1">
  <th>e_name</th>
  <th>sal</th>
  <th>id_no</th>
  
 <% while(rs.next()){%>
 <tr align="center">
 <td><%= rs.getString(1) %></td>
 <td><%=rs.getInt(2) %></td>
 <td><%=rs.getInt(3) %></td>
 </tr>
 <%} %>
 </table>
 

</body>
</html>