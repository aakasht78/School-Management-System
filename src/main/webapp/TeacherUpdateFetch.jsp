<%@page import="details.TeacherInsert"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
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
	<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolmanagement");
	EntityManager em = emf.createEntityManager();
	TeacherInsert t = em.find(TeacherInsert.class, id1);
	%>

	<form action="TeacherUpdate" method="post">
		id: <input type="text" value="<%=t.getId()%>" name="id"> <br><br>
		name: <input type="text" value="<%=t.getName()%>" name="name"><br><br>
		salary: <input type="text" value="<%=t.getSalary()%>" name="salary"><br><br>
		subject: <input type="text" value="<%=t.getSubject()%>"name="subject"><br><br>
		Email: <input type="text" value="<%=t.getEmail()%>"name="email"><br><br>
		Phone Number: <input type="text" value="<%=t.getPhno()%>"name="phno"><br><br>
		<input type="submit" value="Update">
	</form>


	

</body>
</html>