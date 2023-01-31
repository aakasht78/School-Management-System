<%@page import="details.StudentInsert"%>
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
<title>Student Update Jsp</title>
<link rel="shortcut icon" type="image/x-icon" href="https://gdm-catalog-fmapi-prod.imgix.net/ProductLogo/6565bd61-0fe6-459e-9ae4-69ead84c1fc4.png">
</head>
<body>
	<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolmanagement");
	EntityManager em = emf.createEntityManager();
	StudentInsert t = em.find(StudentInsert.class, id1);
	%>

	<form action="StdUpdate" method="post">
		id: <input type="text" value="<%=t.getId()%>" name="id"> <br><br>
		name: <input type="text" value="<%=t.getName()%>" name="name"><br><br>
		Branch: <input type="text" value="<%=t.getBranch()%>" name="branch"><br><br>
		Fees: <input type="text" value="<%=t.getFees()%>"name="fees"><br><br>
		Standard: <input type="text" value="<%=t.getStd()%>"name="std"><br><br>
		Phone Number: <input type="text" value="<%=t.getPhno()%>"name="phno"><br><br>
		<input type="submit" value="Update">
	</form>


	

</body>
</html>