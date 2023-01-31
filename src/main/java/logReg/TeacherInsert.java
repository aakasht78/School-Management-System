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


@WebServlet("/TeacherInsert")
public class TeacherInsert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		double salary =Double.parseDouble( req.getParameter("salary"));
		String subject = req.getParameter("subject");
		String email = req.getParameter("email");
		long phno = Long.parseLong(req.getParameter("mob"));
		
		details.TeacherInsert s = new details.TeacherInsert();
		s.setName(name);
		s.setSalary(salary);
		s.setSubject(subject);
		s.setEmail(email);
		s.setPhno(phno);

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
