
<%@page import="details.StudentInsert"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Fetch</title>
<link rel="shortcut icon" type="image/x-icon" href="https://gdm-catalog-fmapi-prod.imgix.net/ProductLogo/6565bd61-0fe6-459e-9ae4-69ead84c1fc4.png">
</head>
<body>
<%List<StudentInsert> rs=(List)session.getAttribute("name"); %>
<table cellpadding="20px" border="1">
  <th>id</th>
  <th>name</t>
  <th>fees</th>
  <th>branch</th>
  <th>Phone Number</th>
  <th>Standard</th>
  
 <% for(StudentInsert s : rs){%>
 <tr align="center">
 <td><%=s.getId() %></td>
 <td><%=s.getName() %></td>
 <td><%= s.getFees()%></td>
 <td><%= s.getBranch()%></td>
 <td><%= s.getPhno()%></td>
 <td><%= s.getStd()%></td>
 </tr>
 <%} %>
 </table>
 

</body>
</html>