package logReg;

import java.io.IOException;

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

import details.StudentInsert;

@WebServlet("/StudentInsert")
public class StudentInsertData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("name");
		int  std =  Integer.parseInt(req.getParameter("std"));
		double fees =Double.parseDouble( req.getParameter("fees"));
		String branch = req.getParameter("branch");
		long phno = Long.parseLong(req.getParameter("mob"));
		
		StudentInsert s = new StudentInsert();
		s.setName(name);
		s.setBranch(branch);
		s.setPhno(phno);
		s.setFees(fees);
		s.setStd(std);

		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("schoolmanagement");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
		
		
		RequestDispatcher rd = req.getRequestDispatcher("Student.html");
		rd.forward(req, resp);
	}
}
