package logReg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import details.TeacherInsert;

@WebServlet("/TeacherDelete")
public class TeacherDelete extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id= Integer.parseInt( req.getParameter("id"));
		
		
		PrintWriter pw = resp.getWriter();
		
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("schoolmanagement");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		TeacherInsert t = em.find(TeacherInsert.class, id);
		if( t != null) {
		et.begin();
		em.remove(t);
		et.commit();
		System.out.println("Success");
		RequestDispatcher rd = req.getRequestDispatcher("TeacherDashbord.html");
		rd.forward(req, resp);
		}
		else {
			pw.println("Invalid.... Try again");
			RequestDispatcher rd = req.getRequestDispatcher("TeacherDelete.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}

	
	}
}
