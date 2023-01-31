
<%@page import="details.TeacherInsert"%>
<%@page import="details.StudentInsert"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Fetch</title>
<link rel="shortcut icon" type="image/x-icon" href="https://gdm-catalog-fmapi-prod.imgix.net/ProductLogo/6565bd61-0fe6-459e-9ae4-69ead84c1fc4.png">
</head>
<body>
<%List<TeacherInsert> rs=(List)session.getAttribute("name"); %>
<table cellpadding="20px" border="1">
  <th>id</th>
  <th>name</t>
  <th>Salary</th>
  <th>Subject</th>
  <th>Phone Number</th>
  <th>Eamil</th>
  
 <% for(TeacherInsert s : rs){%>
 <tr align="center">
 <td><%=s.getId() %></td>
 <td><%=s.getName() %></td>
 <td><%= s.getSalary()%></td>
 <td><%= s.getSubject()%></td>
 <td><%= s.getPhno()%></td>
 <td><%= s.getEmail()%></td>
 </tr>
 <%} %>
 </table>
 

</body>
</html>